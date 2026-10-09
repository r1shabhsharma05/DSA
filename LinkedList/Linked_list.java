public class Linked_list {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add First
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
    }

    // Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print Linked List
    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Reverse using static method
    public static void reverse(Node head) {

        Node prev = null;
        Node curr = head;
        Node next;

        tail = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Linked_list.head = prev;
    }

    // Add at index
    public void add(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx < 0 || idx > size) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // Remove First
    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;

            head = tail = null;
            size = 0;

            return val;
        }

        int val = head.data;

        head = head.next;
        size--;

        return val;
    }

    // Remove Last
    public int removeLast() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;

            head = tail = null;
            size = 0;

            return val;
        }

        Node temp = head;

        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }

        int val = temp.next.data;

        temp.next = null;
        tail = temp;
        size--;

        return val;
    }

    // Iterative Search
    public int itrSerach(int key) {

        Node temp = head;
        int i = 0;

        while (temp != null) {

            if (temp.data == key) {
                return i;
            }

            temp = temp.next;
            i++;
        }

        return -1;
    }

    // Recursive Search Helper
    public int helper(Node head, int key) {

        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    // Recursive Search
    public int recSearch(int key) {
        return helper(head, key);
    }

    // Reverse
    public void revers() {

        Node prev = null;
        Node curr = head;
        Node next;

        tail = head;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Delete nth node from end
    public void deletefromnth(int n) {

        if (head == null || n <= 0) {
            return;
        }

        int sz = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n > sz) {
            System.out.println("Invalid n");
            return;
        }

        // Remove first
        if (n == sz) {

            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }

            return;
        }

        int i = 1;
        Node prev = head;

        int z = sz - n;

        while (i < z) {
            prev = prev.next;
            i++;
        }

        if (prev.next == tail) {
            tail = prev;
        }

        prev.next = prev.next.next;
        size--;
    }

    // Detect Cycle
    public boolean isCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Remove Cycle
    public static void removeCycle() {

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        // Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // Find meeting point
        slow = head;
        Node prev = null;

        while (slow != fast) {

            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // Cycle starts at head
        if (prev == null) {

            prev = fast;

            while (prev.next != fast) {
                prev = prev.next;
            }
        }

        // Remove cycle
        prev.next = null;
        tail = prev;
    }

    // Get Middle
    public Node getmid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted Linked Lists
    public Node merge(Node head1, Node head2) {

        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {

                temp.next = head1;
                head1 = head1.next;

            } else {

                temp.next = head2;
                head2 = head2.next;
            }

            temp = temp.next;
        }

        while (head1 != null) {

            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {

            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    // Merge Sort
    public Node mergeSort(Node head) {    // o(ologn)

        if (head == null || head.next == null) {
            return head;
        }

        // 1. Find mid
        Node mid = getmid(head);

        // 2. Divide
        Node rightHead = mid.next;
        mid.next = null;

        // 3. Sort left and right
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // 4. Merge
        return merge(newLeft, newRight);
    }

    public void zigzag(){
         //find mid 
         Node slow = head;
         Node fast = head;
         while(fast != null && fast.next!=null){
             slow = slow.next;
             fast = fast.next.next;
         }
         Node mid = slow;

         //reverse 2nd half
         mid.next = null;
         Node curr = mid.next;
         
         Node prev = null;
         Node next;
         while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL; 
        Node nextR;

        //alternate merge 
        while(left!=null && right !=null){
             nextL = left.next;
             left.next = right;
             nextR = right.next;
             right.next = nextL;
             right = nextR;
             left = nextL;

        }
    }

    // Main
    public static void main(String[] args) {

        Linked_list ll = new Linked_list();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(5);
        ll.print();
        ll.zigzag();
        ll.print();
 
        // System.out.println("Original Linked List:");
        // ll.print();

        // ll.head = ll.mergeSort(ll.head);

        // System.out.println("After Merge Sort:");
        // ll.print();
    }
}