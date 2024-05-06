package tp3_Practica.eje6;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje5.GeneralTree;

public class main {
	public static void main(String[] args) {

		// Crear el árbol
		GeneralTree<Character> arbol = crearArbol();

		// Crear la red de agua potable con el árbol
		RedDeAguaPotable red = new RedDeAguaPotable(arbol);

		// Calcular el caudal mínimo
		double caudalMinimo = red.minimoCaudal(1000);
		System.out.println("El caudal mínimo es: " + caudalMinimo);

	}

	// Método para crear el árbol de prueba
	static GeneralTree<Character> crearArbol() {

		GeneralTree<Character> ab1 = new GeneralTree<Character>('B');

		List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
		subChildren1.add(new GeneralTree<Character>('L'));
		GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
		List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
		subChildren2.add(new GeneralTree<Character>('F'));
		subChildren2.add(subAb1);
		GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);

		List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
		subChildren3.add(new GeneralTree<Character>('M'));
		subChildren3.add(new GeneralTree<Character>('N'));
		GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
		List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
		subChildren4.add(new GeneralTree<Character>('H'));
		subChildren4.add(new GeneralTree<Character>('I'));
		subChildren4.add(subAb2);
		subChildren4.add(new GeneralTree<Character>('K'));
		subChildren4.add(new GeneralTree<Character>('P'));
		GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);

		GeneralTree<Character> ab4 = new GeneralTree<Character>('E');

		List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
		arbol.add(ab1);
		arbol.add(ab2);
		arbol.add(ab3);
		arbol.add(ab4);
		GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
		return ab;
//		// Crear los nodos del árbol
//		GeneralTree<Character> ab1 = new GeneralTree<Character>('B');
//		GeneralTree<Character> ab2 = new GeneralTree<Character>('C');
//		GeneralTree<Character> ab3 = new GeneralTree<Character>('D');
//		GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
//		
//		GeneralTree<Character> ab5 = new GeneralTree<Character>('F');
//		GeneralTree<Character> ab6 = new GeneralTree<Character>('G');
//		GeneralTree<Character> ab7 = new GeneralTree<Character>('H');
//		GeneralTree<Character> ab8 = new GeneralTree<Character>('I');
//		GeneralTree<Character> ab9 = new GeneralTree<Character>('J');
//		GeneralTree<Character> ab10 = new GeneralTree<Character>('K');
//		GeneralTree<Character> ab11 = new GeneralTree<Character>('L');
//		GeneralTree<Character> ab12 = new GeneralTree<Character>('M');
//		GeneralTree<Character> ab13 = new GeneralTree<Character>('N');
//		GeneralTree<Character> ab14 = new GeneralTree<Character>('P');
//
//		// Construir la jerarquía del árbol
//		ab1.addChild(ab11);
//		ab2.addChild(ab5);
//		ab2.addChild(ab6);
//		ab3.addChild(ab7);
//		ab3.addChild(ab8);
//		ab3.addChild(ab9);
//		ab3.addChild(ab10);
//		ab3.addChild(ab14);
//		ab6.addChild(ab12);
//		ab6.addChild(ab13);
//
//		// Crear una lista de árboles para el árbol principal
//		List<GeneralTree<Character>> arbol = new LinkedList<>();
//		arbol.add(ab1);
//		arbol.add(ab2);
//		arbol.add(ab3);
//		arbol.add(ab4);
//
//		// Construir el árbol principal
//		GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
//
//		return ab;
	}

}
