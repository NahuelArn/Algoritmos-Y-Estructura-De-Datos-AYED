package ResumenAlgoritmos.Practica2.eje4;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> a;

	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.a = a;
	}

	private int helper(BinaryTree<Integer> a) {
		int izq = 0;
		int der = 0;
		if (a.isLeaf()) {
			return a.getData();
		} else {
			if (a.hasLeftChild()) {
				izq = helper(a.getLeftChild());
			}
			if (a.hasRightChild()) {
				der = helper(a.getRightChild());
			}
			return Math.max(izq, der) + a.getData();
		}
	}

	public int retardoReenvio() {
		int total = 0;
		if (!a.isEmpty()) {
			total = helper(a);
		}
		return total;
	}

	public static void main(String[] args) {
		// Crear el árbol binario y agregar datos de ejemplo
		BinaryTree<Integer> tree = new BinaryTree<>(10);
		tree.addLeftChild(new BinaryTree<>(3));
		tree.addRightChild(new BinaryTree<>(8));
		tree.getLeftChild().addLeftChild(new BinaryTree<>(9));
		tree.getLeftChild().addRightChild(new BinaryTree<>(12));
		tree.getRightChild().addLeftChild(new BinaryTree<>(5));
		tree.getRightChild().addRightChild(new BinaryTree<>(7));

		RedBinariaLlena red = new RedBinariaLlena(tree);
		// en profundidad
		System.out.println("Mayor retardo: " + red.retardoReenvio());
	}
}
