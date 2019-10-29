import HashTable.HashTable;

public class HashTableDriver {
    public static void main(String[] args) {
        HashTable h = new HashTable(997);

        h.put(10, 100);
        h.put(8, 64);
        h.put(6, 36);

        System.out.println(h.contains(6));
        System.out.println(h.contains(2));

        h.remove(6);

        System.out.println(h.get(6));
        System.out.println(h.get(10));

        h.print();
    }
}
