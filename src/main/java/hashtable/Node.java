package main.java.hashtable;

public class Node {
    String key;
    String data;
    Node next;
    Node previous;

    public Node(String key, String data) {
        this.key = key;
        this.data = data;
    }
}