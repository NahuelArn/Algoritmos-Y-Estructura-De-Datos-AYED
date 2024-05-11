package tp3_Practica.eje10;
import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;


public class ParcialArboles {
	
	public static int helperParcialArboles(GeneralTree<Integer> a, List<Integer> filtrado, List<Integer> caminoActual,int deValorMaximo,int costoActual,int nivel){
		if(a.getData() == 1) {
			caminoActual.add(1) ;
			costoActual += 1* nivel;
		}
		if(a.isLeaf()) {
			if(costoActual > deValorMaximo) {
				deValorMaximo = costoActual;
				filtrado.clear();
				filtrado.addAll(caminoActual);
			}
		}else {
			List<GeneralTree<Integer>> childActual = a.getChildren();
			for (GeneralTree<Integer> i: childActual) {
				deValorMaximo = helperParcialArboles(i,filtrado,caminoActual,deValorMaximo,costoActual,nivel+1);
				
			}
		}
		if(a.getData() == 1) {
			caminoActual.remove(caminoActual.size()-1);
		}
		return deValorMaximo;
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
//		boolean estado = false;
		List<Integer> filtrado = new LinkedList<Integer>();
		if((arbol != null) && (!arbol.isEmpty())){
//			List<Integer> filtrado = new LinkedList<Integer>();
			List<Integer> caminoActual = new LinkedList<Integer>();
			int maximo = Integer.MIN_VALUE;
//			int nivelActual = 0;
			int costoActual = 0;
			helperParcialArboles(arbol,filtrado,caminoActual,maximo,costoActual,0);
//			if(helperParcialArboles(arbol,filtrado,caminoActual,maximo,costoActual,0)) { //el 0 representa al nivel 
//				estado = true;
//			}
		}
		return filtrado;
	}
}
