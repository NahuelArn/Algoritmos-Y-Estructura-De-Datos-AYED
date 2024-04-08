package tp2_Arboles.eje5;

import tp2_Arboles.eje1.BinaryTree;

public class Pruebarda {
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<>(10);
		BinaryTree<Integer> a1 = new BinaryTree<>(2);
		BinaryTree<Integer> a2 = new BinaryTree<>(3);
		a.addLeftChild(a1);
		a.addRightChild(a2);

		ProfundidadDeArbolBinario casa = new ProfundidadDeArbolBinario(a);

		System.out.println("suma: " + casa.sumaElementosProfundidad(0));
	}
}
