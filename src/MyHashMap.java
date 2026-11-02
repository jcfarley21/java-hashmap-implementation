public class MyHashMap implements HashMapInterface {
    private Entry[] table;
    private int numOfKeys;

    public MyHashMap() {
        table = new Entry[10];
        numOfKeys = 0;
    }

    public MyHashMap(int numOfBuckets) {
        this.table = new Entry[numOfBuckets];
        numOfKeys = 0;
    }

    public String put(String key, String value) {
        int hash = hash(key);

        if (table[hash] == null) {
            Entry entry = new Entry(key, value);
            table[hash] = entry;
            numOfKeys++;
        } else {
            Entry curr = table[hash];
            Entry previous = null;

            while (curr != null) {
                if (key.equals(curr.key)) {
                    String oldValue = curr.value;
                    curr.value = value;
                    return oldValue;
                }
                previous = curr;
                curr = curr.next;
            }
            previous.next = new Entry(key, value);
            numOfKeys++;
        }

        return null;
    };

    public String get(String key) throws HashMapException {
        int hash = hash(key);

        if (isEmpty()) {
            throw new HashMapException("Empty table");
        }

        if (table[hash] == null) {
            return null;
        } else {
            Entry curr = table[hash];
            while(curr != null) {
                if (curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return null;
        }
    };

    public String remove(String key) throws HashMapException {
        int hash = hash(key);

        if (isEmpty()) {
            throw new HashMapException("Empty table");
        }

        if (table[hash] == null) {
            return null;
        } else {
            Entry curr = table[hash];
            Entry prev = null;

            while (curr != null) {
                if (curr.key.equals(key) && prev == null) {
                    String temp = curr.key;
                    table[hash] = curr.next;
                    numOfKeys--;
                    return temp;
                } else {
                    if (curr.key.equals(key)) {
                        String temp = curr.key;
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
    };

    public boolean containsKey(String key) throws HashMapException {
        int hash = hash(key);
        Entry curr = table[hash];

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
    };

    public int size() {return numOfKeys;};

    public boolean isEmpty() {return numOfKeys == 0;};

    public void clear() {
        table = new Entry[table.length];
        numOfKeys = 0;
    };


    private static class Entry {
        String key;
        String value;
        Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        sum = sum % table.length;
        return sum;
    }
}