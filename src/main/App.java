package main;

import utils.StudentValidator;

import java.util.List;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        System.out.println("\n=============================");
        System.out.println("ESTRUCTURAS NO LINEALES - ÁRBOLES");
        System.out.println("=============================\n");

        // EJERCICIO 01
        System.out.println("Ejercicio 01: Insertar en un Árbol Binario de Búsqueda (BST)");
        int[] valoresEj1 = {5, 3, 7, 2, 4, 6, 8};
        InsertBST insertador = new InsertBST();
        Node raizEj1 = null;
        for (int v : valoresEj1) {
            raizEj1 = insertador.insert(raizEj1, v);
        }
        System.out.println("Input: [5, 3, 7, 2, 4, 6, 8]");
        System.out.print("Output (In-Order): ");
        printInOrder(raizEj1);
        System.out.println("\n-----------------------------\n");

        // EJERCICIO 02
        System.out.println("Ejercicio 02: Invertir un Árbol Binario");
        Node rootEj2 = new Node(4);
        rootEj2.setLeft(new Node(2));
        rootEj2.setRight(new Node(7));
        rootEj2.getLeft().setLeft(new Node(1));
        rootEj2.getLeft().setRight(new Node(3));
        rootEj2.getRight().setLeft(new Node(6));
        rootEj2.getRight().setRight(new Node(9));
        System.out.print("Input (In-Order): ");
        printInOrder(rootEj2);
        InvertBinaryTree inverter = new InvertBinaryTree();
        Node invertido = inverter.invertTree(rootEj2);
        System.out.print("\nOutput (In-Order): ");
        printInOrder(invertido);
        System.out.println("\n-----------------------------\n");

        // EJERCICIO 03
        System.out.println("Ejercicio 03: Listar Niveles en Listas Enlazadas");
        Node rootEj3 = new Node(4);
        rootEj3.setLeft(new Node(2));
        rootEj3.setRight(new Node(7));
        rootEj3.getLeft().setLeft(new Node(1));
        rootEj3.getLeft().setRight(new Node(3));
        rootEj3.getRight().setLeft(new Node(6));
        rootEj3.getRight().setRight(new Node(9));
        System.out.print("Input (In-Order): ");
        printInOrder(rootEj3);
        System.out.println("\nOutput (niveles):");
        ListLevels listador = new ListLevels();
        List<List<Node>> niveles = listador.listLevels(rootEj3);
        for (List<Node> nivel : niveles) {
            for (int i = 0; i < nivel.size(); i++) {
                System.out.print(nivel.get(i).getValue());
                if (i < nivel.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
        System.out.println("\n-----------------------------\n");

        // EJERCICIO 04
        System.out.println("Ejercicio 04: Calcular la Profundidad Máxima");
        Node rootEj4 = new Node(4);
        rootEj4.setLeft(new Node(2));
        rootEj4.setRight(new Node(7));
        rootEj4.getLeft().setLeft(new Node(1));
        rootEj4.getLeft().setRight(new Node(3));
        rootEj4.getLeft().getLeft().setLeft(new Node(8));
        System.out.print("Input (In-Order): ");
        printInOrder(rootEj4);
        Depth depth = new Depth();
        int profundidadMaxima = depth.maxDepth(rootEj4);
        System.out.println("\nOutput: " + profundidadMaxima);
        System.out.println("\n=============================\n");
    }

    public static void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        printInOrder(root.getRight());
    }
}
