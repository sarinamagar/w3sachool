public class TestStacks {
    public static void main(String[] args) {
        Stacks stk = new Stacks(5);
        stk.push(10);
        stk.push(20);
        System.out.println(stk.pop());
        System.out.println(stk.peak());
        System.out.println(stk.pop());
//        System.out.println(stk.pop());

        Stacks Stack = new Stacks(10);
        for(int i = 0; i < 10; i++) {

        Stack.push(i); Stack.pop(); Stack.pop(); Stack.pop(); } }

}
