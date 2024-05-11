package tp2_Arboles.eje7.sinClaseHelper;

import tp2_Arboles.eje1.BinaryTree;

public class main {
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(0);
		
		BinaryTree<Integer> arbol3 = new BinaryTree<>(3);
		BinaryTree<Integer> arbol9 = new BinaryTree<>(9);
		BinaryTree<Integer> arbol2 = new BinaryTree<>(2);
		
		arbol.addLeftChild(arbol3);
		arbol.getLeftChild().addLeftChild(arbol9);
		arbol.getLeftChild().addRightChild(arbol2);
		//---------------rama derecha -------------------
		BinaryTree<Integer> arbol8 = new BinaryTree<>(8);
		BinaryTree<Integer> arbol1 = new BinaryTree<>(1);
		BinaryTree<Integer> arbol4 = new BinaryTree<>(4);
		arbol.addRightChild(arbol8);
		arbol.getRightChild().addLeftChild(arbol1);
		arbol.getRightChild().addRightChild(arbol4);
		//----------------seteando-------------
		
		ParcialArboles busqueda = new ParcialArboles(arbol);
		System.out.println();
		arbol.inOrder();
		System.out.println();
		System.out.println("estado: "+busqueda.isLeftTree(0));
		
	}
}

/*
 * 
 * 				0
 *            /    \
 *           3      8
 *         /   \  /   \
 *        9    2  1    4
 * 
 * 
 * */


