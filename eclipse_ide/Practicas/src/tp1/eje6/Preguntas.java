package tp1.eje6;

public class Preguntas {
	/*
	 * A: ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?
	 * ArraList ofrece un mejor rendimiento cuando necesitamos usar un acceso
	 * directo, si se necesita almacenar varios datos primitivos, es mas eficiente
	 * usar arraylist ya q quedan almacenados en mem primaria, en cambio en
	 * arraylist los convierte en objetos y esto causa mas consumo de memoria, mayor
	 * tiempo de acceso al dato
	 * 
	 * 
	 * B: ¿Cuándo LinkedList puede ser más eficiente que ArrayList? Puede ser mas
	 * eficiente en temas de inserccion o eliminacion, ya que no tenes q hacer
	 * varios corrimientos, en cambio en la linkedlist al ser nodos que referencian
	 * a otros nodos, el enganche de la referencia al siguiente se puede hacer sin
	 * hacer todos los corrimientos
	 * 
	 * C: ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y
	 * LinkedList? Arraylist si no se piensa en hacer corrimientos o eliminacion de
	 * elementos podria ser mas eficiente, ya que cada campo "del vector dinamico"
	 * solo tiene su dato, en cambio con linkedList, cada campo tiene su dato y una
	 * referencia al siguiente, cada dato que se almacena lo envuelve en un objeto,
	 * pero a la hora de eliminar/insertar es mas eficiente en cuanto tiempo de
	 * ejecucion
	 * 
	 * D: ¿En qué casos sería preferible usar un ArrayList o un LinkedList? La
	 * elección entre ArrayList y LinkedList depende de factores como el tipo de
	 * operaciones que se planea realizar con la lista, la eficiencia del espacio de
	 * memoria y las características específicas la aplicación. Es importante
	 * evaluar estas consideraciones para determinar cuál es la estructura de datos
	 * más adecuada para tu caso de uso particular.
	 * 
	 */
}
