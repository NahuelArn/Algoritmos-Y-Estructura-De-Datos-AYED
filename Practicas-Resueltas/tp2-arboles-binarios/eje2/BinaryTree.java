package tp2_Arboles.eje2;

public class BinaryTree<T> {
	private T dato;
	private BinaryTree<T> hd;
	private BinaryTree<T> hi;

	public BinaryTree() {
		super();
	}

	public BinaryTree(T dato) {
		this.dato = dato;
	}

	public T getData() {
		return dato;
	}

	public void setData(T data) {
		this.dato = data;
	}

	public BinaryTree<T> getLeftChild() {
		return this.hi;
	}

	public BinaryTree<T> getRightChild() {
		return this.hd;
	}

	public void addLeftChild(BinaryTree<T> data) {
		this.hi = data;
	}

	public void addRightChild(BinaryTree<T> data) {
		this.hd = data;
	}

	public void removeLeftChild() {
		this.hi = null;
	}

	public void removeRightChild() {
		this.hd = null;
	}

	public boolean hasLeftChild() {
		return this.hi != null;
	}

	public boolean hasRightChild() {
		return this.hd != null;
	}

	public boolean isLeaf() { // Si no tiene hijos es hoja!
		// return this.hi == null && this.hd == null;
		return !hasLeftChild() && !this.hasRightChild();
	}

	public boolean isEmpty() { // es vacio

		return isLeaf() && this.getData() == null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int countSheets() {
		int suma = 0;
		if (this.getData() == null) {
			return 0;
		} else {
			if (isLeaf()) {
				return 1;
			} else {
				if (this.hasLeftChild()) {
					suma += getLeftChild().countSheets();
				}
				if (this.hasRightChild()) {
					suma += getRightChild().countSheets();
				}
			}
		}
		return suma;
	}

	public void inOrder() {
		if (this.getData() != null) {
			if (this.hasLeftChild()) {
				this.getLeftChild().inOrder();
			}
			System.out.println("valor: " + this.getData());
			if (this.hasRightChild()) {
				this.getRightChild().inOrder();
			}
		}
	}

	public BinaryTree<T> espejardo() {
		BinaryTree<T> e = new BinaryTree<>(this.getData());
		if (this.getData() != null) {
			if (this.hasLeftChild()) {
				e.addRightChild(this.getLeftChild().espejardo());
			}
			if (this.hasRightChild()) {
				e.addLeftChild(this.getRightChild().espejardo());
			}

		}
		return e;
	}

	public void entreNiveles(int izquierda, int derecha) {
		String s;
		if (this.isEmpty() || !(izquierda >= 0) || !(izquierda < derecha)) { 
			System.out.println("Vacio o rangos no validos");
		} else {
			Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
			queue.enqueue(this);
			int nivelActual = 0;

			while (!queue.isEmpty()) {
				int dimFQueue = queue.size(); // uso el tamanho de la Queue para obtener el nivel
				// System.out.println("tamanho queuae: " + dimFQueue);
				s = " ";
				if (nivelActual >= izquierda && nivelActual <= derecha) {
					for (int i = 0; i < dimFQueue; i++) { // proceso todos los nodos del nivel actual
						BinaryTree<T> nodoActual = queue.dequeue();
						// System.out.println("Nodo actual" + nodo.getData() + " | "); //imprime el nodo actual
						s += nodoActual.getData() + " | ";
						if (nodoActual.hasLeftChild()) { // Agrega los hijos a la Queue
							queue.enqueue(nodoActual.getLeftChild());
						}
						if (nodoActual.hasRightChild()) {
							queue.enqueue(nodoActual.getRightChild());
						}
					}
				} else {
					for (int i = 0; i < nivelActual; i++) { // se encarga de descartar los los nodos de los niveles que no entan en el rango
						queue.dequeue();
					}
				}
				System.out.println("nivel actual: " + nivelActual + " Valores en este nivel: " + s);
				nivelActual++;
			}
		}
	}
}
