package tp2_Arboles.eje6;

import tp2_Arboles.eje1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> a;

	public Transformacion(BinaryTree<Integer> a) {
		this.a = a;
	}

	private int sumarda(int a, int b) {
		return a + b;
	}

	private int helper(BinaryTree<Integer> a) { // para hacerlo recursivo, si o si ncesito la estrucutr
		if (a == null) {
			return 0;
		} else {
			if (!a.isLeaf()) {
//				System.out.println("suma " + sumarda(helper(a.getLeftChild()), helper(a.getRightChild())));
				a.setData(sumarda(helper(a.getLeftChild()), helper(a.getRightChild())));
//				if (a.hasLeftChild()) { //
//					a.getLeftChild().setData(0);
//				}
//				if (a.hasRightChild()) {
//					a.getRightChild().setData(0);
//				}
			} else {
				BinaryTree<Integer> aux = new BinaryTree<>();
				aux.setData(a.getData());
				a.setData(0);
				return aux.getData();
			}
		}
		return 0;
	}

	public BinaryTree<Integer> suma() {
		helper(this.a);
		System.out.println();
		return a;
	}
}
