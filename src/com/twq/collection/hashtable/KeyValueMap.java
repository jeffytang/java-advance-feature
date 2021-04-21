package com.twq.collection.hashtable;

/**
 *  散列表
 */
public class KeyValueMap<K, V> {

    static final int DEFAULT_LENGTH = 10;

    /**
     *  链表的节点
     */
    class EntryNode<K, V> {
        K key;
        V value;
        EntryNode next;

        EntryNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private EntryNode<K, V>[] entryNodes; // 散列表

    public KeyValueMap() {
        entryNodes = new EntryNode[DEFAULT_LENGTH];
    }

    public KeyValueMap(int length) {
        entryNodes = new EntryNode[length];
    }

    /**
     * 根据 key 拿到对应的 value
     * @param key
     * @return
     */
    public V get(K key) {
        // 计算 hash 值
        int hash = hash(key);
        // 拿到对应的下标的链表头结点
        EntryNode<K, V> head = entryNodes[hash];
        if (head == null) { // 头结点为空
            return null;
        } else {
            EntryNode<K, V> curr = head;
            // 循环遍历链表的每一个节点
            while (curr != null) {
                // 对比 key，相等的话，表示找到了，直接返回 value
                if (curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
            // 链表中也不存在对应的 value
            return null;
        }
    }

    /**
     * 将 key-value 数据放到散列表 entryNodes 中
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        // 创建一个节点
        EntryNode<K, V> node = new EntryNode(key, value);
        // 计算 key 的 hash 值
        int hash = hash(key);
        // 拿到对应列表的头
        EntryNode<K, V> head = entryNodes[hash];
        if (head == null) { // 头没有值
            // 直接将需要插入的节点作为头节点
            entryNodes[hash] = node;
        } else {
            // 找到链表的最后一个节点
            EntryNode<K, V> last = head;
            EntryNode<K, V> curr = head.next;
            while (curr != null) {
                last = curr;
                curr = curr.next;
            }
            // 将需要插入的数据插入到最后的节点的 next
            last.next = node;
        }
    }

    /**
     *  散列函数
     * @param key
     * @return  对应的数组下标
     */
    public int hash(K key) { // key（键）
        int index = key.hashCode();
        // 取模，保证计算出来的 hash 值不会超过数组的长度
        return index % entryNodes.length;
    }
}
