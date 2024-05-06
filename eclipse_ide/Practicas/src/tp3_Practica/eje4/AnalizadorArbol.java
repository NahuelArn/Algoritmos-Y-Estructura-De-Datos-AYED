package tp3_Practica.eje4;

import java.util.List;

import tp3_Practica.eje1.GeneralTree;
import tp3_Practica.eje2.Queue;

public class AnalizadorArbol /* <T> */ {
//	private GeneralTree<T> arbolGeneral;

//	public AnalizadorArbol() {
//
//	}
//
//	public AnalizadorArbol(GeneralTree<T> a) {
//		this.arbolGeneral = a;
//	}

	private double promedio(int suma, int cant) {
		return suma / cant;
	}

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		double promedioActual, promedioMax = 0;
		if (arbol != null && !arbol.isEmpty()) {
			Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
			queue.enqueue(arbol);

			while (!queue.isEmpty()) {
				int dimF = queue.size();
				int suma = 0;
				for (int i = 0; i < dimF; i++) { // vuelvo aca para cargar los hijos q me faltan en la queue
					GeneralTree<AreaEmpresa> arbolActual = queue.dequeue();
					suma += arbolActual.getData().getTardanza();
					if (arbolActual.hasChildren()) {
						List<GeneralTree<AreaEmpresa>> childActual = arbolActual.getChildren();
						for (GeneralTree<AreaEmpresa> o : childActual) {
							queue.enqueue(o);
						}
					}
				}
				promedioActual = promedio(suma, dimF);
				if (promedioActual > promedioMax) {
					promedioMax = promedioActual;
				}
			}
		}
		return promedioMax;
	}
}
