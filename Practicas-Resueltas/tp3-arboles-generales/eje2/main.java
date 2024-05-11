package tp3_Practica.eje2;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class main {
	public static void main(String[] args) {
		// creo la lista de hijos del padre
		List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
//		children2.add(new GeneralTree<Integer>("21"));
//		children2.add(new GeneralTree<Integer>("22"));
//		children2.add(new GeneralTree<Integer>("23"));

		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
//		children2.add(new GeneralTree<Integer>("21"));
//		children2.add(new GeneralTree<Integer>("22"));
//		children2.add(new GeneralTree<Integer>("23"));

		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
//		children2.add(new GeneralTree<Integer>("21"));
//		children2.add(new GeneralTree<Integer>("22"));
//		children2.add(new GeneralTree<Integer>("23"));

		// le asigno los hijos al padre
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(13, children1);
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(25, children2);
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(10, children3);

		// le asigno a un hijo los padres (que ya tiene padre e hijo)
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);
		childen.add(a2);
		childen.add(a3);

		GeneralTree<Integer> a = new GeneralTree<Integer>(14, childen);

		a.preOrder();

		RecorridosAG casa = new RecorridosAG();

		List<Integer> pepe = casa.numerosImparesMayoresQuePreOrden(a, 2);

		for (Integer i : pepe) { // tipo de dato contendio nombreVariable: datoDefinido
			System.out.println("imprimiendo: " + i);
		}

		// ---------------------------------------------------------
		System.out.println();
		pepe = casa.numerosImparesMayoresQueInOrden(a, 0);

		for (Integer i : pepe) {
			System.out.println("imprimiendo2: " + i);
		}

		// ----------------------------------------------------------
		System.out.println();

		pepe = casa.numerosImparesMayoresQuePostOrden(a, 0);

		for (Integer i : pepe) {
			System.out.println("imprimiendo3: " + i);
		}

		// -----------------QUEUE--------------------

		System.out.println();
		pepe = casa.numerosImparesMayoresQuePorNiveles(a, 0);

		for (Integer i : pepe) {
			System.out.println("imprimiendo4: " + i);
		}

	}

	/*
	 * b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>,
	 * ¿qué modificaciones haría tanto en la firma como en la implementación de los
	 * mismos?
	 * 
	 * Tema implementacion, usar todo con this, ya que estaria dentro del arbol
	 * general
	 * 
	 * 
	 */
}
