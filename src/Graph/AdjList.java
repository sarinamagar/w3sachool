package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AdjList {
    int vertices;
    SinglyLinkedList[] list;

    AdjList(int vertices){
        this.vertices = vertices;
        list = new SinglyLinkedList[vertices];
        for (int i=0; i<vertices; i++){
           list[i] = new SinglyLinkedList();
        }
    }
    public void addEdge(int source, int destination){
        list[source].addNode(destination);
        list[destination].addNode(source);
    }
    public void printGraph(){
        for (int i = 0; i<vertices; i++){
            System.out.print(i + " is connected to ");
            SinglyLinkedList.Node current = list[i].head;
            while (current!=null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    List<Integer> getAdjNode(int v){
       ArrayList<Integer> adjList = new ArrayList<>();
        SinglyLinkedList.Node current = list[v].head;
        while (current!=null){
            adjList.add(current.data);
            current = current.next;
        }
        return  adjList;
    }

    public static void main(String[] args) {
        AdjList adj = new AdjList(6);
        adj.addEdge(0,1);
        adj.addEdge(0,2);
        adj.addEdge(0,3);
        adj.addEdge(0,4);
        adj.addEdge(0,5);
        adj.addEdge(1,2);
        adj.addEdge(2,4);
        adj.printGraph();
        System.out.println(   adj.getAdjNode(0));

    }
}
