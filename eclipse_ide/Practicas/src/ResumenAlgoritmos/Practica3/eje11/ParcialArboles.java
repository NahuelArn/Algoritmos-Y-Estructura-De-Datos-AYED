package ResumenAlgoritmos.Practica3.eje11;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje2.Queue;
import tp3_Practica.eje5.GeneralTree;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		return arbol == null ? false : arbol.isEmpty() ? false : auxiliar(arbol);
	}

	private static boolean auxiliar(GeneralTree<Integer> arbol) {
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(arbol);
		cola.enqueue(null);

		int nodosNivelAct = 1;
		int nodosNivelSig = 0;
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				// encolamos los hijos
				List<GeneralTree<Integer>> children = aux.getChildren();
				for (GeneralTree<Integer> child : children) {
					cola.enqueue(child);
					nodosNivelSig++;
					if (nodosNivelSig > (nodosNivelAct + 1))
						return false;
					// si se encuentra que no cumple la condicion, dejamos de encolar a los hijos y
					// retornamos false
				}
			} else if (!cola.isEmpty()) {
				if (nodosNivelSig != (nodosNivelAct + 1))
					return false;
				nodosNivelAct = nodosNivelSig;
				nodosNivelSig = 0;
				cola.enqueue(null);
			}
		}
		return true;
	}

	public static void imprimirEntreNivelesInt(GeneralTree<Integer> arbol) {
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				System.out.print(aux.getData() + " ");
				List<GeneralTree<Integer>> children = aux.getChildren();// recorremos los hijos del nodo actual aux.
				for (GeneralTree<Integer> child : children) {
					cola.enqueue(child);
				}
			} else {
				if (!cola.isEmpty()) {
					System.out.println("");
					cola.enqueue(null);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
		subChildren1.add(new GeneralTree<Integer>(83));
		GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);

		List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
		subChildren2.add(subAb1);
		GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);

		List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
		subChildren3.add(new GeneralTree<Integer>(33));
		subChildren3.add(new GeneralTree<Integer>(12));
		subChildren3.add(new GeneralTree<Integer>(17));
		subChildren3.add(new GeneralTree<Integer>(9));
		GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);

		List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
		subChildren4.add(new GeneralTree<Integer>(7));
		subChildren4.add(new GeneralTree<Integer>(11));
		subChildren4.add(subAb3);
		GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);

		List<GeneralTree<Integer>> subArbIzq = new LinkedList<GeneralTree<Integer>>();
		subArbIzq.add(subAb2);
		subArbIzq.add(subAb4);
		GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);

		List<GeneralTree<Integer>> subArbDer = new LinkedList<GeneralTree<Integer>>();
		subArbDer.add(new GeneralTree<Integer>(13));
		GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);

		List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
		arbol.add(arbIzq);
		arbol.add(arbDer);
		GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);

		imprimirEntreNivelesInt(a);
		System.out.println("Es creciente el arbol 1: " + ParcialArboles.resolver(a));
	}

	public static void imprimirEntreNivelesInt1(GeneralTree<Integer> arbol) {
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				System.out.print(aux.getData() + " ");
				List<GeneralTree<Integer>> children = aux.getChildren();// recorremos los hijos del nodo actual aux.
				for (GeneralTree<Integer> child : children) {
					cola.enqueue(child);
				}
			} else {
				if (!cola.isEmpty()) {
					System.out.println("");
					cola.enqueue(null);
				}
			}
		}
	}
}
