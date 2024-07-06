package task1;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> fruits = new MyArrayList<>();

        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Peaсh");

        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        System.out.println("index 1: " + fruits.get(1));

        fruits.remove(1);

        System.out.println("index 1 after removal: " + fruits.get(1));

        System.out.println("List size: " + fruits.size());

        fruits.clear();

        System.out.println("List size after clear: " + fruits.size());
    }
}
