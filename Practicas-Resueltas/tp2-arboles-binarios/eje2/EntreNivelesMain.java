package tp2_Arboles.eje2;

public class EntreNivelesMain {
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<>(1);
		BinaryTree<Integer> a1 = new BinaryTree<>(2);
		BinaryTree<Integer> a2 = new BinaryTree<>(3);
		a.addLeftChild(a1);
		a.addRightChild(a2);
		a.entreNiveles(0, 1);
//		BinaryTree<Integer> a1 = new BinaryTree<>(1);
//		BinaryTree<Integer> a2 = new BinaryTree<>(1);

	}
}
