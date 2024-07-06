package task5;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> keyValue = new MyHashMap<>();
        keyValue.put("key1", "value1");
        keyValue.put("key2", "value2");
        keyValue.put("key3", "value3");
        keyValue.put("key4", "value4");
        keyValue.put(null, "value4");
        keyValue.put("key5", null);
        System.out.println(keyValue);
        System.out.println("Size of keyValue " + keyValue.size());

        keyValue.remove(null);
        System.out.println("Size after remove " + keyValue.size());
        System.out.println(keyValue);

        System.out.println(keyValue.get("key1"));

        keyValue.clear();
        System.out.println("Size after clear " + keyValue.size());
        System.out.println(keyValue);
    }
}
