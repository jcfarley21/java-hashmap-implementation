public class HashMapTester {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(0, "John");
        map.put(1, "Terry");
        map.put(2, "Jacob");

        map.print();

        MyHashMap<String, Integer> map2 = new MyHashMap<>();
        map2.put("Johnny", 2);
        map2.put("Jerry", 2);
        map2.put("Tara", 100);
        map2.size();
        //map2.clear();
        //map2.remove("Johnny");
        //map2.remove("Tara");
        map2.remove("Taa");

        map2.print();
        System.out.println(map2.size());


    }
}
