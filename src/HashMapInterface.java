public interface HashMapInterface<K, V> {
    public V put(K key, V value);
    public V get(K key) throws HashMapException;
    public V remove(K key) throws HashMapException;
    public boolean containsKey(K key) throws HashMapException;
    public int size();
    public boolean isEmpty();
    public void clear();
}
