package tp2_Arboles.eje7;

import tp2_Arboles.eje1.BinaryTree;

public class ParcialArboles<Integer> {
	private BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public ParcialArboles() {
		super();
	}

	// estrategia, buscar: encontre(desarrolo logica)? sino no hago nada q va
	// retornar null/false
	private BinaryTree<Integer> buscar(int num, Estado estado, BinaryTree<Integer> arbol, BinaryTree<Integer> puntero) {
		if (arbol.getData().equals(num)) {
			estado.setEstado(true);
			return arbol;
		}
		if (arbol.hasLeftChild() && !(estado.getEstado())) {
			puntero = buscar(num, estado, arbol.getLeftChild(), puntero);
		}
		System.out.println("dato: " + arbol.getData() + " estado: " + estado.getEstado());
		if (arbol.hasRightChild() && !(estado.getEstado())) {
			puntero = buscar(num, estado, arbol.getRightChild(), puntero);
		}
		return puntero;
	}
	/*
	 * Estrategia Ya estoy parado, has, left empiezo a contar (modulo q cuenta)
	 * if(has right) empiezo a contar (modulo q cuenta) else gano izquierda true
	 * else{ return false; //com ya ltengo false no hgo nda }
	 */

	// "(*)"
	private int contar(BinaryTree<Integer> arbol) {
		int suma = 0;
		if (arbol.hasLeftChild()) {
			suma += contar(arbol.getLeftChild());
		}
		if (!arbol.isLeaf() & ((!arbol.hasLeftChild() || !arbol.hasRightChild()))) {
//	        System.out.println("cosassa: " + arbol.getData());
			suma += 1;
		}
		if (arbol.hasRightChild()) {
			suma += contar(arbol.getRightChild());
		}
		return suma;
	}

	private void validador(BinaryTree<Integer> arbol, Estado estado) {
		int izq = 0;
		int der = 0;
		if (arbol.hasLeftChild()) {
			izq = contar(arbol.getLeftChild());
			if (arbol.hasRightChild()) {
				der = contar(arbol.getRightChild());
			}
			System.out.println("Izq : " + izq + " der: " + der);
			if (izq > der) {
				estado.setEstado(true);
			} else {
				estado.setEstado(false);
			}
		} else {
			estado.setEstado(false);
		}
	}

	public boolean isLeftTree(int num) {
		Estado estado = new Estado();
		BinaryTree<Integer> puntero = new BinaryTree<>();
		if (!arbol.isEmpty()) {
			puntero = buscar(num, estado, arbol, puntero);
			if (puntero != null) {
				validador(puntero, estado);
			}
		}
		return estado.getEstado();
	}
}
