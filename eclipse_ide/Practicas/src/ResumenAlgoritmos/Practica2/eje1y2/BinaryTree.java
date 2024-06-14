package ResumenAlgoritmos.Practica2.eje1y2;

import tp2_Arboles.eje123456new.eje1.Queue;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

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

	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public void preOrden() {
		if (!this.isEmpty()) {
			System.out.println(this.getData());

			if (this.hasLeftChild()) {
				this.getLeftChild().preOrden();
			}

			if (this.hasRightChild()) {
				this.getRightChild().preOrden();
			}
		}
	}

	public void inOrden() {
		if (!this.isEmpty()) {
			if (this.hasLeftChild()) {
				this.getLeftChild().inOrden();
			}
			System.out.println(this.getData() + " ");
			if (this.hasRightChild()) {
				this.getRightChild().inOrden();
			}
		}
	}

	public void posOrden() {
		if (!this.isEmpty()) {
			if (this.hasLeftChild()) {
				this.getLeftChild().posOrden();
			}
			if (this.hasRightChild()) {
				this.getRightChild().posOrden();
			}
			System.out.println(this.getData() + " ");
		}
	}

	public int contadarHojas() {
		if (this.isEmpty()) {
			return 0;
		}
		if (this.isLeaf()) {
			return 1;
		}
		return this.getLeftChild().contadarHojas() + this.getRightChild().contadarHojas();
	}

	// me retorna un arbol invertido tipo espejo
	public BinaryTree<T> espejo() {
		BinaryTree<T> a = new BinaryTree<>(this.getData());
		if (this.hasLeftChild()) {
			a.addRightChild(this.getLeftChild().espejo());
		}
		if (this.hasRightChild()) {
			a.addLeftChild(this.getRightChild().espejo());
		}
		return a;
	}

	// Iterativo usando una Queue
	public void entreNiveles(int izq, int der) {
		String s = " ";
		if (this.isEmpty() || !(izq >= 0) || !(izq <= der)) { // validador pos validas
			System.out.println("Error Flaquito ");
		} else {
			Queue<BinaryTree<T>> queue = new Queue<>();
			int nivelActual = 0;
			queue.enqueue(this);
			while (!queue.isEmpty()) {
				int dimFqueue = queue.size();
				if (nivelActual >= izq && nivelActual <= der) { // proceso los niveles buscados
					for (int i = 0; i < dimFqueue; i++) {
						BinaryTree<T> nodoActual = queue.dequeue(); // me traigo el nodo actual
						s += nodoActual.getData() + " | "; // salvo el dato
						if (nodoActual.hasLeftChild()) { // encolo el nivel de este nodo
							queue.enqueue(nodoActual.getLeftChild());
						}
						if (nodoActual.hasRightChild()) {
							queue.enqueue(nodoActual.getRightChild());
						}
					}
				} else {// esto me sirve para ir limpiendo la Queue de los niveles q ya no me sirven
					for (int i = 0; i < dimFqueue; i++) { // si dimF = 0; no saco al elemento
						queue.dequeue();
					}
				}
				nivelActual++; // incrementa hasta llegar a la izq deseada
			}
		}
		System.out.println("Arbol por niveles: " + s); // Imprimo el String que forme
	}
}
//	public void entreNiveles(int izquierda, int derecha) {
//		String s = "";
//		if (this.isEmpty() || !(izquierda >= 0) || !(izquierda <= derecha)) {
//			System.out.println("Error flaquito");
//		} else {
//			Queue<BinaryTree<T>> queue = new Queue<>();
//			queue.enqueue(this);
//			int nivelActual = 0;
//			while (!queue.isEmpty()) {
//
//				int dimFqueue = queue.size(); // esto lo voy a usar como nivel del arbol con delay de 1
//				if (nivelActual >= izquierda && nivelActual <= derecha) {
//					for (int i = 0; i < dimFqueue; i++) {
//						BinaryTree<T> nodoActual = queue.dequeue();
//						s += nodoActual.getData() + " | ";
//						if (nodoActual.hasLeftChild()) {
//							queue.enqueue(nodoActual.getLeftChild());
//						}
//						if (nodoActual.hasRightChild()) {
//							queue.enqueue(nodoActual.getRightChild());
//						}
//					}
//				} else {
//					for (int i = 0; i < nivelActual; i++) {
//						queue.dequeue();
//					}
//				}
//				nivelActual++;
//			}
//		}
//		System.out.println(s);
//	}
