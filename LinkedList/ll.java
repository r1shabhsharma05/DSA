public class ll {

    public class Node {
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
    public void add(int idx , int data){
        if(idx==0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public int removeFirst(){
        if(size==0){
            System.out.println("ll is empty");
        }
        else if(size==1){
         int val = head.data;
         head = tail = null;
         size =0;
         return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static void main(String args[]) {

        ll linkedlist = new ll();

       

        linkedlist.addFirst(2);
       

        linkedlist.addFirst(1);
       

        linkedlist.addLast(3);
        

        linkedlist.addLast(4);
        linkedlist.add(2, 9);
        linkedlist.print();
        //System.out.println(linkedlist.size);
        linkedlist.removeFirst();
        linkedlist.print();
    }
}