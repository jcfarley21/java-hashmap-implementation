public interface HashMapInterface {
    public String put(String key, String value);
    public String get(String key) throws HashMapException;
    public String remove(String key) throws HashMapException;
    public boolean containsKey(String key) throws HashMapException;
    public int size();
    public boolean isEmpty();
    public void clear();
}
