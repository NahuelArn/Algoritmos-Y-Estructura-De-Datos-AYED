package tp2_Arboles.eje3;

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

}
