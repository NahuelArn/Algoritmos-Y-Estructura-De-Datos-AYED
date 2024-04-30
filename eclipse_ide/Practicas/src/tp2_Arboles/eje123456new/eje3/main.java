package tp2_Arboles.eje123456new.eje3;
import tp2_Arboles.eje1.BinaryTree;


public class main {
	public static void main(String[] args) {
		RedBinariaLlena<Integer> a = new RedBinariaLlena<>(10);
		RedBinariaLlena<Integer> a1 = new RedBinariaLlena<>(2);
		RedBinariaLlena<Integer> a2 = new RedBinariaLlena<>(3);
		a.addLeftChild(a1);
		a.addRightChild(a2);
		// ---------------------------rama izquierda-------------------------------
		RedBinariaLlena<Integer> a3 = new RedBinariaLlena<>(5);
		RedBinariaLlena<Integer> a4 = new RedBinariaLlena<>(4);
		a1.addLeftChild(a3);
		a1.addRightChild(a4);

		RedBinariaLlena<Integer> a5 = new RedBinariaLlena<>(7);
		RedBinariaLlena<Integer> a6 = new RedBinariaLlena<>(8);
		a3.addLeftChild(a5);
		a3.addRightChild(a6);

		RedBinariaLlena<Integer> a7 = new RedBinariaLlena<>(5);
		RedBinariaLlena<Integer> a8 = new RedBinariaLlena<>(6);
		a4.addLeftChild(a7);
		a4.addRightChild(a8);
		// ---------------------------rama derecha-------------------------------
		RedBinariaLlena<Integer> a9 = new RedBinariaLlena<>(9);
		RedBinariaLlena<Integer> a10 = new RedBinariaLlena<>(8);
		a2.addLeftChild(a9);
		a2.addRightChild(a10);

		RedBinariaLlena<Integer> a11 = new RedBinariaLlena<>(12);
		RedBinariaLlena<Integer> a12 = new RedBinariaLlena<>(8);
		a9.addLeftChild(a11);
		a9.addRightChild(a12);

		RedBinariaLlena<Integer> a13 = new RedBinariaLlena<>(2);
		RedBinariaLlena<Integer> a14 = new RedBinariaLlena<>(1);
		a10.addLeftChild(a13);
		a10.addRightChild(a14);
//		a.inOrder();
		System.out.println(a.retardoReenvio());
	}
}
