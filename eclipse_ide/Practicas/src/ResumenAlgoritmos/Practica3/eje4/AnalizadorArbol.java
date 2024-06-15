package ResumenAlgoritmos.Practica3.eje4;

import tp3_Practica.eje1.GeneralTree;
import tp3_Practica.eje2.Queue;

public class AnalizadorArbol {

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> a) {
		double maxProm = Double.MIN_VALUE; // Inicializamos con el menor valor posible para buscar el maximo

		if (!a.isEmpty()) {
			Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
			queue.enqueue(a); // Pusheo del primer nivel
			queue.enqueue(null); // Marca el final del primer nivel

			double suma = 0;
			int cantNodos = 0;

			while (!queue.isEmpty()) {
				GeneralTree<AreaEmpresa> padreActual = queue.dequeue();
				if (padreActual != null) {
					cantNodos++;
					suma += padreActual.getData().getDelay();
					for (GeneralTree<AreaEmpresa> child : padreActual.getChildren()) {
						queue.enqueue(child);
					}
				} else { // Cuando llegamos a un nivel nuevo
					if (cantNodos > 0) { // Aseguramos que no dividimos por cero
						double promedio = suma / cantNodos;
						maxProm = Math.max(maxProm, promedio);
					}
					// Resetear variables para el siguiente nivel
					suma = 0;
					cantNodos = 0;
					if (!queue.isEmpty()) {
						queue.enqueue(null); // Añadimos el marcador de final de nivel
					}
				}
			}
		}
		return maxProm;
	}

	public static void main(String[] args) {
		// Crear instancias de AreaEmpresa
		AreaEmpresa rootArea = new AreaEmpresa("Root", 14);
		AreaEmpresa child1 = new AreaEmpresa("Child1", 16);
		AreaEmpresa child2 = new AreaEmpresa("Child2", 16);
		AreaEmpresa grandChild1 = new AreaEmpresa("GrandChild1", 10);
		AreaEmpresa grandChild2 = new AreaEmpresa("GrandChild2", 10);

		// Crear el árbol general
		GeneralTree<AreaEmpresa> root = new GeneralTree<>(rootArea);
		GeneralTree<AreaEmpresa> node1 = new GeneralTree<>(child1);
		GeneralTree<AreaEmpresa> node2 = new GeneralTree<>(child2);
		GeneralTree<AreaEmpresa> node3 = new GeneralTree<>(grandChild1);
		GeneralTree<AreaEmpresa> node4 = new GeneralTree<>(grandChild2);

		// Construir el árbol
		root.addChild(node1);
		root.addChild(node2);
		node1.addChild(node3);
		node1.addChild(node4);

		// Crear una instancia de AnalizadorArbol
		AnalizadorArbol analizador = new AnalizadorArbol();

		// Calcular y mostrar el máximo promedio
		double maxPromedio = analizador.devolverMaximoPromedio(root);
		System.out.println("El máximo promedio de los niveles es: " + maxPromedio);
	}
}
