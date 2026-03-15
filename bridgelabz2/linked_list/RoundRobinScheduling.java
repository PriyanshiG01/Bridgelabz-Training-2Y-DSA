package all;
import java.util.Scanner;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }
}

class CircularLinkedList {
    Process head = null;

    // Add process at end (circular)
    void addProcess(int pid, int bt, int pr) {
        Process newNode = new Process(pid, bt, pr);

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // Delete a process by PID
    void deleteProcess(int pid) {
        if (head == null) return;

        Process curr = head, prev = null;

        if (head.pid == pid) {
            if (head.next == head) {
                head = null;
                return;
            }
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = head.next;
            head = head.next;
            return;
        }

        do {
            prev = curr;
            curr = curr.next;
        } while (curr != head && curr.pid != pid);

        if (curr.pid == pid) {
            prev.next = curr.next;
        }
    }

    // Display circular queue
    void display() {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("PID: " + temp.pid + " | BT Left: " + temp.remainingTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Count total processes
    int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Round Robin Simulation
    void roundRobin(int tq) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWT = 0, totalTAT = 0, time = 0;
        int n = countProcesses();
        Process curr = head;

        while (head != null) {
            if (curr.remainingTime > tq) {
                curr.remainingTime -= tq;
                time += tq;
            } else {
                time += curr.remainingTime;
                curr.remainingTime = 0;

                totalTAT += time;
                totalWT += time - curr.burstTime;

                int id = curr.pid;
                curr = curr.next;
                deleteProcess(id);

                if (head == null) break;
                continue;
            }

            curr = curr.next;

            System.out.println("\nQueue After Round:");
            display();
        }

        System.out.println("\nAverage Waiting Time: " + (totalWT / (double) n));
        System.out.println("Average Turnaround Time: " + (totalTAT / (double) n));
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("\n1. Add Process\n2. Display\n3. Run RR Scheduling\n4. Exit");
            int ch = sc.nextInt();

            if (ch == 4) break;

            switch (ch) {
                case 1:
                    System.out.print("PID: ");
                    int pid = sc.nextInt();
                    System.out.print("Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Priority: ");
                    int pr = sc.nextInt();
                    list.addProcess(pid, bt, pr);
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.print("Time Quantum: ");
                    int tq = sc.nextInt();
                    list.roundRobin(tq);
                    break;
            }
        }
        sc.close();
    }
}