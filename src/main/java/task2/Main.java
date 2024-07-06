package task2;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> stars = new MyLinkedList<>();
        stars.add("Vega");
        stars.add("Deneb");
        stars.add("Altair");
        stars.add("Antares");
        stars.add("Arctur");

        for (int i = 0; i < stars.size(); i++) {
            System.out.println(stars.get(i));
        }
        System.out.println("------");
        System.out.println("Stars size is " + stars.size());
        System.out.println("Element 1 is " + stars.get(1));
        System.out.println("Remove element 1 - " + stars.remove(1));
        System.out.println("Element 1 after removed is " + stars.get(1));
        stars.clear();
        System.out.println("Stars size after clear - " + stars.size());
    }
}
