package Graph;

public class SinglyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    int size = 0;
    Node head = null;
    Node tail = null;
    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            //O(n)
//            Node current = head;
//            while (current.next != null){
//                current = current.next;
//            }
//            current.next = newNode;

            //O(1)
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void printList(){
        Node current = head;
        while (current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public int getDataAtAnyPosition(int position){
        Node current = head;
        for (int i = 2; i<=position; i++){
            current = current.next;
        }
        return current.data;
    }
    public void removeNode(int position){

        if (position == 1){
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        else {
            Node current = head;
            for (int i = 2; i < position; i++) {
                current = current.next;
            }
            Node nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = null;
        }
        size--;
    }
    public void addHeadFirst(int data){
        Node newHeadNode = new Node(data);
        Node temp = head;
        head = newHeadNode;
        head.next =temp;
    }
    public void insertAtAnyPosition(int position, int data){
        Node newNode = new Node(data);
        Node current = head;
        for(int i=2; i<position; i++){
            current = current.next;
        }
        Node replace = current.next;
        current.next = newNode;
        newNode.next = replace;
    }
    public void reverseList(){
        Node current = tail;
        Node previous = null;
        System.out.println(head.data);
        System.out.println(tail.data);
        for (int i=size; i>0; i--) {

        }
    }
    //remove late element
    public void removeLast(){
        Node current = head;
        while (current.next==tail){
            current = current.next;
        }
    }
}
