package LinkedLists;

public class TestSinglyList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addNode(10);
        list.addNode(20);
//        list.addNode(30);
//        list.addNode(40);
//        list.addNode(50);
//        list.printList();
//        System.out.println(list.getDataAtAnyPosition(4));
//        list.removeNode(3);
//        System.out.println("After Removing");
//        list.printList();
//        list.addHeadFirst(12);
//        System.out.println("After inserting head");
//        list.printList();
//        list.insertAtAnyPosition(3,22);
        list.addHeadFirst(4);
        System.out.println("After inserting at 3rd position");
        list.removeLast();
    }
}
