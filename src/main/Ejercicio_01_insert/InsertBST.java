package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBST {
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
}