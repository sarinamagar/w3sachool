package caching;

import java.util.HashMap;

public class LRU {
    public static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }
    int capacity;
    HashMap<Integer, Node> map;
    LRU(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            //remove existing node
            remove(map.get(key));
        } else if (map.size()==capacity) {
            //remove tail
            remove(tail);
        }
        else {
            Node newNode = new Node(key, value);
            insert(newNode);
        }
    }
    Node head = null;
    Node tail = null;
    void insert(Node newNode){
        map.put(newNode.key, newNode);
        if(head == null){
            head = tail = newNode;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    public int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        else {
            remove(node);
            insert(node);
            return node.value;
        }
    }
    public void remove(Node node){
        map.remove(node.key);
        if (node==head && head==tail){
            head=tail=null;
        } else if (node==head) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        } else if (node==tail) {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }
    }
}

