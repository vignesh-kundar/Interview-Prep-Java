//package cachingAlgorithm.lru;

import java.util.*;

// TODO: Implement LRU Cache with O(1) get and put
public class LRUCache {

    public class Node {
        int key;
        int data;
        Node prev, next;
        Node(int key,int data) {
            this.key=key;
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    private final int capacity;
    private final Map<Integer , Node> map;
    private final Node head , tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer , Node>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        // head <-> tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // TODO: return value if key exists, else -1
        if (!map.containsKey(key)) return -1;
        // if key is present then update the LRU k,v pair!
        Node node = map.get(key);
        removeNode(node);
        insertNodeFromFront(node);
        return node.data;
    }

    public void put(int key, int value) {
        // TODO: insert/update key-value; evict LRU entry if over capacity
        if ( map.containsKey( key ) ) {
            // key is present I need to update the value!
            Node currentNode = map.get(key);
            map.remove(key);
            removeNode(currentNode);
        } else if ( capacity == map.size() ) {
            // map capacity is filled need to remove Most Recently Used Cache!
            // most recentl is always will be the tails previous!
            Node lruNode = tail.prev;
            map.remove(lruNode.key);
            removeNode(lruNode);
            // once removed we can proceed with updating the new Node value!
        }
        Node node = new Node(key , value);
        insertNodeFromFront(node);
        map.put(key , node);
    }

    // Insert Node from the front of Linked List
    // head <-> [] <-> tail
    private void insertNodeFromFront( Node node ) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    // remove the passed Node!
    private void removeNode( Node node ) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}
