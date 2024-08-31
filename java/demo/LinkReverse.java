package day04;


//链表反转


public class LinkReverse {
    class Node {
        int val = 0;
        Node next = null;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    Node header = new Node(0);

    LinkReverse() {
    }

    LinkReverse(boolean test) {

        header.next = new Node(1);
        Node temp = header.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(5);
    }

    LinkReverse reverse() {
        reverse(header.next);
        return this;
    }

    private Node reverse(Node node) {
        if (node.next != null) {
            Node prev = reverse(node.next);
            node.next = null;
            prev.next = node;
        } else {
            header.next = node;
        }
        return node;
    }

    @Override
    public String toString() {
        Node cursor = header;
        StringBuilder sb = new StringBuilder("|");
        while (cursor.next != null) {
            cursor = cursor.next;
            sb.append("->").append(cursor.val);
        }
        return sb.toString();
    }
}
