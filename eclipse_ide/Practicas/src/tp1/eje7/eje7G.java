package tp1.eje7;

import java.util.ArrayList;
import java.util.Scanner;

public class eje7G {

	public static int esPar(int num) {
		int resultado = num / 2;
		return resultado;
	}

	public static int noEsPar(int num) {
		int result = (num * 3) + 1;
		return result;
	}

	public static boolean mediador(int num) { // tira true si es par
		return (num % 2 == 0);
	}

	public static ArrayList<Integer> desarrolloDeLogica(ArrayList<Integer> vD, int n) {
		if (n == 1) {
			return vD;
		} else {
			if (mediador(n)) {
				n = esPar(n);
			} else {
				n = noEsPar(n);
			}
			vD.add(n);
			return desarrolloDeLogica(vD, n);
		}
	}

	public static ArrayList<Integer> recursivo(int n) {
		ArrayList<Integer> vD = new ArrayList<>();
		vD.add(n);
		desarrolloDeLogica(vD, n);
		return vD;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numero n");
		int num = s.nextInt();
//		ArrayList<Integer> vD = new ArrayList<>();
		ArrayList<Integer> vD;
		vD = recursivo(num);
		for (Integer elemento : vD) {
			System.out.print(" [ " + elemento + " ]");
		}
	}
}
