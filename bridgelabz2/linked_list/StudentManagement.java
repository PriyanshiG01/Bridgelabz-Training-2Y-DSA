package all;
import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head = null;

    // Insert at beginning
    void insertAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at specific position
    void insertAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos == 1) {
            insertAtBeginning(roll, name, age, grade);
            return;
        }

        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;

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

    // Delete by roll number
    void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            System.out.println("Record deleted");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Record not found");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Record deleted");
    }

    // Search student
    void searchStudent(int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Record not found");
    }

    // Update Grade
    void updateGrade(int roll, String newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found");
    }

    // Display all records
    void display() {
        if (head == null) {
            System.out.println("No records to display");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println(temp.roll + "  " + temp.name + "  " + temp.age + "  " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Records");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 8) break;

            int roll, age, pos;
            String name, grade;

            switch (ch) {
                case 1:
                    System.out.print("Roll: ");
                    roll = sc.nextInt();
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    System.out.print("Grade: ");
                    grade = sc.next();
                    list.insertAtBeginning(roll, name, age, grade);
                    break;

                case 2:
                    System.out.print("Roll: ");
                    roll = sc.nextInt();
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    System.out.print("Grade: ");
                    grade = sc.next();
                    list.insertAtEnd(roll, name, age, grade);
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    System.out.print("Roll: ");
                    roll = sc.nextInt();
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    System.out.print("Grade: ");
                    grade = sc.next();
                    list.insertAtPosition(pos, roll, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll to Delete: ");
                    roll = sc.nextInt();
                    list.deleteByRoll(roll);
                    break;

                case 5:
                    System.out.print("Enter Roll to Search: ");
                    roll = sc.nextInt();
                    list.searchStudent(roll);
                    break;

                case 6:
                    System.out.print("Enter Roll to Update: ");
                    roll = sc.nextInt();
                    System.out.print("New Grade: ");
                    grade = sc.next();
                    list.updateGrade(roll, grade);
                    break;

                case 7:
                    list.display();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}