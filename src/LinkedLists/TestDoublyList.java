package LinkedLists;

public class TestDoublyList {
    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addNode(8);
        dList.addNode(6);
        dList.addNode(4);
        dList.addNode(2);
        dList.printList();
        dList.insertDateAtAnyPosition(10,4);
        System.out.println("After insertion");
        dList.printList();
    }
}
