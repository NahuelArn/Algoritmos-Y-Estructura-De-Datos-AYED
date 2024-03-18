package tp1.eje7;

import java.util.ArrayList;

public class eje7H {
	public static ArrayList<Integer> invertirRecursivo(ArrayList<Integer> vD, int ini, int fin) {
		if (ini < fin) {
			int temp = vD.get(ini);
			vD.set(ini, vD.get(fin)); // Swap
			vD.set(fin, temp);
			return invertirRecursivo(vD, ini + 1, fin - 1);
		}
		return vD;
	}

	public static ArrayList<Integer> invertir(ArrayList<Integer> vD) {

		return invertirRecursivo(vD, 0, vD.size() - 1);
	}

	public static void imprimir(ArrayList<Integer> vD) {
		for (Integer elemento : vD) {
			System.out.println(" [ " + elemento + " ]");
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> vD = new ArrayList<>();
		vD.add(1);
		vD.add(2);
		vD.add(3);
		vD.add(4);
		vD.add(5);
		System.out.println("Antes de invertir");
		imprimir(vD);
		invertir(vD);
		System.out.println("Despues de invertir");
		imprimir(vD);
	}
}
