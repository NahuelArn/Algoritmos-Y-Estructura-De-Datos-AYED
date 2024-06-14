package ResumenAlgoritmos.Practica2.eje5;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;
import ResumenAlgoritmos.Practica2.eje1y2.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> a;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		this.a = a;
	}

	public int sumaElementosProfundidad(int prof) {
		int suma = 0;
		if (!a.isEmpty()) {
			Queue<BinaryTree<Integer>> queue = new Queue<>();
			queue.enqueue(a);
			int profundidadActual = 0;
			while (!queue.isEmpty()) {
				int dimFqueue = queue.size();
				if (profundidadActual < prof) { // esto avanza en niveles //iterador de padres
					for (int i = 0; i < dimFqueue; i++) {
						BinaryTree<Integer> nodoActual = queue.dequeue();
						if (nodoActual.hasLeftChild()) {
							queue.enqueue(nodoActual.getLeftChild());
						}
						if (nodoActual.hasRightChild()) {
							queue.enqueue(nodoActual.getRightChild());
						}
					}
				} else { // me suma todos los elementos cargados en la quue que seria el mismo nivel
					for (int i = 0; i < dimFqueue; i++) {
						suma += queue.dequeue().getData();
					}
				}
				profundidadActual++;
			}
		}
		return suma;
	}

	public static void main(String[] args) {
		// Crear el árbol binario y agregar datos de ejemplo
		BinaryTree<Integer> tree = new BinaryTree<>(10);
		tree.addLeftChild(new BinaryTree<>(3));
		tree.addRightChild(new BinaryTree<>(8));
		tree.getLeftChild().addLeftChild(new BinaryTree<>(9));
		tree.getLeftChild().addRightChild(new BinaryTree<>(12));
		tree.getRightChild().addLeftChild(new BinaryTree<>(5));
		tree.getRightChild().addRightChild(new BinaryTree<>(7));

		ProfundidadDeArbolBinario profundidadDeArbol = new ProfundidadDeArbolBinario(tree);
		int suma = profundidadDeArbol.sumaElementosProfundidad(2); // Profundidad 2
		System.out.println("Suma de elementos a profundidad 2: " + suma);
	}
}
