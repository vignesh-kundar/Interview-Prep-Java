//package cachingAlgorithm.lru;

/*
 * Problem: LRU Cache (Least Recently Used Cache)
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *   LRUCache(int capacity)   - Initialize the LRU cache with positive size capacity.
 *   int get(int key)          - Return the value of the key if it exists, otherwise return -1.
 *   void put(int key, int value) - Update or insert the key-value pair. If the number of keys
 *                                  exceeds capacity, evict the least recently used key.
 *
 * Both operations must run in O(1) average time.
 */

import java.util.*;

public class LRUCacheDriver {

    public static void main(String args[]) {
        System.out.println("Least Recently Used Cache == test casess are being executed!");

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1) = " + cache.get(1)); // 1
        cache.put(3, 3); // evicts key 2
        System.out.println("get(2) = " + cache.get(2)); // -1
        cache.put(4, 4); // evicts key 1
        System.out.println("get(1) = " + cache.get(1)); // -1
        System.out.println("get(3) = " + cache.get(3)); // 3
        System.out.println("get(4) = " + cache.get(4)); // 4

        System.out.println("\n--- Additional test: capacity 1 ---");
        LRUCache cache2 = new LRUCache(1);
        cache2.put(1, 1);
        System.out.println("get(1) = " + cache2.get(1)); // 1
        cache2.put(2, 2); // evicts key 1
        System.out.println("get(1) = " + cache2.get(1)); // -1
        System.out.println("get(2) = " + cache2.get(2)); // 2

        System.out.println("\n--- Test: update existing key ---");
        LRUCache cache3 = new LRUCache(2);
        cache3.put(1, 1);
        cache3.put(2, 2);
        cache3.put(1, 10); // update key 1
        System.out.println("get(1) = " + cache3.get(1)); // 10
        cache3.put(3, 3); // evicts key 2
        System.out.println("get(2) = " + cache3.get(2)); // -1
        System.out.println("get(1) = " + cache3.get(1)); // 10
    }
}
