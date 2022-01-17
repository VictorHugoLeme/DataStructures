package main.java;

public class HashTable {
    private static final int INITIAL_SIZE = 10;
    private static int size;
    private final Node[] entries = new Node[INITIAL_SIZE];

    public static int getHash(String key) {
        int intKey = key.hashCode();

        if (intKey < 0) {
            intKey = intKey * -1;
        }
        return intKey % INITIAL_SIZE;
    }

    public void insert(String key, String data) {
        int hash = getHash(key);

        Node hashEntry = new Node(key, data);
        Node head = new Node(null, "head");

        if(entries[hash] == null) {
            // setting a head for a double linked list
            entries[hash] = head;
            head.next = hashEntry;
            hashEntry.previous = head;
        }
        else {
            Node current = entries[hash];
            while(current.next !=null) {

                current = current.next;
            }
            current.next = hashEntry;
            current.next.previous = current;
        }
        size++;
    }
    public String get(String key) {

        int hash = getHash(key);
        String response = null;

        if (entries[hash] != null) {
            Node bucket = entries[hash];
            Node current = entries[hash];

            if (bucket.next != null) {
                current = bucket.next;
                while (!current.key.equals(key)
                        && current.next != null) {
                    current = current.next;
                }
                if (current.key.equals(key)) {
                    response = current.data;
                } else {
                    response = "Key not Found";
                }
            }
            else {
                bucket = null;
                response = "Key not Found";
            }
        }
        return response;
    }
    public void remove(String key) {
        int hash = getHash(key);
        Node head = entries[hash];

        if(head == null){
            log("Key not Found");
        }
        else if((head.next.key).equalsIgnoreCase(key)){
            if (head.next.next != null) {
                head.next = head.next.next;
                head.next.previous = head;
            }
            else {
                head.next = null;
            }
            size--;
        }
        else {
            Node current = entries[hash].next;
            while (current != null) {
                if (current.key.equalsIgnoreCase(key)) {
                    current.previous.next = current.next;
                }
                current = current.next;
            }
            size--;
        }
    }

    private static void logln(String msg) {
        System.out.println(msg);
    }
    private static void log(String msg) {
        System.out.print(msg);
    }
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (Node entry : entries) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.data);
            bucket++;

            Node current = entry.next;
            while(current != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(current.data);
                current = current.next;
            }
        }
        return hashTableStr.toString();
    }
    public static void tableSize() {
        System.out.print("Table Size: ");
        System.out.println(size);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        log("Inserting");
        hashTable.insert("kTwisted", "Twisted");
        hashTable.insert("kLed", "Led");
        hashTable.insert("kZeppelin", "Zeppelin");
        hashTable.insert("kDream", "Dream");
        hashTable.insert("kTheater", "Theater");
        hashTable.insert("kSlip", "Slip");
        hashTable.insert("kSisters", "Sisters");
        hashTable.insert("kWhite", "White");
        hashTable.insert("kSnake", "Snake");
        hashTable.insert("kAero", "Aero");
        hashTable.insert("kSmith", "Smith");
        hashTable.insert("kFoo", "Foo");
        hashTable.insert("kBar", "Bar");
        hashTable.insert("kStripes", "Stripes");
        hashTable.insert("kCueio", "Cueio");
        hashTable.insert("kLimão", "Limão");
        hashTable.insert("kSuper", "Super");
        hashTable.insert("kCombo", "Combo");
        logln("-----------------------");

        logln("Printing the table data:");
        logln(hashTable.toString());
        tableSize();
        logln("-----------------------");
        log("Getting the data for the key 'kDream': ");
        logln(hashTable.get("kDream"));
        logln("-----------------------");
        logln("Removing a middle cell, 'Aero'.");
        hashTable.remove("kAero");
        log("Getting 'Aero' value must return 'Key not Found': ");
        logln(hashTable.get("kAero"));
        logln("-----------------------");
        logln(hashTable.toString());
        tableSize();
        logln("-----------------------");
        logln("Removing a lone cell, 'Combo'.");
        hashTable.remove("kCombo");
        logln(hashTable.toString());
        tableSize();
        logln("-----------------------");
        logln("Removing a last cell, 'Limão'.");
        hashTable.remove("kLimão");
        logln("-----------------------");
        logln(hashTable.toString());
        tableSize();
        }
    }