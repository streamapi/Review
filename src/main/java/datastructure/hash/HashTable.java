package datastructure.hash;

/**
 * @author ：stream
 * @date ：Created in 2019/7/25 14:28
 */
public class HashTable {
    private int size;
    private HashTableLinkedList[] hashTableLinkedArray;

    public HashTable(int size) {
        this.size = size;
        hashTableLinkedArray = new HashTableLinkedList[this.size];
        for (int i = 0; i < size; i++) {
            hashTableLinkedArray[i] = new HashTableLinkedList();
        }
    }

    public void add(HashNode hashNode) {
        hashTableLinkedArray[hashFunction(hashNode.id)].add(hashNode);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            hashTableLinkedArray[i].list(i);
        }
    }

    public String findById(int id){
        HashNode goal = hashTableLinkedArray[hashFunction(id)].findById(id);
        if (goal != null){
            return goal.toString();
        }else{
            return "not find!";
        }
    }

    public int hashFunction(int id) {
        return id % size;
    }

    public static void main(String[] args) {
        System.out.println(new Integer(1).hashCode());
    }
}
