package tp2_Arboles.eje123456new.eje6;

import tp2_Arboles.eje123456new.eje1.BinaryTree;

public class main {
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(1);

		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<>(3);

		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);

		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		BinaryTree<Integer> nodo8 = new BinaryTree<>(8);

		arbol.addLeftChild(nodo2);
		arbol.addRightChild(nodo3);

		nodo2.addRightChild(nodo4);

		nodo3.addLeftChild(nodo5);
		nodo3.addRightChild(nodo6);

		nodo5.addLeftChild(nodo7);
		nodo5.addRightChild(nodo8);

		Transformacion trans = new Transformacion(arbol);
		arbol.inOrderr();
		System.out.println();
		arbol = trans.suma();

		arbol.inOrderr();
	}
}
