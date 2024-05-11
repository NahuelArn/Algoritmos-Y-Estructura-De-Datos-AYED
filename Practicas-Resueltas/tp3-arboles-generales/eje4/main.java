package tp3_Practica.eje4;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class main {
	public static void main(String[] args) {
		// Crear el árbol de ejemplo
		GeneralTree<AreaEmpresa> a1 = new GeneralTree<>(new AreaEmpresa("A1", 21));
		GeneralTree<AreaEmpresa> a2 = new GeneralTree<>(new AreaEmpresa("A2", 22));
		GeneralTree<AreaEmpresa> a3 = new GeneralTree<>(new AreaEmpresa("A3", 23));

		List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<>();
		children1.add(a1);
		children1.add(a2);
		children1.add(a3);

		GeneralTree<AreaEmpresa> nodo1 = new GeneralTree<>(new AreaEmpresa("Nodo1", 13), children1);

		GeneralTree<AreaEmpresa> b1 = new GeneralTree<>(new AreaEmpresa("B1", 21));
		GeneralTree<AreaEmpresa> b2 = new GeneralTree<>(new AreaEmpresa("B2", 22));
		GeneralTree<AreaEmpresa> b3 = new GeneralTree<>(new AreaEmpresa("B3", 23));

		List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<>();
		children2.add(b1);
		children2.add(b2);
		children2.add(b3);

		GeneralTree<AreaEmpresa> nodo2 = new GeneralTree<>(new AreaEmpresa("Nodo2", 25), children2);

		GeneralTree<AreaEmpresa> c1 = new GeneralTree<>(new AreaEmpresa("C1", 21));
		GeneralTree<AreaEmpresa> c2 = new GeneralTree<>(new AreaEmpresa("C2", 22));
		GeneralTree<AreaEmpresa> c3 = new GeneralTree<>(new AreaEmpresa("C3", 23));

		List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<>();
		children3.add(c1);
		children3.add(c2);
		children3.add(c3);

		GeneralTree<AreaEmpresa> nodo3 = new GeneralTree<>(new AreaEmpresa("Nodo3", 10), children3);

		List<GeneralTree<AreaEmpresa>> hijosRaiz = new LinkedList<>();
		hijosRaiz.add(nodo1);
		hijosRaiz.add(nodo2);
		hijosRaiz.add(nodo3);

		GeneralTree<AreaEmpresa> arbol = new GeneralTree<>(new AreaEmpresa("Raiz", 14), hijosRaiz);

		// Crear el analizador de árbol
		AnalizadorArbol analizador = new AnalizadorArbol();

		// Calcular el máximo promedio
		double maximoPromedio = analizador.devolverMaximoPromedio(arbol);
		System.out.println("El máximo promedio es: " + maximoPromedio);
	}
}
