package tp2_Arboles.eje2;

public class ContandoMain {
	public static void main(String[] args) {
		BinaryTree<Integer> b = new BinaryTree<Integer>();
		BinaryTree<Integer> b1 = new BinaryTree<Integer>();
		BinaryTree<Integer> b2 = new BinaryTree<Integer>();
		BinaryTree<Integer> b3 = new BinaryTree<Integer>();
		BinaryTree<Integer> b4 = new BinaryTree<Integer>();
		BinaryTree<Integer> b5 = new BinaryTree<Integer>(5);
		b1.setData(2);
		b2.setData(3);
		b3.setData(4);

		b.setData(1);
		b.addLeftChild(b1);
		b.addRightChild(b2);

		b1.addLeftChild(b3);
		b1.addRightChild(b5);
		b.inOrder();
		System.out.println("cantidad de hojas: " + b.countSheets());// puntero a la raiz del arbol
	}
}
