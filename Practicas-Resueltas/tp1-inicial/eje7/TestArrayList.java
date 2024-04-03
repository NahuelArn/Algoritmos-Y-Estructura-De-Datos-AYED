package tp1.eje7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TestArrayList {

	public static void imprimirArrayList(ArrayList<Integer> vD) { // tiene q estar dentro del main los metodos estaticos
		for (Integer elemento : vD) { // tipo de dato | nombre: estructura
			System.out.print(" [ " + elemento + " ]");
		}
	}

	public static void imprimirLinkedList(LinkedList<Integer> lD) {
		for (Integer actual : lD) {
			System.out.print(" [ " + actual + " ]");
		}
	}

//	private static Estudiante (Estudiante estudiante) {
//		estudiante = new Estudiante("pepe",12);
//		return estudiante;
//	}
	public static void crearListaCon3Estudiante(ArrayList<Estudiante> lista) { // si ncesito crear la lista esta de
																				// estudiantes, si o si tendria que
																				// pasar una lista por parametro? o
																				// podria tipo hacer un atributo
																				// estatico?
		Estudiante estudiante;
		for (int i = 0; i < 3; i++) {
			estudiante = new Estudiante("pepe", 1);
			lista.add(estudiante);
		}
	}

	public static void imprimirArrayListEstudiantes(ArrayList<Estudiante> aD2) {
		for (Estudiante elemento : aD2) {
			System.out.println("el legajo: " + elemento.getLegajo() + " el nombre: " + elemento.getNombre());
		}
	}

	public static boolean verificar(ArrayList<Estudiante> aD2, String nombre) {
		boolean aux = false;
		int i = 0;
		while ((!aux) && (i < aD2.size())) {
			if (nombre.equals(aD2.get(i).getNombre())) {
				aux = true;
			}
			i++; // tema con el indice, pero como solo me intersa el boolean lo dejo asi
		}
		return aux;
	}

	public static void main(String[] args) {
		/*
		 * Scanner s = new Scanner(System.in); int num; // CON ARRAYLIST
		 * ArrayList<Integer> arregloDinamico = new ArrayList<>();
		 * System.out.println("Ingrese un numero, para cortar -1"); while ((num =
		 * s.nextInt()) != -1) { // voy a guardar en Num el numero leido
		 * arregloDinamico.add(num);
		 * System.out.println("Ingrese un numero, para cortar -1"); }
		 * 
		 * imprimirArrayList(arregloDinamico); // CON LINKEDLIST LinkedList<Integer>
		 * lista = new LinkedList<>();
		 * System.out.println("Ingrese un numero, para cortar -1"); while ((num =
		 * s.nextInt()) != -1) { lista.add(num);
		 * System.out.println("Ingrese un numero, para cortar -1"); }
		 * imprimirLinkedList(lista);
		 * 
		 */
		// lo del D
		/*
		 * ArrayList<Estudiante> aD2 = new ArrayList<>(); crearListaCon3Estudiante(aD2);
		 * //le paso un arrayList //Imprimo el array original
		 * imprimirArrayListEstudiantes(aD2); ArrayList<Estudiante> copia = new
		 * ArrayList<>(); copia =aD2; //Imprimo la copia System.out.println("copiaa");
		 * imprimirArrayListEstudiantes(copia); copia.get(0).setNombre("EDUARDO");
		 * System.out.println("Nueva impresion"); imprimirArrayListEstudiantes(aD2);
		 * imprimirArrayListEstudiantes(copia); //Vemos q si modificamos la copia, la
		 * original se ve afecta, ya q las asignaciones de objetos, le asigas la
		 * direccion y no le das una copia
		 * 
		 * //Existen varias formas de copiar, supongo que van distinguiendo la parte de
		 * si son referencias al original o se copia el contenido en nuevas direcciones
		 * en memoria
		 */

		/*
		 * lo del E
		 * 
		 */
		ArrayList<Estudiante> aD2 = new ArrayList<>();
		crearListaCon3Estudiante(aD2);
		System.out.println("Ingrese el nombre del estudiante");
		Scanner s = new Scanner(System.in);
		String nombre = s.nextLine();
		if (!verificar(aD2, nombre)) {
			Estudiante estudiante = new Estudiante(nombre, 3);
			aD2.add(estudiante);
		} else {
			System.out.println("Ya estaba el estudiante");
		}
		imprimirArrayListEstudiantes(aD2); // aca termina el E
	}

}

/*
 * Rtas B: la implementacion es igual, creo que por ser los 2 de la clase
 * collection, usan casi los mismos metodos C: Si? un for normal, un while
 * preguntando por lista.lenght
 */
