package tp2_Arboles.eje6;

import tp2_Arboles.eje1.BinaryTree;

public class Pruebarda {
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<>(1);
		BinaryTree<Integer> a1 = new BinaryTree<>(2);
		BinaryTree<Integer> a2 = new BinaryTree<>(3);
		a.addLeftChild(a1);
		a.addRightChild(a2);

		a1.addRightChild(new BinaryTree<Integer>(4));

		a2.addLeftChild(new BinaryTree<Integer>(5));
		a2.addRightChild(new BinaryTree<Integer>(6));
		a2.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		a2.getRightChild().addRightChild(new BinaryTree<Integer>(8));
		Transformacion casa = new Transformacion(a);

		System.out.println("antes ");
		a.inOrder();

		System.out.println("despues ");
		casa.suma().inOrder();
	}
}
