package LinkedLists;

import java.util.LinkedList;

public class DoublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head = null;
    Node tail = null;

    public void addNode(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = head;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    //print function is same as sinly linked list
    public void printList(){
        Node current = head;
        while (current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void insertDateAtAnyPosition(int data, int position){
        Node newNode = new Node(data);
        if(position == 0){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        else {
            Node current = head;
            for (int i=1; i<position; i++){
                current = current.next;
            }
            Node temp = current.next;
            if(temp != null){
                current.next = newNode;
                newNode.prev = current;
                temp.prev = newNode;
                newNode.next = temp;
            }
            else {
                current.next = newNode;
                newNode.prev = current;
            }
        }
    }
    public void removeDataAtAnyPosition(int position){
        if(position == 0){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        else {
            Node current = head;
            for (int i=0; i<=position; i++){
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = current.prev = null;
        }
    }
    //merge 2 sorted linked list in sorted order
    //merge kth linked list into sorted linked list


}
