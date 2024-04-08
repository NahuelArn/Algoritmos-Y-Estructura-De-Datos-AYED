package tp1.eje10;

import java.util.Scanner;

public class TheBank {
	// una Queue con una implementacion de insercion al principio
	public static void main(String[] args) {
		EnqueueFirst<String> casa = new EnqueueFirst<>();
//		casa.primerElemento("casa");
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese P: para dar prioridad, N: no dar prioridad, Fin: terminar: ");
		String nombre = s.nextLine();
		while (!nombre.equals("FIN")) {
			if (nombre.equals("P")) {
				casa.alInicio(nombre);
			} else {
				if (nombre.equals("N")) {
					casa.enqueue(nombre);
				}
			}
			System.out.print("Ingrese P: para dar prioridad, N: no dar prioridad, Fin: terminar: ");
			nombre = s.nextLine();
		}
		System.out.println(casa.toString());
	}
}
