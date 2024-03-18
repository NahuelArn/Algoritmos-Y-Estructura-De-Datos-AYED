package tp1.eje7;

import java.util.ArrayList;

public class eje7J {
	public static ArrayList<Integer> combinatoria(ArrayList<Integer> menor, ArrayList<Integer> mayor) { // toma la
																										// primera como
																										// menor
		int leng = mayor.size() - 1;
		int i = 0;
		while (i <= leng) {
			menor.add(mayor.get(i));
			i++;
		}
		return menor;
	}

	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> combinada = new ArrayList<>();
		if ((a.get(a.size() - 1)) < (b.get(b.size() - 1))) { // me dice la estructura A es menor a la B, entonces va
			combinada = combinatoria(a, b);// primero
		} else {
			combinada = combinatoria(b, a);
		}
		return combinada;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			a.add(i);
		}
		for (int i = 5; i < 10; i++) {
			b.add(i);
		}

		ArrayList<Integer> c = combinarOrdenado(a, b);

		for (Integer elemento : c) {
			System.out.print(" [ " + elemento + " ]");
		}
	}
}
