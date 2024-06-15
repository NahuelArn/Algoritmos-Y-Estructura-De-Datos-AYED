package ResumenAlgoritmos.Practica3.eje7;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> correCaminos;

	/*
	 * exp robada de Gian En este metodo: Siempre vamos a agregar el dato actual a
	 * la lista caminoActual Si el nodo no es una hoja: Significa que tenemos que
	 * seguir haciendo la recursion - Invocamos el metodo recursivo con sus hijos -
	 * Cuando vuelve de la recursion, eliminamos los elementos actuales, asi dejamos
	 * la lista vacia -1 elemento para cada camino Si el nodo es una hoja: Significa
	 * que llegamos al final de un camino. -Debemos evaluar si el camino actual es
	 * mayor al camino maximo, y en caso de que sea asi, actualizamos la nueva lista
	 * con el camino maximo.
	 * 
	 * Es decir, mientras hagamos llamadas recursivas, la lista estará cargada con
	 * elementos. La lista se vaciará cuando se llegue a una hoja, y se chequee si
	 * es maximo o no. Cuando vuelva de la recursion, va sacando elemento por
	 * elemento de la lista.
	 */
	private void helperPrimerCaminoLargo(GeneralTree<Integer> a, List<Integer> caminoActual, List<Integer> caminolMax) {
		caminoActual.add(a.getData());
		if (a.isLeaf()) { // me actualiza el camino maximo
			if (caminoActual.size() > caminolMax.size()) {
				caminolMax.clear();
				caminolMax.addAll(caminoActual);
			}
		} else { // sigue con la recursion
			List<GeneralTree<Integer>> childActual = a.getChildren();
			for (GeneralTree<Integer> i : childActual) {
				helperPrimerCaminoLargo(i, caminoActual, caminolMax);
				caminoActual.remove(caminoActual.size() - 1);
			}
		}
	}

	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> caminolMax = new LinkedList<>(); // creo el arbol
		if (correCaminos != null && !correCaminos.isEmpty()) { // valido
			helperPrimerCaminoLargo(correCaminos, new LinkedList<>(), caminolMax);
		}
		return caminolMax;
	}

	/*
	 * Manejo de la Lista caminoActual:
	 * 
	 * En la primera versión, caminoActual.remove(caminoActual.size() - 1) se
	 * ejecuta después de la llamada recursiva a cada hijo. Esto asegura que
	 * caminoActual esté en el estado correcto para cada hijo en el bucle. private
	 * void helperPrimerCaminoLargo(GeneralTree<Integer> a, List<Integer>
	 * caminoActual, List<Integer> caminolMax) { caminoActual.add(a.getData()); if
	 * (a.isLeaf()) { // me actualiza el camino maximo if (caminoActual.size() >
	 * caminolMax.size()) { caminolMax.clear(); caminolMax.addAll(caminoActual); } }
	 * else { //sigue con la recursion List<GeneralTree<Integer>> childActual =
	 * a.getChildren(); for (GeneralTree<Integer> i : childActual) {
	 * helperPrimerCaminoLargo(i, caminoActual, caminolMax);
	 * caminoActual.remove(caminoActual.size() - 1); } } } En la segunda versión,
	 * camAct.remove(camAct.size() - 1) se ejecuta al final de la función recursiva
	 * caminoHelper. Este enfoque también es correcto porque, después de procesar un
	 * nodo (ya sea hoja o interno), se asegura de que el nodo actual se elimine
	 * antes de que la recursión vuelva al nivel superior. private void
	 * caminoHelper(GeneralTree<Integer> a, List<Integer> camAct, List<Integer>
	 * camMax) { camAct.add(a.getData()); if(!a.isLeaf()) {
	 * for(GeneralTree<Integer>h: a.getChildren()) { caminoHelper(h, camAct,
	 * camMax); } } else if(camAct.size() > camMax.size()) {
	 * camMax.removeAll(camMax); camMax.addAll(camAct); }
	 * camAct.remove(camAct.size()-1); }
	 */
	public static void main(String[] args) {
		// Crear instancias de GeneralTree
		GeneralTree<Integer> root = new GeneralTree<>(12);
		GeneralTree<Integer> node1 = new GeneralTree<>(15);
		GeneralTree<Integer> node2 = new GeneralTree<>(17);
		GeneralTree<Integer> node3 = new GeneralTree<>(14);
		GeneralTree<Integer> node4 = new GeneralTree<>(6);
		GeneralTree<Integer> node5 = new GeneralTree<>(16);
		GeneralTree<Integer> node6 = new GeneralTree<>(7);
		GeneralTree<Integer> node7 = new GeneralTree<>(1);

		// Construir el árbol
		root.addChild(node1);
		root.addChild(node2);
		node1.addChild(node3);
		node1.addChild(node4);
		node3.addChild(node5);
		node3.addChild(node6);
		node2.addChild(node7);

		// Crear una instancia de Caminos
		Caminos caminos = new Caminos();
		caminos.correCaminos = root;

		// Calcular y mostrar el camino más largo
		List<Integer> caminoMasLargo = caminos.caminoAHojaMasLejana();
		System.out.println("El camino más largo hasta una hoja es: " + caminoMasLargo);
	}
}
