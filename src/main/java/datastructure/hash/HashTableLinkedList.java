package datastructure.hash;

/**
 * @author ：stream
 * @date ：Created in 2019/7/25 14:41
 */
public class HashTableLinkedList {
    private HashNode head;

    public void add(HashNode node) {
        if (head == null) {
            head = node;
            return;
        }
        HashNode currentHashNode = head;
        while (true) {
            if (currentHashNode.next == null) {
                break;
            }
            currentHashNode = currentHashNode.next;
        }
        currentHashNode.next = node;
    }

    public void list(int number) {
        if (head == null) {
            System.out.println("current " + (number + 1) + "s linked list is empty!");
            return;
        }
        System.out.print("current " + (number + 1) + " linked list info as follows: ");
        HashNode currentHashNode = head;
        while (true) {
            System.out.println(currentHashNode.toString());
            if (currentHashNode.next == null) {
                break;
            }
            currentHashNode = currentHashNode.next;
        }
    }

    public HashNode findById(int id) {
        if (head == null) {
            System.out.println("current linked list is empty!");
            return null;
        }
        HashNode currentHashNode = head;
        while (true) {
            if (currentHashNode.id == id) {
                break;
            }
            if (currentHashNode.next == null) {
                currentHashNode = null;
                break;
            }
            currentHashNode = currentHashNode.next;
        }
        return currentHashNode;
    }
}
