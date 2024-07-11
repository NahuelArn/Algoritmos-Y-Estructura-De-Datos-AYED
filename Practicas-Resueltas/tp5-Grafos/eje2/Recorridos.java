package Grafos.tp.eje2;

import java.util.LinkedList;
import java.util.List;

import Binarios.pdf.eje2.Queue;
import Grafos.tp.eje1.Edge;
import Grafos.tp.eje1.Graph;
import Grafos.tp.eje1.Vertex;
import Grafos.tp.eje1.adjList.AdjListGraph;

public class Recorridos {
	//recorro la estructura principal desde aca
	public static <T>List<T> dfs(Graph<T> grafo){
		List<T> lis = new LinkedList<>();
		if(grafo != null && !grafo.isEmpty()) {
			boolean [] visitados = new boolean [grafo.getSize()];	//java por defecto inicializa en false all elements
			for (int i = 1; i < grafo.getSize(); i++) {
				if(!visitados[i]) {
					System.out.println("Desde donde lo tiro: "+grafo.getVertex(i).getData());
					System.out.println();
					helperDfs(i,grafo,visitados,lis);	//aca mando el vertice para que recorra sus adyacentes
				}
			}
		}
		return lis;
	}
	
	//este itera sobre los adyacentes
	private static <T> void helperDfs(int i, Graph<T> grafo,boolean [] visitados,List<T> lis) {
		visitados[i] = true;
		Vertex<T> vertActual = grafo.getVertex(i);
		lis.add(vertActual.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(vertActual);
		for (Edge<T> adyActual: adyacentes) {
			int posSig = adyActual.getTarget().getPosition();
			if(!visitados[posSig]) {
				helperDfs(posSig,grafo,visitados,lis);
			}
		}
	}
	
	//--------------------------------------------------------------------------------------------------
	//encargado de visitar a los vertices padres
	public static <T>List<T> bfs(Graph<T> grafo){
		boolean [] marca = new boolean[grafo.getSize()];
		List<T> listaRetorno = new LinkedList<>();
		for(int i = 0; i < marca.length;i++) {
			if(!marca[i]) {
				helperBFS(i,grafo,marca,listaRetorno);
			}
		}
		return listaRetorno;
	}
	//encargado de visitar a los vecinos
	private static <T>void helperBFS(int i,Graph<T>grafo,boolean [] marca, List<T> listaRetorno){
		marca[i] = true;
		Queue<Vertex<T>> queue = new Queue<Vertex<T>>();
		queue.enqueue(grafo.getVertex(i));
		while(!queue.isEmpty()) {
			Vertex<T> verticeActual = queue.dequeue();
			listaRetorno.add(verticeActual.getData());
			List<Edge<T>> adyActuales = grafo.getEdges(verticeActual); //me retorna los adyacentes del vertice pasado por parametro
			for (Edge<T> adyActual: adyActuales) {
				int posAdy = adyActual.getTarget().getPosition();
				if(!marca[posAdy]) {
					marca[posAdy] = true;
					queue.enqueue(adyActual.getTarget());	//enqueea al vertice adyacente
				}
			}
		}
	}
	
	//--------------------------------------------------------------------------------------------------
	
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
        for (String i: listaDFS) {
        	System.out.println("je: "+ i);
        }
        
        //BFS
        System.out.println("----------------------------------");
        List<String> listaBFS = bfs(ciudades);
        for (String i: listaBFS) {
        	System.out.println("ja: "+ i);
        }
	}
	
}

