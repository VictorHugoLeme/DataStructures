public class HashEntry {
    String key;
    String value;
    HashEntry next;
    HashEntry previous;

    public HashEntry(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}