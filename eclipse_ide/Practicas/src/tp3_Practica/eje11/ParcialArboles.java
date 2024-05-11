package tp3_Practica.eje11;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;
import tp3_Practica.eje2.Queue;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean cumple = false;
		if(arbol != null && !arbol.isEmpty() ) {
			Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
			int nivelEsperado = 1;
			cumple = true;
			while(!queue.isEmpty() && cumple) {
				int dimF = queue.size();
				if(nivelEsperado == dimF) {
					int i = 0;
					while(i < dimF && cumple) {
						List<GeneralTree<Integer>> childActual = queue.dequeue().getChildren();
						for (GeneralTree<Integer> o: childActual) {
							queue.enqueue(o);
						}
						i++;
					}
					nivelEsperado++;
				}else {
					cumple = false;
				}
			}
			if(!cumple) {
				for (int i =0; i < queue.size(); i++) {
					queue.dequeue();
				}
			}
		}
		return cumple;
		
	}
}
