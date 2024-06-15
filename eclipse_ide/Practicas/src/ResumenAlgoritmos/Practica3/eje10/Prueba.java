package ResumenAlgoritmos.Practica3.eje10;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje2.Queue;
import tp3_Practica.eje5.GeneralTree;

public class Prueba {
	public static List<Integer> resolverr(GeneralTree<Integer> arbol) {
		List<Integer> caminoMax = new LinkedList<>();
		if ((arbol != null) || !arbol.isEmpty()) {
			helper(arbol, caminoMax, new LinkedList<Integer>(), 0, 0, 0);
		}
		return caminoMax;
	}

	/*
	 * No le imprime lo q busca por perdida en mem dinamica
	 */
	private static int helper(GeneralTree<Integer> arbol, List<Integer> caminoMax, List<Integer> caminoAct, int costoMax, int costoAct, int nivel) {
		int datoActual = arbol.getData();
		if (datoActual == 1) {
			costoAct += nivel;
			caminoAct.add(datoActual); // agregamos el 1
		}
		if (arbol.isLeaf()) {
			if (costoMax > costoAct) {
				costoMax = costoAct;
				caminoMax.clear();
				caminoMax.addAll(caminoAct);
			}
		} else {
			for (GeneralTree<Integer> child : arbol.getChildren())
				costoMax = helper(child, caminoMax, caminoAct, costoMax, costoAct, nivel + 1);
		}
		if (datoActual == 1)
			caminoAct.remove(caminoAct.size() - 1);

		return costoMax;
	}

	public static void main(String[] args) {

		GeneralTree<Integer> arbol = crearArbol();
		imprimirEntreNiveles(arbol);

		System.out.println("\n-------------------------");

		List<Integer> lista = Prueba.resolverr(arbol);

		for (Integer i : lista) {
			System.out.println(i);
		}

	}

	// metodos estaticos del main (solo para prueba)

	public static void imprimirEntreNiveles(GeneralTree<Integer> arbol) {
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

	public static GeneralTree<Integer> crearArbol() {
		List<GeneralTree<Integer>> subChildren1 = new LinkedList<>();
		subChildren1.add(new GeneralTree<>(1));
		subChildren1.add(new GeneralTree<Integer>(1));
		subChildren1.add(new GeneralTree<>(1));
		GeneralTree<Integer> subA = new GeneralTree<>(1, subChildren1);
		List<GeneralTree<Integer>> subChildren2 = new LinkedList<>();
		subChildren2.add(subA);
		subChildren2.add(new GeneralTree<>(1));
		GeneralTree<Integer> a1 = new GeneralTree<>(0, subChildren2);

		List<GeneralTree<Integer>> subChildren3 = new LinkedList<>();
		subChildren3.add(new GeneralTree<>(1));
		GeneralTree<Integer> subB = new GeneralTree<>(0, subChildren3);
		List<GeneralTree<Integer>> subChildren4 = new LinkedList<>();
		subChildren4.add(subB);
		GeneralTree<Integer> subC = new GeneralTree<>(0, subChildren4);
		List<GeneralTree<Integer>> subChildren5 = new LinkedList<>();
		subChildren5.add(new GeneralTree<>(1));
		subChildren5.add(subC);
		GeneralTree<Integer> a2 = new GeneralTree<>(1, subChildren5);

		List<GeneralTree<Integer>> subChildren6 = new LinkedList<>();
		subChildren6.add(new GeneralTree<>(0));
		subChildren6.add(new GeneralTree<>(0));
		GeneralTree<Integer> subD = new GeneralTree<>(0, subChildren6);
		List<GeneralTree<Integer>> subChildren7 = new LinkedList<>();
		subChildren7.add(subD);
		GeneralTree<Integer> subE = new GeneralTree<>(0, subChildren7);
		List<GeneralTree<Integer>> subChildren8 = new LinkedList<>();
		subChildren8.add(subE);
		GeneralTree<Integer> a3 = new GeneralTree<>(1, subChildren8);

		List<GeneralTree<Integer>> arbol = new LinkedList<>();
		arbol.add(a1);
		arbol.add(a2);
		arbol.add(a3);

		GeneralTree<Integer> a = new GeneralTree<>(1, arbol);
		return a;
	}
}
