package main.java.hashtable;

public class HashTable {
    private static final int INITIAL_SIZE = 10;
    private int size;
    private final Node[] entries = new Node[INITIAL_SIZE];
    String notFound = "Key not Found";

    public static int getHash(String key) {
        int intKey = key.hashCode();

        if (intKey < 0) {
            intKey = intKey * -1;
        }
        return intKey % INITIAL_SIZE;
    }

    public void insert(String key, String data) {
        int hash = getHash(key);

        Node entryNode = new Node(key, data);
        Node head = new Node(null, "head");

        if (entries[hash] == null) {
            // setting a head for a double linked list
            entries[hash] = head;
            head.next = entryNode;
            entryNode.previous = head;
        } else {
            Node current = entries[hash];
            while (current.next != null) {

                current = current.next;
            }
            current.next = entryNode;
            current.next.previous = current;
        }
        size++;
    }

    public String get(String key) {

        int hash = getHash(key);
        String response = null;

        if (entries[hash] != null) {
            Node bucket = entries[hash];

            if (bucket.next != null) {
                Node current = bucket.next;
                while (!current.key.equals(key)
                        && current.next != null) {
                    current = current.next;
                }
                if (current.key.equals(key)) {
                    response = current.data;
                } else {
                    response = notFound;
                }
            } else {
                entries[hash] = null;
                response = notFound;
            }
        }
        return response;
    }

    public boolean remove(String key) {
        int hash = getHash(key);
        Node head = entries[hash];

        if (head == null) {
            return false;
        } else if ((head.next.key).equalsIgnoreCase(key)) {
            if (head.next.next != null) {
                head.next = head.next.next;
                head.next.previous = head;
            } else {
                head.next = null;
            }
            size--;
            return true;
        } else {
            Node current = entries[hash].next;
            while (current != null) {
                if (current.key.equalsIgnoreCase(key)) {
                    current.previous.next = current.next;
                }
                current = current.next;
            }
            size--;
            return true;
        }
    }

    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (Node entry : entries) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.data);
            bucket++;

            Node current = entry.next;
            while (current != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(current.data);
                current = current.next;
            }
        }
        return hashTableStr.toString();
    }

    public void tableSize() {
        System.out.print("Table Size: ");
        System.out.println(size);
    }
}