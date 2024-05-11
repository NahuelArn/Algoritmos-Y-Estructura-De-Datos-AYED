<h1 align ="center"> Arboles Binarios</h1>

<h2 align = "center"> Estructura de arbol</h2>

```Java

    public class BinaryTree<T> {
      private T data;
      private BinaryTree<T> leftChild;
      private BinaryTree<T> rightChild;

      public BinaryTree() {
        super();// no es necesario usar Super, se puede hacer un constructor vacio
      }

      public BinaryTree(T data) {
        this.data = data;
      }

      public T getData() {
        return data;
      }

      /** @Param setea un valor en el nodo **/
      public void setData(T data) {
        this.data = data;
      }

      /**
       * Preguntar antes de invocar si hasLeftChild()
       *
       * @return
       */
      public BinaryTree<T> getLeftChild() {
        return leftChild;
      }

      /**
       * Preguntar antes de invocar si hasRightChild()
       *
       * @return
       */
      public BinaryTree<T> getRightChild() {
        return this.rightChild;
      }

      public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
      }

      public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
      }

      public void removeLeftChild() {
        this.leftChild = null;
      }

      public void removeRightChild() {
        this.rightChild = null;
      }

      public boolean isEmpty() { // si no tiene hijos ni tiene dato en el padre
        return (this.isLeaf() && this.getData() == null);
      }

      /** @return retorna true, si es hoja el nodo actul **/
      public boolean isLeaf() { // es hoja
        return (!this.hasLeftChild() && !this.hasRightChild());

      }

      /**
       * Retorna true, si tiene un hijo izquierdo
       *
       * @return
       */
      public boolean hasLeftChild() {
        return this.leftChild != null;
      }

      /**
       * Retorna true, si tiene un hijo derecho
       *
       * @return
       */
      public boolean hasRightChild() {
        return this.rightChild != null;
      }

      @Override
      public String toString() {
        return this.getData().toString();
      }

      public void inOrder() {
        if (this.getData() != null) {
          if (this.hasLeftChild()) {
            this.getLeftChild().inOrder();
          }
          System.out.println("valor: " + this.getData());
          if (this.hasRightChild()) {
            this.getRightChild().inOrder();
          }
        }
      }

      public int contarHojas() {
        int suma = 0;
        if (this.getData() == null) { // si no es un arbol nulo
          return 0;
        } else {
          if (this.isLeaf()) { // si es hoja
            return 1;
          } else {
            if (this.hasLeftChild()) {
              suma += this.getLeftChild().contarHojas();
            }
            if (this.hasRightChild()) {
              suma += this.getRightChild().contarHojas();
            }
          }
        }
        return suma;
      }

      public BinaryTree<T> espejardo() {
      BinaryTree<T> e = new BinaryTree<>(this.getData());
      if (this.getData() != null) {
        if (this.hasLeftChild()) {
          e.addRightChild(this.getLeftChild().espejardo());
        }
        if (this.hasRightChild()) {
          e.addLeftChild(this.getRightChild().espejardo());
        }

        }
        return e;
      }

      public void entreNiveles(int izquierda, int derecha) {
        String s;
        if (this.isEmpty() || !(izquierda >= 0) || !(izquierda < derecha)) {
          System.out.println("Vacio o rangos no validos");
        } else {
            Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
            queue.enqueue(this);
            int nivelActual = 0;

            while (!queue.isEmpty()) {
              int dimFQueue = queue.size(); // uso el tamanho de la Queue para obtener el nivel
              // System.out.println("tamanho queuae: " + dimFQueue);
              s = " ";
              if (nivelActual >= izquierda && nivelActual <= derecha) {
                for (int i = 0; i < dimFQueue; i++) { // proceso todos los nodos del nivel actual
                  BinaryTree<T> nodoActual = queue.dequeue();
                  // System.out.println("Nodo actual" + nodo.getData() + " | "); //imprime el nodo actual
                  s += nodoActual.getData() + " | ";
                  if (nodoActual.hasLeftChild()) { // Agrega los hijos a la Queue
                    queue.enqueue(nodoActual.getLeftChild());
                  }
                  if (nodoActual.hasRightChild()) {
                    queue.enqueue(nodoActual.getRightChild());
                  }
                }
              } else {
                for (int i = 0; i < nivelActual; i++) { // se encarga de descartar los los nodos de los niveles que no entan en el rango
                  queue.dequeue();
                }
              }
              System.out.println("nivel actual: " + nivelActual + " Valores en este nivel: " + s);
              nivelActual++;
            }
          }
      }
    }

```

<h2 align = "center"> Tipos de recorridos</h2>

```Java

  Recorrido por profundidad (DFS - Depth-First Search)

```

```Java

  Recorrido por niveles (BFS - Breadth-First Search):


```
