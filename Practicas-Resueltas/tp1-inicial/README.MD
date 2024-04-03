<h1 align="center">Estructuras</h1>

<h1 align="center"> Listardas </h1>

```java
   
  import java.util.ArrayList;
  import java.util.LinkedList;
  // Declaración
  ArrayList<tipo> arrayDinamico = new ArrayList<tipo>();  //i
  ArrayList<tipo> arrayDinamico = new ArrayList<tipo>(tamaño);
  ArrayList<tipo> arrayDinamico = new ArrayList<tipo>(Arrays.asList(valor1, valor2, valor3, ...));
  LinkedList<Integer> listaDinamica = new LinkedList<>(); //nodos
  LinkedList<Integer> listaDinamica = new LinkedList<>();
  // Acceso
  arrayDinamico.get(posición);
  // Añadir
  arrayDinamico.add(elemento);




```



<h1 align="center"> Queue/Cola </h1>

```java

      import java.util.ArrayList;
      import java.util.List;

      public class Queue<T> extends Sequence { //
      List<T> data;

      public Queue() {
        this.data = new ArrayList<T>();
      }

      public void enqueue(T dato) { // para agregar
        data.add(dato);
      }

      public T dequeue() { // para quitar
        if (!data.isEmpty()) {
          return data.remove(0);
        } else {
          throw new IllegalStateException("La cola está vacía"); // manejo del error
        }
      }

      public T head() { // devuelve el tope
        if (!data.isEmpty()) {
          return data.get(0);
        } else {
          throw new IllegalStateException("La cola está vacía");
        }
      }

      @Override
      public int size() {
        return data.size();
      }

      @Override
      public boolean isEmpty() {
        return data.size() == 0;
      }

      @Override
      public String toString() {
        String str = "[ ";
        if (!data.isEmpty()) {
          for (T d : data) {
            str += d + ", ";
          }
          str = str.substring(0, str.length() - 2) + " ]"; // Esto quita el ,]
        } else {
          str = "error flaquito, soh boludo voh? intentas imprimir una QueuEh vacia";
        }
        return str;
      }
    }


```