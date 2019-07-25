package datastructure.hash;

/**
 * @author ：stream
 * @date ：Created in 2019/7/25 14:38
 */
public class HashNode {
    public int id;
    public Object data;
    public HashNode next;

    public HashNode(int id, Object data, HashNode next) {
        this.id = id;
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "HashNode{" +
                "id=" + id +
                ", data=" + data +
                ", next=" + next +
                '}';
    }
}
