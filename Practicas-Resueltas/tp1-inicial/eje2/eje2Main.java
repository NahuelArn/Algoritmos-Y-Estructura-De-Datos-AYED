package tp1.eje2;

import java.util.ArrayList;
import java.util.Scanner;

public class eje2Main {
	public static ArrayList<Integer> conversor(int n){ 
		int actual;
		int cont= 0;
		ArrayList<Integer> listaEnteros = new ArrayList<>(n);
		while(cont < n) {
			actual =n*(cont+1);	
			if(actual >= 1) {
				listaEnteros.add(actual);
			}
			cont++;
		}
		return listaEnteros;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el n");
		ArrayList<Integer> lista = conversor(s.nextInt());
		System.out.println("sali");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("[ "+ lista.get(i) +" ]");
		}
	}
}
