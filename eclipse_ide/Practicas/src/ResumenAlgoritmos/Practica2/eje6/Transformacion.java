package ResumenAlgoritmos.Practica2.eje6;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> a;

	public Transformacion(BinaryTree<Integer> a) {
		this.a = a;
	}

	public int helper(BinaryTree<Integer> a) {
		int izq = 0;
		int der = 0;
		if (a.isLeaf()) { // tengo que ir salvando valores o se pierden
			int aux = a.getData();
			a.setData(0);
			return aux;
		} else {
			if (a.hasLeftChild()) {
				izq = helper(a.getLeftChild());
			}
			if (a.hasRightChild()) {
				der = helper(a.getRightChild());
			}
			int valorActualData = a.getData();
			int sumaAbajo = izq + der;
			a.setData(sumaAbajo);
			return valorActualData + sumaAbajo;
		}
	}

	public BinaryTree<Integer> suma() {// que calidaddd
		if (!a.isEmpty()) {
			helper(a);
		}
		return a;
	}

	public static void main(String[] args) {
		// Crear el arbol binario y agregar datos de ejemplo
		BinaryTree<Integer> tree = new BinaryTree<>(10);
		tree.addLeftChild(new BinaryTree<>(3));
		tree.addRightChild(new BinaryTree<>(8));
		tree.getLeftChild().addLeftChild(new BinaryTree<>(9));
		tree.getLeftChild().addRightChild(new BinaryTree<>(12));
		tree.getRightChild().addLeftChild(new BinaryTree<>(5));
		tree.getRightChild().addRightChild(new BinaryTree<>(7));

		Transformacion transformacion = new Transformacion(tree);
		BinaryTree<Integer> transformedTree = transformacion.suma();

		// Imprimir el arbol transformado
		transformedTree.inOrden();
	}
}
