package array_level1;
class CustomHashMap {
    class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] buckets = new Node[1000];

    private int hash(int key) {
        return key % buckets.length;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        Node head = buckets[idx];

        if (head == null) {
            buckets[idx] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int idx = hash(key);
        Node curr = buckets[idx];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        Node curr = buckets[idx], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) buckets[idx] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}