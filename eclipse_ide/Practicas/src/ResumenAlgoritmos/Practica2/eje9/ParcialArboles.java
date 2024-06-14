package ResumenAlgoritmos.Practica2.eje9;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

public class ParcialArboles {
	public void helperOperaciones(BinaryTree<Integer> a, BinaryTree<Contenedor> nuevoArbol, int sumaCamino, int valorPadre) {
		int valorActual = a.getData();
		Contenedor contenedor = new Contenedor();// necesito que persista la data
		contenedor.setSum(valorActual + sumaCamino);
		contenedor.setDif(valorActual - valorPadre);
		nuevoArbol.setData(contenedor);
		if (a.hasLeftChild()) {
			nuevoArbol.addLeftChild(new BinaryTree<Contenedor>());
			helperOperaciones(a.getLeftChild(), nuevoArbol.getLeftChild(), valorActual + sumaCamino, valorActual);
		}
		if (a.hasRightChild()) {
			nuevoArbol.addRightChild(new BinaryTree<Contenedor>());
			helperOperaciones(a.getRightChild(), nuevoArbol.getRightChild(), valorActual + sumaCamino, valorActual);
		}

	}

	public BinaryTree<Contenedor> sumAndDif(BinaryTree<Integer> a) {
		BinaryTree<Contenedor> nuevoArbol = new BinaryTree<>();
		if (!a.isEmpty()) {
			helperOperaciones(a, nuevoArbol, 0, 0);// doble cero, representa la suma del camino & el valor del padre
		}
		return nuevoArbol;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(20);
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo30 = new BinaryTree<>(30);
		BinaryTree<Integer> nodoNeg5 = new BinaryTree<>(-5);
		BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
		BinaryTree<Integer> nodo50 = new BinaryTree<>(50);
		BinaryTree<Integer> nodoNeg9 = new BinaryTree<>(-9);
		BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);

		arbol.addLeftChild(nodo5);
		arbol.addRightChild(nodo30);

		nodo5.addLeftChild(nodoNeg5);
		nodo5.addRightChild(nodo10);

		nodo30.addLeftChild(nodo50);
		nodo30.addRightChild(nodoNeg9);

		nodo10.addLeftChild(nodo1);
		nodo50.addRightChild(nodo4);
		nodo4.addRightChild(nodo6);

		// Crear instancia de ParcialArboles
		ParcialArboles parcialArboles = new ParcialArboles();

		// Obtener el nuevo árbol con las sumas y diferencias
		BinaryTree<Contenedor> nuevoArbol = new BinaryTree<>();

		// Imprimir el nuevo árbol
		System.out.println("Árbol original:");
		arbol.inOrden();
		System.out.println("Nuevo árbol con sumas y diferencias:");
		nuevoArbol = parcialArboles.sumAndDif(arbol);

		System.out.println(nuevoArbol.getData().toString());
		System.out.println(nuevoArbol.getLeftChild().toString());
		System.out.println(nuevoArbol.getRightChild().toString());
		System.out.println("entra");
	}
}
