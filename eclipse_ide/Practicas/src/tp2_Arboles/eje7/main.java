package tp2_Arboles.eje7;

import tp2_Arboles.eje1.BinaryTree;

public class main {
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(2);

		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		BinaryTree<Integer> nodoNeg5 = new BinaryTree<>(-5);
		BinaryTree<Integer> nodo23 = new BinaryTree<>(23);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		BinaryTree<Integer> nodo19 = new BinaryTree<>(19);
		BinaryTree<Integer> nodoNeg3 = new BinaryTree<>(-3);
		BinaryTree<Integer> nodo55 = new BinaryTree<>(55);
		BinaryTree<Integer> nodo11 = new BinaryTree<>(11);
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo18 = new BinaryTree<>(18);

		arbol.addLeftChild(nodo7);
		arbol.addRightChild(nodoNeg5);

		nodo7.addLeftChild(nodo23);
		nodo7.addRightChild(nodo6);

		nodoNeg5.addLeftChild(nodo19);

		nodo23.addLeftChild(nodoNeg3);
		nodo6.addLeftChild(nodo55);
		nodo6.addRightChild(nodo11);

		nodo19.addRightChild(nodo4);
		nodo4.addLeftChild(nodo18);

		arbol.inOrder();
		System.out.println("-----");
		ParcialArboles<Integer> casa = new ParcialArboles<>(arbol);

		System.out.println(casa.isLeftTree(2));
		/*
		 * 2 / \ 7 -5 / \ / 23 6 19 / / \ \ -3 55 11 4 / 18
		 * 
		 */
	}
}
