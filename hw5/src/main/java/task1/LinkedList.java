package task1;

public class LinkedList<T extends Number> {

    Node head;

    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();

        list.insertAtTheEnd(1);
        list.insertAtTheEnd(2);
        list.insertAtTheEnd(3);

        list.insertAtTheBeginning(4);
        list.insertAtTheBeginning(5);
        list.insertAtTheBeginning(6);

        list.insertAtTheEnd(7);
        list.insertAtTheEnd(8);
        list.insertAtTheEnd(9);

        System.out.println("Created list is: ");
        list.printlist(list.head);

        list.insertAfter(list.head.next, 0);
        list.insertAfter(list.head.next.next.next, 0);

        System.out.println("List after insertAfter: ");
        list.printlist(list.head);

        list.insertBefore(list.head.next, -1);
        list.insertBefore(list.head.next.next, -2);

        System.out.println("List after insertBefore: ");
        list.printlist(list.head);

        list.removeBefore(list.head.next.next.next);

        System.out.println("List after remove: ");
        list.printlist(list.head);
    }

    public void insertAtTheBeginning(int newData)
    {
        Node newNode = new Node(newData);
        newNode.next = head;
        newNode.prev = null;

        if (head != null){
            head.prev = newNode;
        }

        head = newNode;
    }

    public void insertBefore(Node nextNode, int newData)
    {
        if (nextNode == null) {
            System.out.println("The next node can not be NULL");
            return;
        }

        Node newNode = new Node(newData);
        newNode.prev = nextNode.prev;
        nextNode.prev = newNode;
        newNode.next = nextNode;

        if (newNode.prev != null)
            newNode.prev.next = newNode;
        else
            head = newNode;
    }

    public void insertAfter(Node prevNode, int newData)
    {
        if (prevNode == null) {
            System.out.println("The previous node cannot be NULL");
            return;
        }

        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    void insertAtTheEnd(int newData)
    {
        Node newNode = new Node(newData);
        Node last = head;
        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
    }

    public void printlist(Node node)
    {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println();
    }

    public void removeBefore(Node nextNode)
    {
        if (nextNode == null) {
            System.out.println("The next node can not be NULL");
            return;
        }

        nextNode.prev = nextNode.prev.prev;
        if (nextNode.prev != null)
            nextNode.prev.next = nextNode;
        else
            head = nextNode;
    }

}
