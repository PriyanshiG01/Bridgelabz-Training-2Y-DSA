package all;
import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    Item head = null;

    // Insert at beginning
    void insertAtBeginning(String name, int id, int qty, double price) {
        Item newNode = new Item(name, id, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(String name, int id, int qty, double price) {
        Item newNode = new Item(name, id, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        Item temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
    }

    // Insert at position
    void insertAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos == 1) {
            insertAtBeginning(name, id, qty, price);
            return;
        }

        Item newNode = new Item(name, id, qty, price);
        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by ID
    void deleteById(int id) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item deleted");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Item deleted");
    }

    // Update Quantity
    void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search by ID or Name
    void search(String key) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (String.valueOf(temp.id).equals(key) || temp.name.equalsIgnoreCase(key)) {
                System.out.println("Found: " + temp.name + " | " +
                        temp.id + " | Qty: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No matching item found");
    }

    // Total Inventory Value
    void totalValue() {
        double value = 0;
        Item temp = head;

        while (temp != null) {
            value += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + value);
    }

    // -------- MERGE SORT FOR LINKED LIST --------

    // Split list
    Item getMiddle(Item head) {
        if (head == null) return null;

        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge by Name or Price
    Item merge(Item a, Item b, int option, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;

        if (option == 1) { // Sort by Name
            condition = ascending ?
                    a.name.compareToIgnoreCase(b.name) < 0 :
                    a.name.compareToIgnoreCase(b.name) > 0;
        } else { // Sort by Price
            condition = ascending ?
                    a.price < b.price :
                    a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, option, ascending);
            return a;
        } else {
            b.next = merge(a, b.next, option, ascending);
            return b;
        }
    }

    // Merge sort main
    Item mergeSort(Item head, int option, boolean asc) {
        if (head == null || head.next == null) return head;

        Item mid = getMiddle(head);
        Item nextMid = mid.next;
        mid.next = null;

        Item left = mergeSort(head, option, asc);
        Item right = mergeSort(nextMid, option, asc);

        return merge(left, right, option, asc);
    }

    // Sort wrapper
    void sort(int option, boolean ascending) {
        head = mergeSort(head, option, ascending);
        System.out.println("List sorted successfully.");
    }

    // Display items
    void display() {
        if (head == null) {
            System.out.println("No items to display");
            return;
        }

        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " | " + temp.id + " | Qty: " +
                    temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList list = new InventoryList();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID or Name");
            System.out.println("7. Total Inventory Value");
            System.out.println("8. Sort (1-Name, 2-Price)");
            System.out.println("9. Display All");
            System.out.println("10. Exit");

            int ch = sc.nextInt();
            if (ch == 10) break;

            String name, key;
            int id, qty, pos;
            double price;

            switch (ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    list.insertAtBeginning(name, id, qty, price);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    list.insertAtEnd(name, id, qty, price);
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    list.insertAtPosition(pos, name, id, qty, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    list.deleteById(id);
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    System.out.print("New Quantity: ");
                    qty = sc.nextInt();
                    list.updateQuantity(id, qty);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter Item ID or Name: ");
                    key = sc.nextLine();
                    list.search(key);
                    break;

                case 7:
                    list.totalValue();
                    break;

                case 8:
                    System.out.print("Sort by (1=Name, 2=Price): ");
                    int option = sc.nextInt();
                    System.out.print("Ascending (1) or Descending (2): ");
                    boolean asc = sc.nextInt() == 1;
                    list.sort(option, asc);
                    break;

                case 9:
                    list.display();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}