package com.twq.collection;

/**
 *  单向链表中的一个节点
 */
class ListNode {
    // 存储的数据
    int data;
    // 存储下一个节点的引用(地址、指针)
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

/**
 *  双向链表的中一个节点
 */
class DoublyListNode {
    int data;
    // 上一个节点的引用
    DoublyListNode prev;
    // 下一个节点的引用
    DoublyListNode next;

    DoublyListNode(int data) {
        this.data = data;
    }
}

public class TestLinkedList {
    public static void main(String[] args) {
        // 构建一个单向链表
        ListNode firstNode = new ListNode(5);
        ListNode secondNode = new ListNode(12);
        ListNode thirdNode = new ListNode(3);
        ListNode forthNode = new ListNode(9);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = forthNode;

        insertNode(firstNode, 12, new ListNode(22));

        ListNode delNode = removeNode(firstNode, 5);

        printLinkedList(delNode);

        // 构建一个双向链表
        DoublyListNode first = new DoublyListNode(5);
        DoublyListNode second = new DoublyListNode(12);
        DoublyListNode third = new DoublyListNode(3);
        DoublyListNode forth = new DoublyListNode(9);

        first.next = second;

        second.prev = first;
        second.next = third;

        third.prev = second;
        third.next = forth;

        forth.prev = third;
        forth.next = null;
    }

    /**
     *  删除指定的链表中指定的节点
     * @param head  指定链表的头结点
     * @param value 需要删除节点的值
     */
    public static ListNode removeNode(ListNode head, int value) {
        ListNode selectedNode = head;
        ListNode previousNode = null;
        while (selectedNode != null) {
            if (selectedNode.data == value) {
                break;
            }
            // 记录前一个节点
            previousNode = selectedNode;
            // 访问下一个节点
            selectedNode = selectedNode.next;
        }
        // 删除一个节点
        if (previousNode == null) { // 删除头结点
            // 创建一个新的节点作为头结点
            // 这个新节点的值等于原先头结点的值
            head = new ListNode(selectedNode.next.data);
            // 这个新节点的 next 等于原先头结点的 next 的 next
            head.next = selectedNode.next.next;
        } else {
            if (selectedNode == null) {
                System.out.println("链表中不存在这个节点：" + value);
            } else {
                previousNode.next = selectedNode.next;
                selectedNode.next = null;
            }
        }
        return head;
    }

    /**
     *  在指定链表中的指定节点后面插入一个节点
     * @param head  指定的链表的头节点
     * @param value 指定的节点的值
     * @param addNode 需要插入的节点
     */
    public static void insertNode(ListNode head, int value, ListNode addNode) {
        ListNode selectedNode = head;
        while (selectedNode != null) {
            if (selectedNode.data == value) {
                break;
            }
            // 遍历下一个节点
            selectedNode = selectedNode.next;
        }
        if (selectedNode != null) {
            // 将选中的节点的 next 赋值给新增节点的 next
            addNode.next = selectedNode.next;
            // 将新增的节点赋值给选中的节点的 next
            selectedNode.next = addNode;
        } else {
            System.out.println("链表中不存在这个节点：" + value);
        }

    }

    /**
     *  遍历打印一个链表中的值
     * @param head 链表的头
     */
    public static void printLinkedList(ListNode head) {
        // 访问头结点
        ListNode currentNode = head;
        // 当访问节点为 null 时候，就表示到了链表的结尾
        while (currentNode != null) {
            System.out.println(currentNode.data);
            // 访问下一个元素节点
            currentNode = currentNode.next;
        }
    }
}
