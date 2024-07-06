package task3;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        queue.add("Number1");
        queue.add("Number2");
        queue.add("Number3");
        queue.add("Number4");
        queue.add("Number5");
        queue.add("Number6");

        System.out.println("Size of queue: " + queue.size());
        System.out.println("Peek: " + queue.peek());

        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());

        System.out.println("Size of queue after polls: " + queue.size());
        System.out.println("Peek after polls: " + queue.peek());

        queue.clear();
        System.out.println("Size of queue after clear: " + queue.size());
    }
}
