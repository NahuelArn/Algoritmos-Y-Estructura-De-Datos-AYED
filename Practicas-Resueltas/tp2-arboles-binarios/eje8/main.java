package tp2_Arboles.eje8;

import tp2_Arboles.eje1.BinaryTree;;

public class main {
	public static void main(String[] args) {

		// Crear el árbol 1
		BinaryTree<Integer> arbol1 = new BinaryTree<>(65);
		BinaryTree<Integer> nodo37 = new BinaryTree<>(37);
		BinaryTree<Integer> nodo47 = new BinaryTree<>(47);
		BinaryTree<Integer> nodo81 = new BinaryTree<>(83);
		BinaryTree<Integer> nodo93 = new BinaryTree<>(93); // 93

		arbol1.addLeftChild(nodo37);
		arbol1.addRightChild(nodo81);
		nodo37.addRightChild(nodo47);
		nodo81.addRightChild(nodo93);

		// Crear el árbol 2
		BinaryTree<Integer> arbol2 = new BinaryTree<>(65);
		BinaryTree<Integer> nodo37_2 = new BinaryTree<>(37);
		BinaryTree<Integer> nodo47_2 = new BinaryTree<>(47);
		BinaryTree<Integer> nodo81_2 = new BinaryTree<>(83);
		BinaryTree<Integer> nodo76 = new BinaryTree<>(72);
		BinaryTree<Integer> nodo93_2 = new BinaryTree<>(93);

		arbol2.addLeftChild(nodo37_2);
		arbol2.addRightChild(nodo81_2);
		nodo37_2.addLeftChild(new BinaryTree<>(22));
		nodo37_2.addRightChild(nodo47_2);
		nodo81_2.addLeftChild(nodo76);
		nodo81_2.addRightChild(nodo93_2);

		// Crear instancias de ParcialArboles
		ParcialArboles parcialArboles = new ParcialArboles();
		// Verificar si cumplen con las condiciones especificadas
		System.out.println("¿El árbol cumple con la condición? " + parcialArboles.esPrefijo(arbol1, arbol2));
	}
	/*
	 * arbol 1 65 / \ 37 81 \ \ 47 93
	 * 
	 * arbol 2 65 / \ 37 81 / \ / \ 22 47 76 93
	 */
}
