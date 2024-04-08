package tp2_Arboles.eje3;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		BinaryTree<Integer> aB = new BinaryTree<>();
		aB.setData(2);
		BinaryTree<Integer> aB1 = new BinaryTree<>(6);
		BinaryTree<Integer> aB2 = new BinaryTree<>(4);
		aB.addLeftChild(aB1);
		aB.addRightChild(aB2);
		// ss
		ContadorArbol a = new ContadorArbol(aB);
		ArrayList<Integer> vD = a.numerosPares();
		System.out.print("Pares InOrder Valores : ");
		for (Integer i : vD) {
			System.out.print(i + " | ");
		}
		// ---------------------------------
		System.out.println();
		System.out.print("Pares PostOrder Valores: ");
		ArrayList<Integer> vD2 = a.numerosParesV2();
		for (Integer i : vD2) {
			System.out.print(i + " | ");
		}
	}
}
