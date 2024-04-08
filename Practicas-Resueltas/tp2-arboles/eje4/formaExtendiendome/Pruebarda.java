package tp2_Arboles.eje4.formaExtendiendome;

public class Pruebarda {
	public static void main(String[] args) {
		RedBinaria<Integer> a = new RedBinaria<>(10);
		RedBinaria<Integer> a1 = new RedBinaria<>(2);
		RedBinaria<Integer> a2 = new RedBinaria<>(3);
		a.addLeftChild(a1);
		a.addRightChild(a2);
		// ---------------------------rama izquierda-------------------------------
		RedBinaria<Integer> a3 = new RedBinaria<>(5);
		RedBinaria<Integer> a4 = new RedBinaria<>(4);
		a1.addLeftChild(a3);
		a1.addRightChild(a4);

		RedBinaria<Integer> a5 = new RedBinaria<>(7);
		RedBinaria<Integer> a6 = new RedBinaria<>(8);
		a3.addLeftChild(a5);
		a3.addRightChild(a6);

		RedBinaria<Integer> a7 = new RedBinaria<>(5);
		RedBinaria<Integer> a8 = new RedBinaria<>(6);
		a4.addLeftChild(a7);
		a4.addRightChild(a8);
		// ---------------------------rama derecha-------------------------------
		RedBinaria<Integer> a9 = new RedBinaria<>(9);
		RedBinaria<Integer> a10 = new RedBinaria<>(8);
		a2.addLeftChild(a9);
		a2.addRightChild(a10);

		RedBinaria<Integer> a11 = new RedBinaria<>(12);
		RedBinaria<Integer> a12 = new RedBinaria<>(8);
		a9.addLeftChild(a11);
		a9.addRightChild(a12);

		RedBinaria<Integer> a13 = new RedBinaria<>(2);
		RedBinaria<Integer> a14 = new RedBinaria<>(1);
		a10.addLeftChild(a13);
		a10.addRightChild(a14);
//		a.inOrder();
		System.out.println(a.retardio());
	}
}
