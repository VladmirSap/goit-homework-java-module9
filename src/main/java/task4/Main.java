package task4;

public class Main {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("Message1");
        myStack.push("Message2");
        myStack.push("Message3");
        myStack.push("Message4");

        System.out.println(myStack);

        System.out.println("myStack size is " + myStack.size());

        myStack.remove(1);
        System.out.println("myStack size after remove is " + myStack.size());

        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        myStack.clear();
        System.out.println(myStack.size());
    }
}
