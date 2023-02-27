package LinkedLists;

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
            System.out.println("Before :" +current.data);
            current = current.next;
            System.out.println("After :" +current.data);
        }
        Node replace = current.next;
        current.next = newNode;
        newNode.next = replace;
    }
    public void reverseList(){
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current!=null){
            next = current.next;
            System.out.println("Next "+next.data);
            current.next = prev;
//            System.out.println("CurrentNext "+current.next.data);
            prev = current;
            System.out.println("Previous "+ prev.data);
            current = next;
            System.out.println("Current "+current.data);
        }
    }
    //remove late element
    public void removeLast(){
        Node current = head;
        while (current.next==tail){
            current = current.next;
        }
        printList();
    }
    public boolean search(int x){
        Node current = head;
        boolean found = false;
        while (current!=null){
            if (current.data == x){
                return found = true;
            }
            current = current.next;
        }
        return found;
    }
    public int getCount(){
        Node current = head;
        int count = 0;
        while (current!=null){
            count++;
            current = current.next;
        }
        return count;
    }
}
