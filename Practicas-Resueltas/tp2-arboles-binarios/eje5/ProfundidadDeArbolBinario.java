package tp2_Arboles.eje5;

import tp2_Arboles.eje1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> a;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		this.a = a;
	}

	private int helper(BinaryTree<Integer> a, int profundidad, int nivelActual) {
		if (a.isEmpty()) {
			return 0;
		} else {
			if ((nivelActual < profundidad) && (!a.isLeaf())) {
				return a.getData() + helper(a.getLeftChild(), profundidad, nivelActual + 1) + (helper(a.getRightChild(), profundidad, nivelActual + 1));
			} else
				return a.getData();
		}
	}

	public int sumaElementosProfundidad(int profundidad) {
		int nivelActual = 0;
		return helper(this.a, profundidad, nivelActual);
	}

}
