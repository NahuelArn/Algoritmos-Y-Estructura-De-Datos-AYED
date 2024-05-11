package tp2_Arboles.eje4.formaAtributoPrivado;

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
}
