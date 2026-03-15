package all;
import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie prev, next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    Movie head = null;
    Movie tail = null;

    // Insert at beginning
    void insertAtBeginning(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at specific position
    void insertAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            insertAtBeginning(title, director, year, rating);
            return;
        }

        Movie newNode = new Movie(title, director, year, rating);
        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;
    }

    // Delete by movie title
    void deleteByTitle(String title) {
        if (head == null) {
            System.out.println("No movies to delete.");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        }
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie deleted.");
    }

    // Search by director OR rating
    void search(String keyDirector, double keyRating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(keyDirector) || temp.rating == keyRating) {
                System.out.println("Found: " + temp.title + " | " + temp.director +
                        " | " + temp.year + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No matching movie found.");
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        Movie temp = head;
        System.out.println("\n--- Movies (Forward) ---");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " +
                    temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        Movie temp = tail;
        System.out.println("\n--- Movies (Reverse) ---");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " +
                    temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        while (true) {
            System.out.println("\n--- Movie Management Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Movie Title");
            System.out.println("5. Search by Director or Rating");
            System.out.println("6. Update Rating");
            System.out.println("7. Display Movies (Forward)");
            System.out.println("8. Display Movies (Reverse)");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 9) break;

            String title, director;
            int year, pos;
            double rating;

            switch (ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.insertAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.insertAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.insertAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Movie Title to Delete: ");
                    title = sc.nextLine();
                    list.deleteByTitle(title);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Director to Search: ");
                    director = sc.nextLine();
                    System.out.print("Rating to Search: ");
                    rating = sc.nextDouble();
                    list.search(director, rating);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Movie Title to Update Rating: ");
                    title = sc.nextLine();
                    System.out.print("New Rating: ");
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}