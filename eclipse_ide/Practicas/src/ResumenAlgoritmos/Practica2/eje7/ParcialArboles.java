package ResumenAlgoritmos.Practica2.eje7;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> a;

	public ParcialArboles(BinaryTree<Integer> a) {
		this.a = a;
	}

	// corta ni bien encuentra el valor Buscado testeado
	private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> a, Integer num) {
		if (a.getData().equals(num)) {
			return a;
		} else {
			BinaryTree<Integer> retorno = null;
			if (a.hasLeftChild() && retorno == null) {
				retorno = buscarNodo(a.getLeftChild(), num);
			}
			if (retorno == null && a.hasRightChild()) { // circuito corto
				retorno = buscarNodo(a.getRightChild(), num);
			}
			return retorno;
		}
	}

	private boolean unSoloHijo(BinaryTree<Integer> a) {
		return (!a.isLeaf() & ((!a.hasLeftChild() || !a.hasRightChild())));
//		return (a.hasLeftChild() && !a.hasRightChild()) || (!a.hasLeftChild() && a.hasRightChild());
	}

	private int contadorPadreUnSoloHijo(BinaryTree<Integer> a) {
		int cont = 0;
		if (unSoloHijo(a)) { // de entrada me llega un arbol !isEmpty
			cont++;
		}
		if (a.hasLeftChild()) {
			cont += contadorPadreUnSoloHijo(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			cont += contadorPadreUnSoloHijo(a.getRightChild());
		}

		return cont;
	}

	public boolean isLeftTreee(int num) {
		boolean estado = false;
		if (!a.isEmpty()) {
			BinaryTree<Integer> nodoBuscado = buscarNodo(a, num);
			if (nodoBuscado != null) {
				int izq = -1;
				int der = -1;
				if (nodoBuscado.hasLeftChild()) {
					izq = contadorPadreUnSoloHijo(nodoBuscado.getLeftChild());
				}
				if (nodoBuscado.hasRightChild()) {
					der = contadorPadreUnSoloHijo(nodoBuscado.getRightChild());
				}
				estado = izq > der;
			}
		}
		return estado;
	}

	// Método principal para probar la implementación
	public static void main(String[] args) {
		// Crear el árbol binario y agregar datos de ejemplo
		BinaryTree<Integer> tree = new BinaryTree<>(10);
		tree.addLeftChild(new BinaryTree<>(3));
		tree.addRightChild(new BinaryTree<>(8));
		tree.getLeftChild().addLeftChild(new BinaryTree<>(9));
		tree.getLeftChild().addRightChild(new BinaryTree<>(12));
		tree.getRightChild().addLeftChild(new BinaryTree<>(5));
		tree.getRightChild().addRightChild(new BinaryTree<>(7));

		// Crear una instancia de ParcialArboles con el arbol creado
		ParcialArboles parcial = new ParcialArboles(tree);

		// Probar el metodo buscarNodo //Esta privado pero como esta en la mismo archivo
		// lo toma
		Integer numABuscar = 3;
		BinaryTree<Integer> nodoBuscado = parcial.buscarNodo(tree, numABuscar);

		// Imprimir el resultado de la busqueda
		if (nodoBuscado != null) {
			System.out.println("Nodo encontrado con valor: " + nodoBuscado.getData());
		} else {
			System.out.println("Nodo con valor " + numABuscar + " no encontrado");
		}

		// Probar el método isLeftTreee
		boolean resultado = parcial.isLeftTreee(numABuscar);
		System.out.println("El subárbol izquierdo tiene más padres con un solo hijo que el derecho: " + resultado);
	}

}
