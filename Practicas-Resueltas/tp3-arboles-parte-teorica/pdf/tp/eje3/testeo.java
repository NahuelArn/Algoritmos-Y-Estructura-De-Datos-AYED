package tp3.eje3;

public class testeo {
	public static void main(String[] args) {
		/* con 'esCon estas comillas' "y con estas comillas un string" */
		BinaryTree<Character> arbol = new BinaryTree<Character>('A');
		BinaryTree<Character> aux1 = new BinaryTree<Character>('B');
		BinaryTree<Character> aux2 = new BinaryTree<Character>('C');
		BinaryTree<Character> aux3 = new BinaryTree<Character>('D');

		arbol.addLeftChild(aux1);
		arbol.addMidChild(aux2);
		arbol.addRightChild(aux3);

		arbol.getMidChild().addLeftChild(new BinaryTree<Character>('E'));
		arbol.getMidChild().addRightChild(new BinaryTree<Character>('F'));
		;

		arbol.getMidChild().getRightChild().addLeftChild(new BinaryTree<Character>('J'));
		arbol.getMidChild().getRightChild().addRightChild(new BinaryTree<Character>('K'));

		arbol.getRightChild().addLeftChild(new BinaryTree<Character>('G'));
		arbol.getRightChild().addMidChild(new BinaryTree<Character>('H'));
		arbol.getRightChild().addRightChild(new BinaryTree<Character>('I'));

		arbol.inOrder();
		// System.out.println(arbol.getData());
		arbol.cantNodosEnNivelBuscado(3);

	}

}
