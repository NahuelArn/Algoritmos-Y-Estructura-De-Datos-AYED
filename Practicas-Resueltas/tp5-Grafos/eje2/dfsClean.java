package Grafos.tp.eje2;

import java.util.LinkedList;
import java.util.List;

import Grafos.tp.eje1.Edge;
import Grafos.tp.eje1.Graph;
import Grafos.tp.eje1.Vertex;
import Grafos.tp.eje1.adjList.AdjListGraph;

public class dfsClean {
	//recorro la estructura principal desde aca
		public static <T>List<T> dfs(Graph<T> grafo){
			List<T> lis = new LinkedList<>();
			if(grafo != null && !grafo.isEmpty()) {
				boolean [] visitados = new boolean [grafo.getSize()];	//java por defecto inicializa en false all elements
				for (int i = 1; i < grafo.getSize(); i++) {
					if(!visitados[i]) {
						System.out.println("Desde donde lo tiro: "+grafo.getVertex(i).getData());
						System.out.println();
						lis.add(grafo.getVertex(i).getData());
						helperDfs(i,grafo,visitados);	//aca mando el vertice para que recorra sus adyacentes
					}
				}
			}
			return lis;
		}
		
		//este itera sobre los adyacentes
		private static <T> void helperDfs(int i, Graph<T> grafo,boolean [] visitados) {
			visitados[i] = true;
			Vertex<T> vertActual = grafo.getVertex(i);
			System.out.println(vertActual.getData());
			List<Edge<T>> adyacentes = grafo.getEdges(vertActual);
			for (Edge<T> adyActual: adyacentes) {
				int posSig = adyActual.getTarget().getPosition();
				if(!visitados[posSig]) {
					helperDfs(posSig,grafo,visitados);
				}
			}
		}
		
		public static void main(String[] args) {
			Graph<String> ciudades = new AdjListGraph<String>();
			Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
	        Vertex<String> v2 = ciudades.createVertex("Santiago");
	        Vertex<String> v3 = ciudades.createVertex("Asunción");
	        Vertex<String> v4 = ciudades.createVertex("Tokio");
	        Vertex<String> v5 = ciudades.createVertex("Roma");
	        Vertex<String> v6 = ciudades.createVertex("Paris");
	        Vertex<String> v7 = ciudades.createVertex("Madrid");
	        Vertex<String> v8 = ciudades.createVertex("Caracas");
	        ciudades.connect(v1, v2);
	        ciudades.connect(v1, v3);
	        ciudades.connect(v2, v5);
	        ciudades.connect(v3, v7);
	        ciudades.connect(v3, v8);
	        ciudades.connect(v8, v7);
	        ciudades.connect(v8, v4);
	        ciudades.connect(v5, v4);
	        ciudades.connect(v7, v4);
	        ciudades.connect(v6, v5);
	        ciudades.connect(v6, v7);
	        ciudades.connect(v6, v4);
	        ciudades.connect(v4, v1);
	        
	        List<String> listaDFS = dfs(ciudades);
//	        for (String i: listaDFS) {
//	        	System.out.println("je: "+ i);
//	        }
		}
}
