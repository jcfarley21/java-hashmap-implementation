public class MyHashMap<K, V> implements HashMapInterface<K, V> {
    private Entry<K, V>[] table;
    private int numOfKeys;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = (Entry<K, V>[]) new Entry[10];
        numOfKeys = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int numOfBuckets) {
        this.table = (Entry<K, V>[]) new Entry[numOfBuckets];
        numOfKeys = 0;
    }

    public V put(K key, V value) {
        int hash = hash(key);

        if (table[hash] == null) {
            Entry<K, V> entry = new Entry<>(key, value);
            table[hash] = entry;
            numOfKeys++;
        } else {
            Entry<K, V> curr = table[hash];
            Entry<K, V> previous = null;

            while (curr != null) {
                if (key.equals(curr.key)) {
                    V oldValue= curr.value;
                    curr.value = value;
                    return oldValue;
                }
                previous = curr;
                curr = curr.next;
            }
            previous.next = new Entry<>(key, value);
            numOfKeys++;
        }

        return null;
    }

    public V get(K key) throws HashMapException {
        int hash = hash(key);

        if (isEmpty()) {
            throw new HashMapException("Empty table");
        }

        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> curr = table[hash];
            while(curr != null) {
                if (curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return null;
        }
    }

    public V remove(K key) throws HashMapException {
        int hash = hash(key);

        if (isEmpty()) {
            throw new HashMapException("Empty table");
        }

        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> curr = table[hash];
            Entry<K, V> prev = null;

            while (curr != null) {
                if (curr.key.equals(key) && prev == null) {
                    V temp = curr.value;
                    table[hash] = curr.next;
                    numOfKeys--;
                    return temp;
                } else {
                    if (curr.key.equals(key)) {
                        V temp = curr.value;
                        prev.next = curr.next;
                        numOfKeys--;
                        return temp;
                    }
                    prev = curr;
                    curr = curr.next;
                }
            }

            return null;
        }
    }

    public boolean containsKey(K key) throws HashMapException {
        int hash = hash(key);
        Entry<K, V> curr = table[hash];

        if(isEmpty()) {
            throw new HashMapException("Empty table");
        }

        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    public int size() {return numOfKeys;}

    public boolean isEmpty() {return numOfKeys == 0;}

    public void clear() {
        table = (Entry<K, V>[]) new Entry[table.length];
        numOfKeys = 0;
    }


    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private int hash(K key) {
        return Math.floorMod(key.hashCode(), table.length);
    }
}