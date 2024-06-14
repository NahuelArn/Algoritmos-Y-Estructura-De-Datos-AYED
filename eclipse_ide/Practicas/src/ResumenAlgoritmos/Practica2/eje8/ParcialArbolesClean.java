package ResumenAlgoritmos.Practica2.eje8;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

public class ParcialArbolesClean {
	// SENHOR ALGORITMO ES ESTE
	private boolean sonIguales(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		if (a1 == null || b2 == null) {
			return false;
		} else {
			return a1.getData().equals(b2.getData());
		}

	}

	private boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		// Si a1 es nulo, entonces esta contenido en b2
		if (a1 == null) { // no esta contenido por q no existiaria A
			return true;
		}
		// Si b2 es nulo pero a1 no, entonces a1 no está contenido en b2
		if (b2 == null) {
			return false;
		}

		// Verificar si los nodos coinciden y seguir verificando los subarboles
		return sonIguales(a1, b2) && esPrefijo(a1.getLeftChild(), b2.getLeftChild()) && esPrefijo(a1.getRightChild(), b2.getRightChild());
	}

	public static void main(String[] args) {
		// Crear árboles de ejemplo
		BinaryTree<Integer> arbol1 = new BinaryTree<>(1);
		arbol1.addLeftChild(new BinaryTree<>(2));
		arbol1.addRightChild(new BinaryTree<>(1));

		BinaryTree<Integer> arbol2 = new BinaryTree<>(1);
		arbol2.addLeftChild(new BinaryTree<>(2));
		arbol2.addRightChild(new BinaryTree<>(1));
//		arbol2.getLeftChild().addLeftChild(new BinaryTree<>(4));
//		arbol2.getRightChild().addRightChild(new BinaryTree<>(5));

		ParcialArbolesClean parcialArboles = new ParcialArbolesClean();
		boolean esPrefijo = parcialArboles.esPrefijo(arbol1, arbol2);
		System.out.println("¿Arbol1 es prefijo de Arbol2? " + esPrefijo);
	}
}
