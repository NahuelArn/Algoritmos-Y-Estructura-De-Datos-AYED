package tp2_Arboles.eje123456new.eje3;

import tp2_Arboles.eje123456new.eje1.BinaryTree;

public class RedBinariaLlena<T> extends BinaryTree<Integer> {

	public RedBinariaLlena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RedBinariaLlena(Integer data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	private int helper(BinaryTree<Integer> a) {
		int x = 0;
		int z = 0;
		int suma = 0;
		if (a.isLeaf()) {
			return (int) a.getData();
		} else {
			if (a.hasLeftChild()) {
				x = helper(a.getLeftChild());
			}
			if (a.hasRightChild()) {
				z = helper(a.getRightChild());
			}
			System.out.println("x: " + x + " z: " + z);

			if (x > z) {
				suma = (int) a.getData() + x;
				System.out.println("suma izquierda: " + suma);
			} else {
				suma = (int) a.getData() + z;
				System.out.println("suma derecha: " + suma);
			}

		}
		return suma;

	}

	public int retardoReenvio() {
		int cant = 0;
		if (!this.isEmpty()) {
			cant = helper(this);
		}
		return cant;
	}
}
