package tp2_Arboles.eje123456new.eje6;

import tp2_Arboles.eje123456new.eje1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol = new BinaryTree<>();

	public Transformacion(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	// en este modulo se encaran la suma de los hijos, impactando al padre
	// y la suma del padre + los hijos impactando a la raiz
	private int helper(BinaryTree<Integer> arbol) {
		int sumIz = 0;
		int sumDe = 0;
		int salvado = 0;
		if (arbol.isLeaf()) { // necesito darme cuanta cuando llegue a una hoja para setearlo con 0 y salvar
								// el valor
			salvado = arbol.getData();
			arbol.setData(0);
			return salvado;
		} else {
			if (arbol.hasLeftChild()) {
				sumIz = helper(arbol.getLeftChild());
			}

			if (arbol.hasRightChild()) {
				sumDe = helper(arbol.getRightChild());
			}
			salvado = arbol.getData(); // reutilizo la variable salvado, con el backtrackin
			arbol.setData(sumIz + sumDe);
			return arbol.getData() + salvado;
		}

	}

	public BinaryTree<Integer> suma() {
//		BinaryTree<Integer> a = new BinaryTree<>();
		if (!arbol.isEmpty()) {
			helper(arbol);
		}
		return arbol;
	}
}
