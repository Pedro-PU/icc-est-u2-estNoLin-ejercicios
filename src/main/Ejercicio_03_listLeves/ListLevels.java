package main.Ejercicio_03_listLeves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import main.Materia.Models.Node;

public class ListLevels {
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
}
