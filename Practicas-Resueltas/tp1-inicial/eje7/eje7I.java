package tp1.eje7;

import java.util.LinkedList;
import java.util.Scanner;

public class eje7I {

	public static int sumarRecursivamente(LinkedList<Integer> lD, int i) {
		if (i == lD.size()) { // si esta vacia
			return 0;
		} else {
			return lD.get(i) + sumarRecursivamente(lD, i + 1); // el 1++ rompe nose por q
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> lD = new LinkedList<>();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese numeros q se van a sumar recursivamente");
		int num;

		while ((num = s.nextInt()) != -1) {
			lD.add(num);
		}
		int i = 0;
		System.out.println("size: " + lD.size());
		System.out.println("la suma es: " + sumarRecursivamente(lD, i));
	}
}
