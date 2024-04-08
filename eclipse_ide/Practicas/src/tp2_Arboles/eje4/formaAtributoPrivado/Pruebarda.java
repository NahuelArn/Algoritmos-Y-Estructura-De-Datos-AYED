package tp2_Arboles.eje4.formaAtributoPrivado;

public class Pruebarda {
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<>(10);
		BinaryTree<Integer> a1 = new BinaryTree<>(2);
		BinaryTree<Integer> a2 = new BinaryTree<>(3);
		a.addLeftChild(a1);
		a.addRightChild(a2);
		// ---------------------------rama izquierda-------------------------------
		BinaryTree<Integer> a3 = new BinaryTree<>(5);
		BinaryTree<Integer> a4 = new BinaryTree<>(4);
		a1.addLeftChild(a3);
		a1.addRightChild(a4);

		BinaryTree<Integer> a5 = new BinaryTree<>(7);
		BinaryTree<Integer> a6 = new BinaryTree<>(8);
		a3.addLeftChild(a5);
		a3.addRightChild(a6);

		BinaryTree<Integer> a7 = new BinaryTree<>(5);
		BinaryTree<Integer> a8 = new BinaryTree<>(6);
		a4.addLeftChild(a7);
		a4.addRightChild(a8);
		// ---------------------------rama derecha-------------------------------
		BinaryTree<Integer> a9 = new BinaryTree<>(9);
		BinaryTree<Integer> a10 = new BinaryTree<>(8);
		a2.addLeftChild(a9);
		a2.addRightChild(a10);

		BinaryTree<Integer> a11 = new BinaryTree<>(12);
		BinaryTree<Integer> a12 = new BinaryTree<>(8);
		a9.addLeftChild(a11);
		a9.addRightChild(a12);

		BinaryTree<Integer> a13 = new BinaryTree<>(2);
		BinaryTree<Integer> a14 = new BinaryTree<>(1);
		a10.addLeftChild(a13);
		a10.addRightChild(a14);

		RedBinaria x = new RedBinaria(a);
		System.out.println(x.retardio());
	}
}
