
# Práctica de Arboles Binarios

## 📌 Información General

- **Título:** Práctica de Arboles Binarios
- **Asignatura:** Estructura de Datos
- **Carrera:** Computación
- **Estudiante:** Pedro Pesántez
- **Fecha:** 6 de julio de 2025
- **Profesor:** Ing. Pablo Torres

---

## 🛠️ Descripción

Práctica de los 4 ejercicios de Arboles Binarios:
- Inserción de nodos
- Inversión de árboles
- Listado de niveles
- Cálculo de profundidad

Explicación de cada ejercicio:

### Ejercicio 1: Inserción de Nodos
Se implementa un método donde se insertan nodos enteros en un Árbol Binario de Búsqueda (BST). La función evalúa si debe ubicarse a la izquierda o derecha recursivamente.

```java
  public Node insert(Node node, int value) {
    if (node == null) {
        Node newNode = new Node(value);
        return newNode;
    }

    if (value < node.getValue()) {
        node.setLeft(insert(node.getLeft(), value));
    } else if (value > node.getValue()) {
        node.setRight(insert(node.getRight(), value));
    }

    return node;
  }
```

### Ejercicio 2: Inversión de Árboles
Se invierte el árbol binario recursivamente, intercambiando los nodos izquierdo y derecho en cada nivel.

```java
  public Node invertTree(Node root){
    if(root == null) {
        return null;
    }
    Node temp = root.getLeft();
    
    root.setLeft(invertTree(root.getRight()));
    root.setRight(invertTree(temp));

    return root;
  }
```

### Ejercicio 3: Listado de Niveles
El árbol binario se recorre por niveles usando listas enlazadas. Se almacena cada nivel como una sublista.

```java
  public List<List<Node>> listLevels(Node root){
    List<List<Node>> list = new ArrayList<>();
    LinkedList<Node> rootLista = new LinkedList<>();
    rootLista.add(root);

    while(!rootLista.isEmpty()){
        List<Node> level = new ArrayList<>();
        int size = rootLista.size();

        for(int i = 0; i < size; i++){
            Node currentNode = rootLista.poll();
            level.add(currentNode);

            if(currentNode.getLeft() != null){
                rootLista.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                rootLista.add(currentNode.getRight());
            }
        }
        list.add(level);
    }
    return list;
  }

```

### Ejercicio 4: Cálculo de Profundidad
Se calcula la profundidad máxima (longitud del camino más largo desde la raíz hasta una hoja).


```java
  public int maxDepth(Node node){
    if(node == null) return 0;
    int leftHeight = maxDepth(node.getLeft());
    int rightHeight = maxDepth(node.getRight());
    return Math.max(leftHeight, rightHeight) + 1;
  }

```

---

## 🚀 Ejecución

Para ejecutar el proyecto:

1. Asegúrate de tener tus datos en student.env

2. Compila el código:
    ```bash
    javac App.java
    ```
3. Ejecuta la aplicación:
    ```bash
    java App
    ```

---

## 🧑‍💻 Ejemplo de Salida

```plaintext
=============================
ESTRUCTURAS NO LINEALES - ÁRBOLES
=============================

Ejercicio 01: Insertar en un Árbol Binario de Búsqueda (BST)
Input: [5, 3, 7, 2, 4, 6, 8]
Output (In-Order): 2 3 4 5 6 7 8
-----------------------------

Ejercicio 02: Invertir un Árbol Binario
Input (In-Order): 1 2 3 4 6 7 9
Output (In-Order): 9 7 6 4 3 2 1
-----------------------------

Ejercicio 03: Listar Niveles en Listas Enlazadas
Input (In-Order): 1 2 3 4 6 7 9
Output (niveles):
4
2 -> 7
1 -> 3 -> 6 -> 9

-----------------------------

Ejercicio 04: Calcular la Profundidad Máxima
Input (In-Order): 8 1 2 3 4 7
Output: 4

=============================
```

---

Activación del actions