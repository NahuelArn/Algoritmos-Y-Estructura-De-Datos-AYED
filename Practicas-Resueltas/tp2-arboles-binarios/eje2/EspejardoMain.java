package tp2_Arboles.eje2;

public class EspejardoMain {
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<>();
		BinaryTree<Integer> a1 = new BinaryTree<>(2);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(3);

		a.setData(1);
		a.addLeftChild(a1);
		a.addRightChild(a2);
		a.inOrder();

		BinaryTree<Integer> x = new BinaryTree<Integer>(3);
		x = a.espejardo();
		System.out.println("-------------------");
		x.inOrder();
	}
}
