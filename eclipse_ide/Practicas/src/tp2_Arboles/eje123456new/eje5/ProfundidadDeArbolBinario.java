package eje5;
import eje1.BinaryTree;
import eje1.Queue;
import eje1.Sequence;;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public ProfundidadDeArbolBinario() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	private int helperSuma(int p) {
		int suma = 0;
		Queue<BinaryTree<Integer>> queue = new Queue<>();
		int nivelActual = 0;
		queue.enqueue(arbol);
		while(!queue.isEmpty()) {
			int dimFqueue = queue.size();	//cantidad de padres		
			if(p != nivelActual) {				
				for (int i = 0; i < dimFqueue; i++) {
					BinaryTree<Integer> nodoActual = queue.dequeue();
					if(nodoActual.hasLeftChild()) {
						queue.enqueue(nodoActual.getLeftChild());
					}
					if(arbol.hasRightChild()) {
						queue.enqueue(nodoActual.getRightChild());
					}
				}
			}else {
				for (int i = 0; i < dimFqueue; i++) {
					suma+= queue.dequeue().getData();
				}
			}
			nivelActual++;					
		}
		return suma;
	}
	
	public int sumaElementosProfundidad(int p) {
		int suma = 0;
		if(!arbol.isEmpty()) {
			suma = helperSuma(p);
		}
		return suma;
	}
}
