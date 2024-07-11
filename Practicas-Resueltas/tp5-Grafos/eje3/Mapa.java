package Grafos.tp.eje3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Grafos.tp.eje1.Edge;
import Grafos.tp.eje1.Graph;
import Grafos.tp.eje1.Vertex;
import Grafos.tp.eje1.adjList.AdjListGraph;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> g) {
		this.mapaCiudades = g;
	}
	
	//-----------------------------------------------1-----------------------------------------------------------
	
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
	
	//--------------------------------------------2--------------------------------------------------------
	//es como el de la princesa, hay varios dragones en una lista
	/*
	 devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
	 Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
	 que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
	 vacía. (Sin tener en cuenta el combustible).
	*/
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudadesConDragones) {
		List<String> camino = null;
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen != null && destino != null) {
				camino = new LinkedList<>();
				dfsHelper2(origen,destino,new boolean[mapaCiudades.getSize()],camino,ciudadesConDragones);
			}
		}
		return camino;
	}
	
	private boolean dfsHelper2(Vertex<String> origen, Vertex<String> destino, boolean visitados[],List<String> camino,List<String> ciudadesConDragones) {
		visitados[origen.getPosition()] = true;	//marco los visitados
		boolean sigo = true;
		if(!ciudadesConDragones.contains(origen.getData())) {	//si el vertice actual, esta con dragones, no lo proceso.. me va activar el backtracking si estoy en una recursion DFS
			camino.add(origen.getData());
			if(origen.getData().equals(destino.getData())) {
				sigo = false;
			}else {
				List<Edge<String>> adyActuales = mapaCiudades.getEdges(origen);
				Iterator<Edge<String>> iterator = adyActuales.iterator();
				while(iterator.hasNext() && sigo) {
					Vertex<String> vActual = iterator.next().getTarget();
					if(!visitados[vActual.getPosition()]) {
						sigo = dfsHelper2(vActual,destino,visitados,camino,ciudadesConDragones);
					}
				}
			}
			//si sigo es porque termine de procesar los adyacentes del padre actual
			if(sigo) {
				camino.remove(camino.size()-1);
			}
		}
		return sigo;
	}
	//---------------------------------------------3-------------------------------------------------------
	/*caminoMasCorto(String ciudad1, String ciudad2): List<String>
 	Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
 	existe camino retorna la lista vacía. (Las rutas poseen la distancia).
	 */
	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		List<String> camino = null;
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			camino = new LinkedList<>();
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen != null && destino != null) {
				helperDFS3(origen,destino, new LinkedList<String>(),camino,0,Integer.MAX_VALUE, new boolean[mapaCiudades.getSize()]);
			}
		}
		return camino;
	}
	
	private int helperDFS3(Vertex<String> origen, Vertex<String> destino, List<String> caminoMin,List<String> caminoActual,int distanciaActual,int distanciaMin,boolean[] visitados) {
		visitados[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		if(origen.getData().equals(destino.getData())) {
			if(distanciaActual < distanciaMin) {
				caminoMin.clear();
				caminoMin.addAll(caminoActual);
				distanciaMin = distanciaActual;
			}
		}else {
			List<Edge<String>> adyActual = mapaCiudades.getEdges(origen);
			for (Edge<String> i : adyActual) {
				distanciaActual += i.getWeight();
				if(!visitados[i.getTarget().getPosition()]) {
					helperDFS3(origen,destino,caminoMin,caminoActual,distanciaActual,distanciaMin,visitados);
				}
			}
		}
		caminoActual.remove(caminoActual.size()-1);
		visitados[origen.getPosition()] = false; //desmarco el camino para que pueda probar esa combinacion tambien
		return distanciaActual;
	}
	
	//-------------------------------------------------4-----------------------------------------------------------
	/*
	 * caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
	   Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
	   quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
	 */
	private List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> caminoActual = new LinkedList<>();
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen != null && destino != null && tanqueAuto > 0) { //si el tanque es 0 es al pedo recorrer 
				helperDFS4(origen,destino,caminoActual,tanqueAuto, new boolean[mapaCiudades.getSize()],0);
			}
		}
		return caminoActual;
	}
	public boolean helperDFS4(Vertex<String> origen,Vertex<String> destino,List<String> caminoActual,int tanqueAuto,boolean [] visitados,int consumoActualGas ) {
		visitados[origen.getPosition()] = true;
		boolean sigo = true;
		caminoActual.add(origen.getData());
		if(origen.getData().equals(destino.getData())) {
			return false;
		}else {
			List<Edge<String>> adyActual = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterator = adyActual.iterator();
			while(iterator.hasNext() && sigo && consumoActualGas <= tanqueAuto) {
				Vertex<String> vActual = iterator.next().getTarget();
				int pesoArista = iterator.next().getWeight();
				if(!visitados[vActual.getPosition()] && (consumoActualGas+pesoArista) <= tanqueAuto) {
					sigo = helperDFS4(origen,destino,caminoActual,tanqueAuto,visitados,consumoActualGas+pesoArista);
				}
			}
		}
		if(sigo) {
			caminoActual.remove(caminoActual.size()-1);
		}
		visitados[origen.getPosition()] = false;;
		return sigo;
	}
	
	//-------------------------------------------------5-----------------------------------------------------------
	/*caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
	 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
	 que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
	 medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
	 retorna la lista vacía.
	*/
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> caminoMinimo = new LinkedList<String>();
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {	//no hace falta preungar si tanqueAut >0 ya que se va a cargar en cada ciudad
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!= null && destino != null) {
				helperDFS5(origen,destino, new boolean[mapaCiudades.getSize()],caminoMinimo,new LinkedList<String>(),tanqueAuto,0, Integer.MAX_VALUE);
			}
		}
		return caminoMinimo;
	}
	private int helperDFS5(Vertex<String> origen, Vertex<String> destino, boolean[] visitados,List<String> caminoMinimo,List<String> caminoActual,int tanqueAuto, int cantRecargas,Integer minCargas) {
		visitados[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		if(origen.getData().equals(destino.getData()) && cantRecargas < minCargas){
			caminoMinimo.clear();
			caminoMinimo.addAll(caminoActual);
			minCargas = cantRecargas;
		}
		else {
			List<Edge<String>> adyActuales = mapaCiudades.getEdges(origen);
			for(Edge<String> adyActual: adyActuales) {
				int costoCombustibleArista = adyActual.getWeight();
				if(!visitados[adyActual.getTarget().getPosition()]) {
					if( tanqueAuto <= (tanqueAuto - costoCombustibleArista)){
						cantRecargas += 1;
						tanqueAuto = costoCombustibleArista;
					}
					minCargas = helperDFS5(origen,destino,visitados,caminoMinimo,caminoActual,tanqueAuto,cantRecargas,minCargas);
				}
			}
		}
		visitados[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		return minCargas;
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
        
        //------------------------
        System.out.println("Inciso 2: ");
        List<String> localidadesRestringidas = new LinkedList<>();
        localidadesRestringidas.add("Berisso");
        //deberia devolverme lo mismo que el inciso 1, Berisso no pertenece
        System.out.println(mapa.devolverCaminoExceptuando("La Plata", "Argentina", localidadesRestringidas));
	}
}
