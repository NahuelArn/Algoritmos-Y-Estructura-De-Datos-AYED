package tp2_Arboles.eje9;

import tp2_Arboles.eje1.BinaryTree;

public class main {
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(20);
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo30 = new BinaryTree<>(30);
		BinaryTree<Integer> nodoNeg5 = new BinaryTree<>(-5);
		BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
		BinaryTree<Integer> nodo50 = new BinaryTree<>(50);
		BinaryTree<Integer> nodoNeg9 = new BinaryTree<>(-9);
		BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);

		arbol.addLeftChild(nodo5);
		arbol.addRightChild(nodo30);

		nodo5.addLeftChild(nodoNeg5);
		nodo5.addRightChild(nodo10);

		nodo30.addLeftChild(nodo50);
		nodo30.addRightChild(nodoNeg9);

		nodo10.addLeftChild(nodo1);
		nodo50.addRightChild(nodo4);
		nodo4.addRightChild(nodo6);

		// Crear instancia de ParcialArboles
		ParcialArboles parcialArboles = new ParcialArboles();

		// Obtener el nuevo árbol con las sumas y diferencias
		BinaryTree<Operacional> nuevoArbol = new BinaryTree<>();

		// Imprimir el nuevo árbol
		System.out.println("Árbol original:");
		arbol.inOrder();
		System.out.println("Nuevo árbol con sumas y diferencias:");
		nuevoArbol = parcialArboles.sumAndDif(arbol);

		System.out.println(nuevoArbol.getData().toString());
		System.out.println(nuevoArbol.getLeftChild().toString());
		System.out.println(nuevoArbol.getRightChild().toString());
		System.out.println("entra");
	}

}

//		20
//	   /  \
//	  5    30
//     / \   / \
//   -5  10 50 -9
//      /    \
//     1      4
//             \6