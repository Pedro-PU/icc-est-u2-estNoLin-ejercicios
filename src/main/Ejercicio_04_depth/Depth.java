package main.Ejercicio_04_depth;
import main.Materia.Models.Node;
public class Depth {
    public int maxDepth(Node node){
        if(node==null) return 0;
        int leftHeight = maxDepth(node.getLeft());
        int rightHeight = maxDepth(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;        
    }
}
