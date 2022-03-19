package algorithm.datastructure;

import java.util.HashMap;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/19
 */
public class LeetCode146 {

    /**
     * LeetCode 146 LRU缓存
     * <p>
     * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
     * <p>
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
     * 如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
     * <p>
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
     */
    class LRUCache {
        // 使用map来保存key与双链表节点node的映射关系，便于快速获取值
        private HashMap<Integer, Node> map;
        // 存放数据的双链表
        private DoubleList cache;
        // 记录容量
        private int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            this.cache = new DoubleList();
        }

        public int get(int key) {
            // 如果在map中找不到，表示没有对应的元素
            if (!map.containsKey(key)) {
                return -1;
            }
            // 表示找到了，把这个元素设置为最近使用过的元素
            Node node = map.get(key);
            makeRecently(key);
            // 返回对应的值
            return node.value;
        }

        public void put(int key, int value) {
            // 如果已经有了对应的key
            if (map.containsKey(key)) {
                // 删除旧数据
                deleteKey(key);
                // 新插入的数据为最近使用的数据
                addRecently(key, value);
                return;
            }
            // 如果容量满了,删除最久未使用的数据
            if (map.size() >= capacity) {
                removeLeastRecentlyUsed();
            }
            // 添加为最近使用的元素
            addRecently(key, value);
        }

        //将某个key提升为最近使用的
        public void makeRecently(int key) {
            Node node = map.get(key);
            // 从链表中删除节点
            cache.remove(node);
            // 将节点查到队尾
            cache.addLast(node);
        }

        // 添加最近使用的元素
        public void addRecently(int key, int value) {
            Node node = new Node(key, value);
            // 约定链表尾部就是最近使用的元素，故将元素添加到队尾
            cache.addLast(node);
            // 在map中保存key和链表节点的映射关系
            map.put(key, node);
        }

        // 删除某一个key
        private void deleteKey(int key) {
            // 通过key找到要删除的节点
            Node node = map.get(key);
            // 删除链表节点
            cache.remove(node);
            // 删除映射关系
            map.remove(key);
        }

        // 删除最久未使用的元素
        private void removeLeastRecentlyUsed() {
            // 按照约定链表的头部就是最久未使用的
            Node node = cache.removeFirst();
            // 删除映射关系
            map.remove(node.key);
        }
    }

    static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoubleList {
        private final Node head;
        private final Node tail;
        private int size;

        // 双链表初始化
        public DoubleList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
        }

        // 在尾部插入节点
        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        // 删除节点
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // 删除第一个节点，并返回该节点
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        // 返回链表长度
        public int size() {
            return this.size;
        }
    }


}
