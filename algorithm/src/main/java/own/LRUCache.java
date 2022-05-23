package own;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 带过期时间的LRU算法
 */
public class LRUCache {

    class DLinkedNode{
        int key,value;
        DLinkedNode prev,next;
        DLinkedNode(){}
        DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> map = new HashMap<>();
    private int capcity;
    private int size;
    private DLinkedNode head,tail;

    LRUCache(int capcity){
        this.capcity = capcity;
        size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    int get(int key){
        DLinkedNode node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    void put(int key, int value){
        DLinkedNode node = map.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            addToHead(newNode);
            map.put(key, newNode);
            ++size;
            if(size > capcity){
                DLinkedNode removeNode = removeTail();
                map.remove(removeNode.key);
                size--;
            }
            return;
        }
        node.value = value;
        moveToHead(node);
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private DLinkedNode removeTail(){
        DLinkedNode removeNode = tail.prev;
        removeNode(removeNode);
        return removeNode;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int i = lRUCache.get(1);// 返回 1
        System.out.println("i = " + i);
    }

}
