package Graph;

public class Queues {
    int front = -1;
    int rear = -1;
    int size;
    int a[];

    Queues(int size){
        this.size = size;
        a = new int[size];
    }
    boolean isEmpty(){
        return front == -1 || rear == -1;
    }
    boolean isFull(){
        return (rear+1)%size == front;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue Overflow");
            //or throw exception
        }
        else {
            if (front==-1){
                front=0;
            }
            rear = (rear+1)%size;
            a[rear] = data;
        }
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -99999;
        }
        if (front == rear) {
            int x = front;
            front = rear = -1;
            return x;
        } else {
            int x = front;
            front = (front+1)%size;
            return a[x];
        }
        }
    public static void main(String[] args) {

    }
    
}
