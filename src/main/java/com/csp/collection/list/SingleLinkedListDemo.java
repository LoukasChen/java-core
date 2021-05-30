package com.csp.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: 实现链表
 * @date 2019/5/25 19:32
 */
public class SingleLinkedListDemo {
    /**
     * 定义头指针
     */
    private static Node head = null;

    public static void main(String[] args) {
        SingleLinkedListDemo linkList = new SingleLinkedListDemo();
        List<String> list = new ArrayList<>();
        list.add("数据结构");
        list.add("算法");
        list.add("计算机网络");
        list.add("操作系统");
        list.add("操作系统");
//        list.forEach(value -> linkList.insertToHead(value));
        list.forEach(value -> linkList.insertToTail(value));
        linkList.insertAfter("计算机网络", "计算机组成原理");
//        Node node = linkList.reverseList(head);
//        Node node = linkList.reverseListRec(head);
//        linkList.deleteByIndexNode(head, 5);
//        linkList.deleteByValueNode(head, "计算机网络");
//        linkList.deleteRepeatNode(head);
        Node middleNode = linkList.findMiddleNode(head);
//        Node lastIndexNode = linkList.findLastIndexNode(head, 4);
        System.out.println(linkList.getSize(middleNode));
        linkList.print(middleNode);
//        linkList.deleteNode();
//        linkList.print();

    }

    /**
     * 头插法，顺序为倒序
     *
     * @param value
     */
    public void insertToHead(String value) {
        Node newNodode = new Node(value);
        if (newNodode != null) {
            if (head == null) {
                head = newNodode;
            } else {
                newNodode.next = head;
                head = newNodode;
            }
        }
    }

    /**
     * 尾插法，正序
     *
     * @param value
     */
    public void insertToTail(String value) {
        Node newNodode = new Node(value);
        if (newNodode != null) {
            if (head == null) {
                head = newNodode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNodode;
            }
        }
    }

    /**
     * 将某节点插入指定的位置后
     *
     * @param insertNode
     * @param value
     */
    public void insertAfter(String insertNode, String value) {
        Node newNode = new Node(value);
        if (insertNode != null) {
            if (head.next == null) {
                return;
            } else {
                Node temp = head;
                while (!insertNode.equals(temp.data)) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }


    /**
     * 链表反转
     *
     * @param currentNode
     * @return
     */
    public Node reverseList(Node currentNode) {
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        } else {
            // 初始化新的链表
            Node newNode = null;
            while (currentNode != null) {
                // temp存储当前链表的下一个节点及后面
                Node temp = currentNode.next;
                currentNode.next = newNode;
                newNode = currentNode;
                currentNode = temp;
            }
            return newNode;
        }
    }

    /**
     * 反转链表-递归方式
     *
     * @param node
     * @return
     */
    public Node reverseListRec(Node node) {
        if (node.next == null) {
            return node;
        } else {
            Node newNode = reverseListRec(node.next);
            node.next.next = node;
            node.next = null;
            return newNode;
        }
    }

    /**
     * 判断链表是否有环
     *
     * @param node
     * @return
     */
    public boolean isLoop(Node node) {
        if (node == null || node.next == null) {
            return false;
        } else {
            // 初始化一个快指针，慢指针
            Node fast = node, slow = node;
            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return false;
                } else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
            return true;
        }
    }

    /**
     * 找出链表的中间结点
     *
     * @param node
     * @return
     */
    public Node findMiddleNode(Node node) {
        if (node == null) {
            return null;
        } else {
            Node fast = node, slow = node;
            while (fast != null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }

    /**
     * 查找链表倒数第k个节点
     *
     * @param node
     * @param index
     * @return
     */
    public Node findLastIndexNode(Node node, int index) {
        if (node == null || index < 1) {
            return null;
        } else {
            int size = getSize(node);
            int count = 0;
            while (count < size - index) {
                node = node.next;
                ++count;
            }
            return node;
        }
    }

    /**
     * 删除倒数第k个结点
     *
     * @param node
     * @param index
     */
    public void deleteByIndexNode(Node node, int index) {
        if (node == null || index < 1) {
            return;
        } else {
            int size = getSize(node);
            int count = 0;
            while (count < size - index - 1) {
                node = node.next;
                ++count;
            }
            node.next = node.next.next;
        }
    }


    /**
     * 删除链表中重复结点
     *
     * @param node
     */
    public void deleteRepeatNode(Node node) {
        if (node == null) {
            return;
        } else {
            while (node.next != null) {
                if (node.data.equals(node.next.data)) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
    }

    /**
     * 删除指定值的节点的后一个节点
     *
     * @param node
     * @param value
     */
    public void deleteByValueNode(Node node, String value) {
        if (node == null || value == null) {
            return;
        } else {
            while (node.next != null && node.data != value) {
                node = node.next;
            }
            node.next = node.next.next;
        }
    }

    /**
     * 删除整个链表
     */
    public void deleteNode() {
        if (head == null) {
            return;
        }
        while (head != null) {
            head = head.next;
        }
    }


    public int getSize(Node node) {
        if (node == null) {
            return 0;
        } else {
            Node temp = node;
            int count = 0;
            while (temp != null) {
                temp = temp.next;
                ++count;
            }
            return count;
        }
    }

    /**
     * 打印链表
     */
    public void print(Node node) {
        if (node == null) {
            System.out.println("链表为空");
            return;
        }
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }


    class Node {
        /**
         * 节点数据
         */
        public String data;
        /**
         * 下一个节点
         */
        public Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}



