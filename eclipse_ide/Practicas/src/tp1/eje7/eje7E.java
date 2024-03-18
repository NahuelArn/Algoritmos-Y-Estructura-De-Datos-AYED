package tp1.eje7;

import java.util.ArrayList;

public class eje7E {
	public static boolean esCapicua(ArrayList<Integer> vD) {
		boolean estado = true;
		int ini = 0, fin = vD.size() - 1; // el "vectr dinamico siempre arranca en 0"
		while ((ini < fin) && (estado)) {
			if (!vD.get(ini).equals(vD.get(fin))) {
				estado = false;
			}
			ini++;
			fin--;
		}
		return estado;
	}

	public static void main(String[] args) {
		ArrayList<Integer> vectorDinamico = new ArrayList<>();
//		System.out.println(100 % 10); // Resto <--
//		System.out.println(100 / 10); // Cociente -->
		vectorDinamico.add(1);
		vectorDinamico.add(0);
		vectorDinamico.add(0);
		vectorDinamico.add(3);
		if (esCapicua(vectorDinamico)) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No es capicua, fran");
		}

	}
}
