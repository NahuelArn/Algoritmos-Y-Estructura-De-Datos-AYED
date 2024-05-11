package tp2_Arboles.eje123456new.eje1;

public class Main {
	public static void main(String[] args) {
//		BinaryTree<Integer> a = new BinaryTree<>(1);
//		BinaryTree<Integer> hijo;
//		a.addLeftChild(hijo = new BinaryTree<>(2));
//		a.addRightChild(hijo = new BinaryTree<>(3));
////		a.getRightChild().addRightChild(hijo = new BinaryTree<>(5));
//		a.getLeftChild().addRightChild(hijo = new BinaryTree<>(5));
//		a.getLeftChild().addLeftChild(hijo = new BinaryTree<>(4));
//		a.getRightChild().addLeftChild(hijo = new BinaryTree<>(6));
//		
////		System.out.println(a.toString());
////		System.out.println();
////		
////		System.out.print("contar: "+ a.contarHojas());
//		
//		
//		a.inOrderr();
//		hijo = a.espejo();
//		System.out.println("----------");
////		System.out.println(""+hijo.getData());
//		hijo.inOrderr();

		// Crear el nodo raíz con valor 1
		BinaryTree<Integer> arbol = new BinaryTree<>(1);

		// Agregar hijos al nodo raíz
		arbol.addLeftChild(new BinaryTree<>(2));
		arbol.addRightChild(new BinaryTree<>(3));

		// Obtener referencias a los nodos hijos para agregar sus hijos
		BinaryTree<Integer> nodoIzquierdo = arbol.getLeftChild();
		BinaryTree<Integer> nodoDerecho = arbol.getRightChild();

		// Agregar hijos al nodo izquierdo (2)
		nodoIzquierdo.addLeftChild(new BinaryTree<>(3));
		nodoIzquierdo.addRightChild(new BinaryTree<>(4));

		// Agregar hijos al nodo derecho (3)
		nodoDerecho.addLeftChild(new BinaryTree<>(5));
		nodoDerecho.addRightChild(new BinaryTree<>(6));

		// Obtener referencias a los nodos hijos para agregar sus hijos
		BinaryTree<Integer> nodoIzquierdoIzquierdo = nodoIzquierdo.getLeftChild();
		BinaryTree<Integer> nodoIzquierdoDerecho = nodoIzquierdo.getRightChild();
		BinaryTree<Integer> nodoDerechoIzquierdo = nodoDerecho.getLeftChild();
		BinaryTree<Integer> nodoDerechoDerecho = nodoDerecho.getRightChild();

		// Agregar hijos a los nodos correspondientes
		nodoIzquierdoIzquierdo.addLeftChild(new BinaryTree<>(4));
		nodoIzquierdoIzquierdo.addRightChild(new BinaryTree<>(5));

		nodoIzquierdoDerecho.addLeftChild(new BinaryTree<>(6));
		nodoIzquierdoDerecho.addRightChild(new BinaryTree<>(7));

		nodoDerechoIzquierdo.addLeftChild(new BinaryTree<>(8));
		nodoDerechoIzquierdo.addRightChild(new BinaryTree<>(9));

		nodoDerechoDerecho.addLeftChild(new BinaryTree<>(11));
		nodoDerechoDerecho.addRightChild(new BinaryTree<>(13));
//        		   1
//        	  /         \
//		    2              3
//		 /    \          /   \
//		3      4       5      6
//	   /\     / \     / \    / \ 
//    4  5     6  7   8  9  11  13
		arbol.inOrderr();

		arbol.entreNiveles(0, 1);
	}
}
