package Final;

public class LinkedList {
    // Class representing a priority queue
    class PriorityQueue {
        private Node head; // Head node of the priority queue

        // Method to insert a new node into the priority queue
        public void insert(Node newNode) {
            if (isEmpty()) {
                head = newNode;
            } else {
                if (head.priority >= newNode.priority) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    Node current = head;
                    while (current.next != null && current.next.priority < newNode.priority) {
                        current = current.next;
                    }
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }

        // Method to check if the priority queue is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Method to print the elements of the priority queue
        public void print() {
            Node printedNode = head;
            if (isEmpty()) {
                System.out.println("Empty list!");
            } else {
                while (printedNode != null) {
                    System.out.println(printedNode.priority + " " + printedNode.data);
                    printedNode = printedNode.next;
                }
            }
        }

        // Method to remove the minimum element from the priority queue
        public void removeMin() {
            head = head.next;
        }

        // Method to get the minimum element from the priority queue
        public String getMin() {
            return head.data;
        }
    }

    // Class representing a node in the priority queue
    class Node {
        int priority;
        String data;
        Node next;

        public Node(int priority, String data) {
            this.priority = priority;
            this.data = data;
            next = null;
        }
    }
}
