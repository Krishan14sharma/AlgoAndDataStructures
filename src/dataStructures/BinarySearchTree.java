package dataStructures;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by krishan on 05/04/18.
 */
public class BinarySearchTree {


    Node root = null;
    private int size = 0;
    private static int index = 0;

    public void addNode(int data) {
        size++;
        if (root == null) {
            root = new Node(data);
            return;
        }
        addNode(data, root);
    }

    private void addNode(int data, Node node) {
        if (data > node.data) {
            if (node.rightNode != null) {
                addNode(data, node.rightNode);
            } else {
                node.rightNode = new Node(data);
            }
        } else if (data < node.data) {
            if (node.leftNode != null) {
                addNode(data, node.leftNode);
            } else {
                node.leftNode = new Node(data);
            }
        } else {
            size--; // not adding same data nodes
        }
    }

    public Node find(final int num) {
        if (root == null) {
            return null;
        }
        return find(num, root);
    }

    private Node find(final int num, Node node) {
        if (node == null || node.data == num) {
            return node;
        }
        if (node.data > num) {
            return find(num, node.leftNode);
        } else {
            return find(num, node.rightNode);
        }
    }


    public void delete(int num) {
        if (root == null) {
            return;
        }
        delete(num, root);
    }

    private Node delete(int num, Node node) {
        if (node == null) {
            return null;
        }
        if (num > node.data) {
            node.rightNode = delete(num, node.rightNode);
        } else if (num < node.data) {
            node.leftNode = delete(num, node.leftNode);
        } else {
            if (node.leftNode == null) {
                return node.rightNode;
            } else if (node.rightNode == null) {
                return node.leftNode;
            } else {
                int data = findMinOnRightNode(node).data;
                node.data = data;
                node.rightNode = delete(4, node);
            }
        }
        return node;
    }

    private Node findMinOnRightNode(final Node node) {
        Node temp = node;
        Node val = null;
        while (temp != null) {
            val = temp;
            temp = temp.rightNode;
        }
        return val;
    }

    @NotNull
    public Integer[] getInOrder() {
        Integer[] inorder = new Integer[size];
        index = 0;
        inorder(root, inorder);
        return inorder;
    }

    private void inorder(Node node, Integer[] inorder) {
        if (node == null) {
            return;
        }
        inorder(node.leftNode, inorder);
        inorder[index++] = node.data;
        inorder(node.rightNode, inorder);
    }

    @NotNull
    public Integer[] getPreOrder() {
        Integer[] arr = new Integer[size];
        index = 0;
        preOrder(root, arr);
        return arr;
    }

    private void preOrder(Node node, Integer[] arr) {
        if (node == null) {
            return;
        }
        arr[index++] = node.data;
        preOrder(node.leftNode, arr);
        preOrder(node.rightNode, arr);
    }


    @NotNull
    public Integer[] getPostOrder() {
        Integer[] arr = new Integer[size];
        index = 0;
        postOrder(root, arr);
        return arr;
    }

    private void postOrder(Node node, Integer[] arr) {
        if (node == null) {
            return;
        }
        postOrder(node.leftNode, arr);
        postOrder(node.rightNode, arr);
        arr[index++] = node.data;
    }

    @NotNull
    public Integer[] getLevelOrder() {
        Integer[] arr = new Integer[size];
        index = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            arr[index++] = poll.data;
            if (poll.leftNode != null) {
                queue.add(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.add(poll.rightNode);
            }
        }
        return arr;
    }

    public int getHeightOfTree() {
        return heightOfTree(root);
    }

    private int heightOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        return (Math.max(heightOfTree(node.leftNode), heightOfTree(node.rightNode)) + 1);
    }

    @NotNull
    public int sizeOfTree() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.leftNode) + size(node.rightNode) + 1;
    }
}

