package ResumenAlgoritmos.Practica3.eje10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje5.GeneralTree;

public class ParcialArboles {
	// enunciado si seria iterar hasta encontrar un camino max, sino seria como el
	// de Prueba con la modificacion q impacte en mem dinamica
	private static int helperFiltrado(GeneralTree<Integer> arbol, List<Integer> caminoMax, List<Integer> caminoAct, int costoMax, int costoAct, int nivel, boolean[] encontrado) {
		int datoActual = arbol.getData();
		if (datoActual == 1) {
			costoAct += nivel;
			caminoAct.add(datoActual); // Agregamos el 1
		}
		if (arbol.isLeaf()) {
			if (costoAct > costoMax) {
				costoMax = costoAct;
				caminoMax.clear();
				caminoMax.addAll(caminoAct);
				encontrado[0] = true; // Marcar que hemos encontrado el primer camino de valor máximo
			}
		} else {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			Iterator<GeneralTree<Integer>> iterator = children.iterator();
			while (iterator.hasNext() && !encontrado[0]) { // me aseguro de iterar solo hasta encontrar un
				GeneralTree<Integer> child = iterator.next();
				costoMax = helperFiltrado(child, caminoMax, caminoAct, costoMax, costoAct, nivel + 1, encontrado);
			}
		}
		if (datoActual == 1) {
			caminoAct.remove(caminoAct.size() - 1);
		}

		return costoMax;
	}

	public static List<Integer> resolver(GeneralTree<Integer> a) {
		List<Integer> caminoMax = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) {

			boolean[] encontrado = { false }; // Variable para marcar si ya encontramos el camino máximo
			helperFiltrado(a, caminoMax, new LinkedList<>(), 0, 0, 0, encontrado);
			System.out.println("Entro + " + caminoMax.size());
		}
		return caminoMax;
	}

	public static void main(String[] args) {
		// Crear instancias de GeneralTree para representar el árbol
		GeneralTree<Integer> root = new GeneralTree<>(1);
		GeneralTree<Integer> node1 = new GeneralTree<>(0);
		GeneralTree<Integer> node2 = new GeneralTree<>(1);
		GeneralTree<Integer> node3 = new GeneralTree<>(1);
		GeneralTree<Integer> node4 = new GeneralTree<>(0);
		GeneralTree<Integer> node5 = new GeneralTree<>(1);
		GeneralTree<Integer> node6 = new GeneralTree<>(1);
		GeneralTree<Integer> node7 = new GeneralTree<>(1);
		GeneralTree<Integer> node8 = new GeneralTree<>(0);
		GeneralTree<Integer> node9 = new GeneralTree<>(1);

		// Construir el árbol
		root.addChild(node1);
		root.addChild(node2);
		node1.addChild(node3);
		node1.addChild(node4);
		node2.addChild(node5);
		node3.addChild(node6);
		node4.addChild(node7);
		node5.addChild(node8);
		node8.addChild(node9);

		// Probar el método resolver
		List<Integer> resultado = ParcialArboles.resolver(root);
		for (Integer i : resultado) {// Debería imprimir [1, 1, 1]
			System.out.println(i);
		}
		System.out.println(" " + resultado.size()); // size 3
//		System.out.println("El camino filtrado de valor máximo es: " + resultado); // Debería imprimir [1, 1, 1]
	}
}
