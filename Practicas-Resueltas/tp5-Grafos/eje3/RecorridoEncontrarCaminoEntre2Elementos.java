package Grafos.tp.eje3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Grafos.tp.eje1.Edge;
import Grafos.tp.eje1.Graph;
import Grafos.tp.eje1.Vertex;
import Grafos.tp.eje1.adjList.AdjListGraph;

public class RecorridoEncontrarCaminoEntre2Elementos {
Graph<String> mapaCiudades;
	
	public RecorridoEncontrarCaminoEntre2Elementos(Graph<String> g) {
		this.mapaCiudades = g;
	}
	
	/*Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
 	pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).*/
	public <T> List<String> devolverCamino(String ciudad1, String ciudad2) {
		List<String> camino = null;
		if((mapaCiudades != null) && (!mapaCiudades.isEmpty())) {
			camino = new LinkedList<>();
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen != null && destino != null) {
				dfsHelper(origen,destino, new boolean [mapaCiudades.getSize()],camino);
			}
		}
		return camino;
	}
	
	private boolean dfsHelper(Vertex<String> origen, Vertex<String> destino, boolean []visitados,List<String>camino) {
		visitados[origen.getPosition()] = true;	//marco vertice actual como visitado
		boolean sigo = true;	
		camino.add(origen.getData());	//me guardo el vertice actual
		if(origen.equals(destino)) {	//si el origen es igual al destino encontre el final
			return false;
		}else {
			List<Edge<String>> adyActuales = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterator = adyActuales.iterator();	//convierto a los adyacentes en un iterable
			while(iterator.hasNext() && sigo) {
				Vertex<String> vActual = iterator.next().getTarget();
				if(!visitados[vActual.getPosition()]) {
					sigo = dfsHelper(vActual,destino,visitados,camino);
				}
			}
		}
		if(sigo) {
			camino.remove(camino.size()-1);
		}
		return sigo;
	}
	public static void main(String[] args) {
		Graph<String> garfio = new AdjListGraph<>();	//se crea primero la lista donde van a ir los vertices
		Vertex<String> v1 = garfio.createVertex("La Plata");
		Vertex<String> v2 = garfio.createVertex("Bernal");
		Vertex<String> v3 = garfio.createVertex("Lanus");
		Vertex<String> v4 = garfio.createVertex("Platanos");
		Vertex<String> v5 = garfio.createVertex("Villa Elisa");
		Vertex<String> v6 = garfio.createVertex("Hudson");
		Vertex<String> v7 = garfio.createVertex("Argentina");
		
		garfio.connect(v1, v2, 4);
		garfio.connect(v2, v1, 4);
		garfio.connect(v1, v3, 3);
		garfio.connect(v3, v1, 3);
		garfio.connect(v1, v4, 4);
		garfio.connect(v4, v1, 4);
		garfio.connect(v2, v5, 15);
		garfio.connect(v5, v2, 15);
		garfio.connect(v3, v5, 3);
		garfio.connect(v5, v3, 3);
		garfio.connect(v4, v3, 4);
		garfio.connect(v3, v4, 4);
		garfio.connect(v4, v5, 11);
		garfio.connect(v5, v4, 11);
		garfio.connect(v4, v6, 10);
		garfio.connect(v6, v4, 10);
		garfio.connect(v4, v3, 4);
		garfio.connect(v3, v4, 4);
        garfio.connect(v5, v7, 4);
        garfio.connect(v7, v5, 4);
        garfio.connect(v6, v7, 9);
        garfio.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(garfio);
        
        System.out.println(mapa.devolverCamino("La Plata", "Argentina"));
	}
}
