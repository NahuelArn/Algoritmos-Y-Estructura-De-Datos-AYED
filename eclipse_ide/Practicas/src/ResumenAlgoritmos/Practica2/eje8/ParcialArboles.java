package ResumenAlgoritmos.Practica2.eje8;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

public class ParcialArboles {

//	private boolean sonIguales(Integer a, Integer b) {
//		return a.equals(b);
//	}
	private boolean sonIguales(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		if (a1 == null || b2 == null) {
			return false;
		} else {
			return a1.getData().equals(b2.getData());
		}

	}

	private boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> b2) {
		// Si a1 es nulo, entonces está contenido en b2
		if (a1 == null) {
			return true;
		}
		// Si b2 es nulo pero a1 no, entonces a1 no está contenido en b2
		if (b2 == null) {
			return false;
		}

		// Verificar si los nodos coinciden y seguir verificando los subárboles
		return sonIguales(a1, b2) && esPrefijo(a1.getLeftChild(), b2.getLeftChild()) && esPrefijo(a1.getRightChild(), b2.getRightChild());
	}
//	private boolean helper(BinaryTree<Integer> a, BinaryTree<Integer> b) {
//		boolean estado = true;
////		if (a.getData().equals(b.getData())) {
////			return true;
////		}
//		if (a.hasLeftChild()) {
//			if (b.hasLeftChild()) {
//				if (sonIguales(a.getRightChild().getData(), b.getRightChild().getData())) {
//					helper(a.getLeftChild(), b.getLeftChild());
//				} else {
//					estado = false;
//				}
//			} else {
//				estado = false;
//			}
//		}
//		if (a.hasRightChild() && estado) {
//			if (b.hasRightChild()) {
//				if (sonIguales(a.getRightChild().getData(), b.getRightChild().getData())) {
//					System.out.println("entra?: a: " + a.getData() + " b: " + b.getData());
//					helper(a.getRightChild(), b.getRightChild());
//				} else {
//					estado = false;
//				}
//			} else {
//				estado = false;
//			}
//		}
//		return estado;
////		return sonIguales(a.getData(), b.getData());
//	}
//
//	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
//		boolean estado = false;
//		if (!arbol2.isEmpty() && !arbol1.isEmpty()) {
//			estado = helper(arbol1, arbol2);
//		}
//		return estado;
//	}

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

		ParcialArboles parcialArboles = new ParcialArboles();
		boolean esPrefijo = parcialArboles.esPrefijo(arbol1, arbol2);
		System.out.println("¿Arbol1 es prefijo de Arbol2? " + esPrefijo);
	}
}
