package tp3_Practica.eje8;
import java.util.List;

import tp3_Practica.eje5.GeneralTree;

/*Abeto navideño Problem - B - Codeforces
Considere un árbol general. 

Recordemos que el vértice u se llama hijo del vértice v 
y 
el vértice v se llama padre del vértice u 

si existe una arista dirigida de v a u. 

El árbol tiene un vértice distinguido llamado raíz, que es
el único vértice que no tiene padre. Un vértice se llama hoja si no tiene
hijos y tiene padre.

Llamaremos abeto a un árbol si cada vértice no hoja tiene al menos 3
hijos hojas. Dado un árbol general, compruebe si es un abeto.
Input
La primera línea contiene un entero n: el número de vértices en el árbol (3
≤ n ≤ 1000). Cada una de las siguientes n - 1 líneas contiene un entero pi
(1 ≤ i ≤ n - 1) — el índice del padre del i + 1-ésimo vértice (1 ≤ pi ≤ i).
El vértice 1 es la raíz. Está garantizado que la raíz tiene al menos 2 hijos.
Output
Imprima "Yes" si el árbol es un abeto y "No" de lo contrario*/

public class Navidad {
	
	private GeneralTree<Integer> arbol;
	
	public Navidad(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private boolean helperAbeto(GeneralTree<Integer> a) {
	    int cantHojas = 0;
	    List<GeneralTree<Integer>> childActual = a.getChildren();
	    int i = 0;
	    boolean cumple = true; // Inicializamos cumple en true
	    while (i < childActual.size() && cumple) {
	        GeneralTree<Integer> child = childActual.get(i);
	        if (child.isLeaf()) {
	            cantHojas++;
	        } else {
	            if (!helperAbeto(child)) {
	                cumple = false; // Si un subárbol no cumple, cambiamos cumple a false
	            }
	        }
	        i++; // Incrementamos el índice en cada iteración
	    }
	    return cumple && cantHojas >= 3; // Retornamos true solo si cumple y la cantidad de hojas es al menos 3
	}
	
	public String esAbetoNavidenio() {
		String estado = "No";
		if((arbol != null) && (!arbol.isEmpty())) {
			if(helperAbeto(arbol)) {
				estado = "Si";
			}
		}
		return estado;
	}
}
