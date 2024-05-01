package tp2_Arboles.eje123456new.eje1;

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

	private int inOrden(BinaryTree<T> a) {
		int b = 0;
		int aa = 0;
		if (a.isLeaf()) {
			return 1;
		} else {
			if (a.hasLeftChild()) {
				aa += inOrden(a.getLeftChild());
			}
			if (a.hasRightChild()) {
				b += inOrden(a.getRightChild());
			}
			return b + aa;
		}
	}

	public int contarHojas() {
		int suma = 0;
		if (this.getData() != null) {
			suma = inOrden(this);
		}
		return suma;
	}

	public void inOrderr() {
		if (this.getData() != null) { // con esto me aseguro que el arbol no sea null
			if (this.hasLeftChild()) {
				this.getLeftChild().inOrderr();
			}
			System.out.println("valor: " + this.getData());
			if (this.hasRightChild()) {
				this.getRightChild().inOrderr();
			}
		}
	}
//logica de mas
//	private BinaryTree<T> helperEspejardo() {
//		BinaryTree<T> r = new BinaryTree<>(this.getData());
//		if(this.hasLeftChild()) {
//			r.addRightChild(this.getLeftChild().helperEspejardo()); 
//		}
//		if(this.hasRightChild()) {
//			r.addLeftChild(this.getRightChild().helperEspejardo()); 
//		}
//		
//		return r;
//	}
//    public BinaryTree<T> espejo(){
//    	BinaryTree<T> r = new BinaryTree<>();
//    	if(this.getData() != null) {
//    		r = helperEspejardo();
//       }
// 	   return r;
//    }

	// 0<=n<=m
	public BinaryTree<T> espejo() {
		BinaryTree<T> r = new BinaryTree<>(this.getData());
		if (this.hasLeftChild()) {
			r.addRightChild(this.getLeftChild().espejo());
		}
		if (this.hasRightChild()) {
			r.addLeftChild(this.getRightChild().espejo());
		}
		return r;
	}

	public void entreNiveles(int izquierda, int derecha) {
		String s = "";
		if (this.isEmpty() || !(izquierda >= 0) || !(izquierda <= derecha)) {
			System.out.println("Error flaquito");
		} else {
			Queue<BinaryTree<T>> queue = new Queue<>();
			queue.enqueue(this);
			int nivelActual = 0;
			while (!queue.isEmpty()) {

				int dimFqueue = queue.size(); // esto lo voy a usar como nivel del arbol con delay de 1
				if (nivelActual >= izquierda && nivelActual <= derecha) {
					for (int i = 0; i < dimFqueue; i++) {
						BinaryTree<T> nodoActual = queue.dequeue();
						s += nodoActual.getData() + " | ";
						if (nodoActual.hasLeftChild()) {
							queue.enqueue(nodoActual.getLeftChild());
						}
						if (nodoActual.hasRightChild()) {
							queue.enqueue(nodoActual.getRightChild());
						}
					}
				} else {
					for (int i = 0; i < nivelActual; i++) {
						queue.dequeue();
					}
				}
				nivelActual++;
			}
		}
		System.out.println(s);
	}

}
