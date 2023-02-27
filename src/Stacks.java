public class Stacks {
    int top = -1;
    int stk[];
    int size;

    Stacks(int size){
        this.size = size;
        stk = new int[size];
    }
    boolean isFull(){
        return top==size-1;
    }
    boolean isEmpty(){
        return top==-1;
    }

    void push(int data){
        if(isFull()){
            System.out.println("Stack Overflow");
        }else {
            top++;
            stk[top] = data;
//            stk[++top] == data;
        }
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -99999;
        }
        int res = stk[top];
        top--;
//        return stk[top--]
        return res;
    }
    int peak(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -99999;
        }
        return stk[top];
    }
}
// practice Stack of - char string objects