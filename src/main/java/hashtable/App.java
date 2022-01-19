package main.java.hashtable;

public class App {
    private static void logln(String msg) {
        System.out.println(msg);
    }
    private static void log(String msg) {
        System.out.print(msg);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        String spacer = "-----------------------";

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
        logln(spacer);

        logln("Printing the table data:");
        logln(hashTable.toString());
        hashTable.tableSize();
        logln(spacer);

        log("Getting the data for the key 'kDream': ");
        logln(hashTable.get("kDream"));
        logln(spacer);

        logln("Removing a middle cell, 'Aero'.");
        hashTable.remove("kAero");
        log("Getting 'Aero' value must return 'Key not Found': ");
        logln(hashTable.get("kAero"));
        logln(spacer);

        logln(hashTable.toString());
        hashTable.tableSize();
        logln(spacer);

        logln("Removing a lone cell, 'Combo'.");
        hashTable.remove("kCombo");
        logln(hashTable.toString());
        hashTable.tableSize();
        logln(spacer);

        logln("Removing a last cell, 'Limão'.");
        hashTable.remove("kLimão");
        logln(spacer);

        logln(hashTable.toString());
        hashTable.tableSize();
    }
}
