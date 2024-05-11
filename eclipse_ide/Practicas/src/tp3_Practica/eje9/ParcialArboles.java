package tp3_Practica.eje9;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;
import tp3_Practica.eje2.Queue;
import tp3_Practica.eje2.Sequence;
/* Un árbol general es de selección si cada nodo tiene en su raíz el valor 
 * del menor de sus hijos.*/

public class ParcialArboles {
	
	//por niveles detecto mas facil cuando no cumple, voy de arriba hacia abajo
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean estado = true;
		if(arbol != null && !arbol.isEmpty()) {
			Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
			queue.enqueue(arbol);
			while(!queue.isEmpty() && estado) {
				int dimF = queue.size();
				int i = 0;
				while (i < dimF && estado) {
					GeneralTree<Integer> arbolActual = queue.dequeue();
					if(arbolActual.hasChildren()) {
						List<GeneralTree<Integer>> childActual = arbolActual.getChildren();
						int padreActual = arbolActual.getData();
							int minimo = Integer.MAX_VALUE;
							for (GeneralTree<Integer> o: childActual) {
								minimo = Math.min(minimo,o.getData());
								queue.enqueue(o);
							}
							if(minimo != padreActual) {
								estado=false;
							}
					}
					i++;
				}
			}
			if(!estado) {	//significa que alguno no cumplio y me quedaron cargado la queue, por cortar directo
				for (int i = 0; i < queue.size(); i++) {
					queue.dequeue();
				}
			}
		}
		return estado;
	}


}
