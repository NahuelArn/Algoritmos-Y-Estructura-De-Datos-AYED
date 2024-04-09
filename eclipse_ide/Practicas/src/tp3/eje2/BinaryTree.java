package tp3.eje2;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> mid;
	private BinaryTree<T> rightChild;

	public BinaryTree() {

	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	/** @Param setea un valor en el nodo **/
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * 
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * 
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty() { // si no tiene hijos ni tiene dato en el padre
		return (this.isLeaf() && this.getData() == null);
	}

	/** @return retorna true, si es hoja el nodo actul **/
	public boolean isLeaf() { // es hoja
		return (!this.hasLeftChild() && !this.hasRightChild());

	}

	/**
	 * Retorna true, si tiene un hijo izquierdo
	 * 
	 * @return
	 */
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	/**
	 * Retorna true, si tiene un hijo derecho
	 * 
	 * @return
	 */
	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public void inOrder() {
		if (this.getData() != null) {
			if (this.hasLeftChild()) {
				this.getLeftChild().inOrder();
			}
			if (this.getMidChild() != null) {
				this.getMidChild().inOrder();
			}
			System.out.println("valor: " + this.getData());
			if (this.hasRightChild()) {
				this.getRightChild().inOrder();
			}
		}
	}

	// 0000000000000000000000000000000000000000
	public void addMidChild(BinaryTree<T> child) {
		this.mid = child;
	}

	public BinaryTree<T> getMidChild() {
		return this.mid;
	}

	public void cantNodosEnCadaNivel() {
		if (this.isEmpty()) {
			System.out.println("El arbol esta vacio");
		} else {
			Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
			queue.enqueue(this);
			int cantNiveles = 0;
			while (!queue.isEmpty()) {
				int dimFQueue = queue.size(); // uso el tamanho de la Queue para obtener el nivel
				for (int i = 0; i < dimFQueue; i++) { // proceso todos los nodos del nivel actual
					BinaryTree<T> nodoActual = queue.dequeue();
					if (nodoActual.hasLeftChild()) { // Agrega los hijos a la Queue
						queue.enqueue(nodoActual.getLeftChild());
					}
					if (nodoActual.getMidChild() != null) {
						queue.enqueue(nodoActual.getMidChild());
					}
					if (nodoActual.hasRightChild()) {
						queue.enqueue(nodoActual.getRightChild());
					}
				}
				System.out.println("Nivel " + cantNiveles + " : " + dimFQueue);
				cantNiveles++;
			}
		}

	}

	// 0000000000000000000000000000000000000000000
	public int contarHojas() {
		int suma = 0;
		if (this.getData() == null) { // si no es un arbol nulo
			System.out.println("cassadasda");
			return 0;
		} else {
			if (this.isLeaf()) { // si es hoja
				return 1;
			} else {
				if (this.hasLeftChild()) {
					suma += this.getLeftChild().contarHojas();
				}
				if (this.hasRightChild()) {
					suma += this.getRightChild().contarHojas();
				}
			}
		}
		return suma;
	}

}
