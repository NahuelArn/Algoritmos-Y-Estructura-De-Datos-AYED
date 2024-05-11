package tp3_Practica.eje10;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class main {
	public static void main(String[] args) {
		//derecha
		List<GeneralTree<Integer>> listaAbajo = new LinkedList<GeneralTree<Integer>>();
		listaAbajo.add(new GeneralTree<Integer>(0));
		listaAbajo.add(new GeneralTree<Integer>(0));
		GeneralTree<Integer> a = new GeneralTree<Integer>(0,listaAbajo);
		
		listaAbajo = new LinkedList<GeneralTree<Integer>>();
		listaAbajo.add(a);
		
		a = new GeneralTree<Integer>(0,listaAbajo);
		
		listaAbajo = new LinkedList<GeneralTree<Integer>>();
		listaAbajo.add(a);
		
		a = new GeneralTree<Integer>(1,listaAbajo);
		
		//medio
		List<GeneralTree<Integer>> listaMedio = new LinkedList<GeneralTree<Integer>>();
		listaMedio.add(new GeneralTree<Integer>(1));
		
		GeneralTree<Integer> padreMedio = new GeneralTree<Integer>(0,listaMedio);
		
		listaMedio = new LinkedList<GeneralTree<Integer>>();
		listaMedio.add(padreMedio);
		
		padreMedio = new GeneralTree<Integer>(0,listaMedio);
		
		listaMedio = new LinkedList<GeneralTree<Integer>>();
		listaMedio.add(new GeneralTree<Integer>(1));
		listaMedio.add(padreMedio);
		
		padreMedio = new GeneralTree<Integer>(1,listaMedio);
		
		
		//izquierda
		List<GeneralTree<Integer>> listaIzquierda = new LinkedList<GeneralTree<Integer>>();
		listaIzquierda.add(new GeneralTree<Integer>(1));
		listaIzquierda.add(new GeneralTree<Integer>(1));
		listaIzquierda.add(new GeneralTree<Integer>(1));
		
		GeneralTree<Integer> padreIzquierdo = new GeneralTree<Integer>(1,listaIzquierda);
		
		listaIzquierda = new LinkedList<GeneralTree<Integer>>();
		listaIzquierda.add(padreIzquierdo);
		listaIzquierda.add(new GeneralTree<Integer>(1));
		
		padreIzquierdo = new GeneralTree<Integer>(0,listaIzquierda);
		
		List<GeneralTree<Integer>> listarda = new LinkedList<GeneralTree<Integer>>();
		listarda.add(a);
		listarda.add(padreMedio);
		listarda.add(padreIzquierdo);
		
		GeneralTree<Integer> casa = new GeneralTree<Integer>(1,listarda);

		List<Integer> retorno = ParcialArboles.resolver(casa);
		
		for(Integer i: retorno) {
			System.out.println("jeje: "+i);
		}
	}
}
