package LinkedLists;

//implement stack using linkedlist
public class Stacks{
    int capacity;
    Stacks(int capacity){
        this.capacity = capacity;
    }
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

        public void push(int data){
            if(size==capacity){
                System.out.println("stack overflow");
                return;
            }
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }
        public int pop(){
            if(head == tail){
                Node temp = head;
                head =tail= null;
                return temp.data;
            }
            Node current = head;
            while (current.next!=tail){
                current = current.next;
            }
            current.next = null;
            Node temp = tail;
            tail = current;
            return temp.data;
        }
}
