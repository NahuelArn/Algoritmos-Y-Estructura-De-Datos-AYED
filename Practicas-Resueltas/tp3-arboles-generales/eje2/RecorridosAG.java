package tp3_Practica.eje2;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

/* Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 pasados como parámetros, recorrido en preorden.
 * */

public class RecorridosAG {

	private boolean esPar(int num) {
		return num % 2 == 0;
	}

	private boolean esMayor(int a, int b) {
		return a > b;
	}

	// ---------------------------------numerosImparesMayoresQuePreOrden----------------------------------------------------

	private void helperPreOrden(GeneralTree<Integer> a, LinkedList<Integer> retorno, int n) {
		int padreActual = a.getData();
		if (esPar(padreActual) && (esMayor(padreActual, n))) {
			retorno.add(padreActual);
		}
		List<GeneralTree<Integer>> childrenAct = a.getChildren();
		for (GeneralTree<Integer> act : childrenAct) {
			helperPreOrden(act, retorno, n);
		}
	}

	public LinkedList<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, int n) {
		LinkedList<Integer> retorno = new LinkedList<>();
		if (a != null && !a.isEmpty()) {
			helperPreOrden(a, retorno, n);
		}
		return retorno;
	}

	// -------------------------------------------numerosImparesMayoresQueInOrden------------------------------------------

	private void helperInOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
		List<GeneralTree<Integer>> children = a.getChildren();
		// procesamos los primeros hijos, full izquierda
		if (a.hasChildren()) {
			helperInOrden(children.get(0), n, lista);
		}
		// procesamos la raiz
		int datoActual = a.getData();
		if ((esPar(datoActual)) && (esMayor(datoActual, n))) {
			lista.add(datoActual);
		}
		// procesamos los demas hijos (omitiendo el primero (0))
		for (int i = 1; i < children.size(); i++) { // comenzamos a partir del 0+1;
			helperInOrden(children.get(i), n, lista);
		}
	}

	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, int n) {
		LinkedList<Integer> retornov2 = new LinkedList<>();
		if (a != null && !a.isEmpty()) {
			helperInOrden(a, n, retornov2);
		}
		return retornov2;
	}

	// ------------------------------------------------------------------------------------

	private void postOrdenHelper(GeneralTree<Integer> a, int n, List<Integer> retorno3) {
		List<GeneralTree<Integer>> childActual = a.getChildren();
		for (GeneralTree<Integer> i : childActual) {
			postOrdenHelper(i, n, retorno3);
		}
		int dato = a.getData();
		if ((esPar(dato)) && (esMayor(dato, n))) {
			retorno3.add(dato);
		}
	}

	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> retorno3 = new LinkedList<>();
//		if(a.hasChildren()) {}
		if (a != null && !a.isEmpty()) {
			postOrdenHelper(a, n, retorno3);
		}
		return retorno3;
	}

	private void helperEntreNiveles(GeneralTree<Integer> a, List<Integer> retorno4, Integer n) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(a);
		GeneralTree<Integer> arbolActual;

		while (!queue.isEmpty()) {
			arbolActual = queue.dequeue();
			Integer datoActual = arbolActual.getData(); // obtengo el dato del nodo
			if ((esPar(datoActual)) && (esMayor(datoActual, n))) {
				retorno4.add(datoActual);
			}
			List<GeneralTree<Integer>> childActual = arbolActual.getChildren(); // cargo los hijos
			for (GeneralTree<Integer> i : childActual) {
				queue.enqueue(i);
			}
		}
	}

	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
		List<Integer> retorno4 = new LinkedList<>();
		if (a != null && !a.isEmpty()) {
			helperEntreNiveles(a, retorno4, n); // "anchura"
		}
		return retorno4;
	}
}
