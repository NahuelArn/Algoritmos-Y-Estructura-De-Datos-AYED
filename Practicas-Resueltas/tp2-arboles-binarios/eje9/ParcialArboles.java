package tp2_Arboles.eje9;

import tp2_Arboles.eje1.BinaryTree;

public class ParcialArboles {

	private void helper(BinaryTree<Integer> arbol, BinaryTree<Operacional> nuevoArbol, int suma, int wopa) {
		int valorActual = arbol.getData();
		Operacional op = new Operacional();
		op.setSuma(valorActual + suma);
		op.setDiferencia(valorActual - wopa);
		nuevoArbol.setData(op);
//		BinaryTree<Operacional> ayudin = new BinaryTree<>();
		if (arbol.hasLeftChild()) {
			nuevoArbol.addLeftChild(new BinaryTree<>());
			helper(arbol.getLeftChild(), nuevoArbol.getLeftChild(), suma + valorActual, valorActual); // suma recorrido, valor padre
		}

		if (arbol.hasRightChild()) {
			nuevoArbol.addRightChild(new BinaryTree<>());
			helper(arbol.getRightChild(), nuevoArbol.getRightChild(), suma + valorActual, valorActual);
		}
	}

	public BinaryTree<Operacional> sumAndDif(BinaryTree<Integer> arbol) {
		BinaryTree<Operacional> nuevoArbol = new BinaryTree<>();
		if (!arbol.isEmpty()) {
			helper(arbol, nuevoArbol, 0, 0);
		}
		return nuevoArbol;
	}
}
