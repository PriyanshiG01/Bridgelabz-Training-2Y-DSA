package all;
import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class UndoRedoManager {
    TextState head = null;     // first state
    TextState tail = null;     // last state
    TextState current = null;  // current cursor position
    final int LIMIT = 10;      // max number of states
    int size = 0;

    // Add new state at end
    void addState(String content) {
        TextState newState = new TextState(content);

        // If undo was used earlier, clear forward history
        if (current != tail) {
            TextState temp = current.next;
            while (temp != null) {
                TextState next = temp.next;
                temp.prev = temp.next = null;
                temp = next;
                size--;
            }
            current.next = null;
            tail = current;
        }

        // If list is empty
        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        // Append after tail
        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        enforceLimit();
    }

    // Enforce max 10 states
    void enforceLimit() {
        while (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo: move one state backward
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo: move one state forward
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    void displayCurrent() {
        if (current == null)
            System.out.println("Document empty.");
        else
            System.out.println("Current Text: " + current.content);
    }
}

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UndoRedoManager manager = new UndoRedoManager();

        while (true) {
            System.out.println("\n1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    manager.addState(text);
                    break;

                case 2:
                    manager.undo();
                    break;

                case 3:
                    manager.redo();
                    break;

                case 4:
                    manager.displayCurrent();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}