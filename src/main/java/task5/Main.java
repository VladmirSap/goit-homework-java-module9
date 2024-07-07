package task5;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> keyValue = new MyHashMap<>();
        keyValue.put("key1", "value1");
        keyValue.put("key2", "value2");
        keyValue.put("key3", "value3");
        keyValue.put("key4", "value4");
        keyValue.put(null, "value5");
        keyValue.put("key5", null);
//        System.out.println(keyValue);
        System.out.println("Size of keyValue " + keyValue.size());
        System.out.println("Value of key null " + keyValue.get(null));
        keyValue.put(null, "value6");
        System.out.println("Value of key null " + keyValue.get(null));
//        System.out.println(keyValue);
        keyValue.remove(null);
        System.out.println("Size after remove " + keyValue.size());
//        System.out.println(keyValue);
        System.out.println("Key null - " + keyValue.get(null));
        System.out.println("Key1 - " + keyValue.get("key1"));
        keyValue.clear();
        System.out.println("Size after clear " + keyValue.size());
//        System.out.println(keyValue);
    }
}
