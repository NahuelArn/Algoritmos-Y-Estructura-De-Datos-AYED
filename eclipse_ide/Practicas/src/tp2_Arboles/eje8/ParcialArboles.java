package tp2_Arboles.eje8;

import tp2_Arboles.eje1.BinaryTree;;

public class ParcialArboles {

	public ParcialArboles() {
		super();
	}

	private boolean sonIguales(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		if (a1 == null || b2 == null) {
			return false;
		} else {
			return a1.getData().equals(b2.getData());
		}

	}

	private boolean filtrar(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		// Si a1 es nulo, entonces está contenido en b2
		if (a1 == null) {
			return true;
		}
		// Si b2 es nulo pero a1 no, entonces a1 no está contenido en b2
		if (b2 == null) {
			return false;
		}

		// Verificar si los nodos coinciden y seguir verificando los subárboles
		return sonIguales(a1, b2) && filtrar(a1.getLeftChild(), b2.getLeftChild()) && filtrar(a1.getRightChild(), b2.getRightChild());
	}

	public boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		boolean resultado = false;
		if (!a1.isEmpty() && !b2.isEmpty()) {
			resultado = filtrar(a1, b2);
		}
		return resultado;
	}
}
