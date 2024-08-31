// Question: Given a linked list, reverse the nodes of the list k at a time and return its modified list.
// If the number of nodes is not a multiple of k, then the remaining nodes should remain as is.

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReverseKGroup {

    // Function to reverse nodes in k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;

        // Check if there are at least k nodes left to reverse
        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        // If less than k nodes remain, return the head as is
        if (count < k) {
            return head;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Recur for the remaining list and connect the reversed segment
        head.next = reverseKGroup(current, k);

        // Return the new head of the reversed segment
        return prev;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the reverseKGroup method
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3; // Group size to reverse

        // Create an instance of ReverseKGroup
        ReverseKGroup solution = new ReverseKGroup();

        System.out.println("Original List:");
        printList(head);

        // Reverse the nodes in k-groups
        head = solution.reverseKGroup(head, k);

        System.out.println("Reversed List:");
        printList(head);
    }
}
