package tp2_Arboles.eje7.sinClaseHelper;

import tp2_Arboles.eje1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol = new BinaryTree<>();

	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public ParcialArboles() {
		super();
	}

	public BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, BinaryTree<Integer> buscado, int num) {
//		BinaryTree<Integer> buscado = new BinaryTree<>();
		if (arbol.getData() == num) {
			return arbol;
		} else {
//			System.out.println("valor actual: " + arbol.getData()); cuando encuentra corta
			if (arbol.hasLeftChild() && buscado.isEmpty()) {
				buscado = buscar(arbol.getLeftChild(), buscado, num);
			}
			if (arbol.hasRightChild() && (buscado.isEmpty())) {
				buscado = buscar(arbol.getRightChild(), buscado, num);
			}
		}
		return buscado;
	}

	private int cantidadCumple(BinaryTree<Integer> arbol) {
		int suma = 0;
		if (arbol.hasLeftChild()) {
			suma += cantidadCumple(arbol.getLeftChild());
		}
		if (!arbol.isLeaf() & ((!arbol.hasLeftChild() || !arbol.hasRightChild()))) {
			suma += 1;
		}
		if (arbol.hasRightChild()) {
			suma += cantidadCumple(arbol.getRightChild());
		}
		return suma;
//		if ((!arbol.isLeaf() & ((!arbol.hasLeftChild() || !arbol.hasRightChild())))) {
//			return 1;
//		} else if (arbol.isLeaf()) {
//			return -1;
//		} se podria hacer de esta manera, pero tendria que contemplar el caso de mandar null
//		return cantidadCumple(arbol.getLeftChild()) + (cantidadCumple(arbol.getRightChild()));
	}

	private boolean validador(BinaryTree<Integer> arbol) {
		int izq = 0;
		int der = 0;
		if (arbol.hasLeftChild()) { // si no tiene hi no tiene sentido seguir
			izq = cantidadCumple(arbol.getLeftChild());
			if (izq > -1) {
				if (arbol.hasRightChild()) {
					der = cantidadCumple(arbol.getRightChild());
				} else {
					der = -1;
				}
			}
		} else {
			izq = -1;
		}

		return izq > der;
	}

	public boolean isLeftTree(int num) {
		boolean estado = false;
		if (!arbol.isEmpty()) {
			BinaryTree<Integer> puntero = new BinaryTree<>();
			puntero = buscar(arbol, puntero, num);
			if (!puntero.isEmpty()) {
				System.out.println(puntero.getData());
				if (validador(puntero)) {
					estado = true;
				}
//				estado = validador(puntero);
//				System.out.println("Puntero valor: " + puntero.getData());
			}
		}
		return estado;
	}
}
