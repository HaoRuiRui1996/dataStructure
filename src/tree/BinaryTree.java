package tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {

    private Node root;

    /**
     *       A
     *   B       C
     * D   E    F    G
     */
    public BinaryTree() {
        root = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        root.setLeftNode(nodeB);
        root.setRightNode(nodeC);
        nodeB.setLeftNode(nodeD);
        nodeB.setRightNode(nodeE);

        nodeC.setLeftNode(nodeF);
        nodeC.setRightNode(nodeG);
    }

    /**
     * A
     * B
     * D
     * E
     * C
     * F
     * G
     *
     * @param node
     */
    public void preOrderTravelal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTravelal(node.leftNode);
        preOrderTravelal(node.rightNode);
    }

    /**
     * root-->left-->right
     *
     * @param node
     */
    public void preOrderNonRecursive(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.println(node.data);
                if (node.rightNode != null) {
                    stack.push(node.rightNode);
                }
                node = node.leftNode;
            } else {
                node = stack.pop();
            }
        }
    }

    /**
     * D
     * B
     * E
     * A
     * F
     * C
     * G
     *
     * @param node
     */
    public void inOrderTravelal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTravelal(node.leftNode);
        System.out.println(node.data);
        inOrderTravelal(node.rightNode);
    }

    public void inOrderNonRecursive(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        //之前访问的left节点记录，防止重复遍历导致死循环
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            } else {
                node = stack.pop();
                System.out.println(node.data);
                node = node.getRightNode();
            }
        }
    }

    /**
     * D
     * E
     * B
     * F
     * G
     * C
     * A
     *
     * @param node
     */
    public void postOrderTravelal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTravelal(node.leftNode);
        postOrderTravelal(node.rightNode);
        System.out.println(node.data);
    }

    //利用二叉树存储的特性大小顺序加历史节点进行判断
    public void postOrderNonRecursive(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node visited = null;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                node = stack.pop();
                //递归写的时候，出栈的时候根据栈信息来判断是否遍历右子树还是打印
                //非递归需要区分这一点，这里根据历史访问节点进行区分
                if (node.rightNode != null && visited != node.rightNode) {
                    stack.push(node);
                    node = node.rightNode;
                } else {
                    visited = node;
                    System.out.println(node.data);
                    node = null;
                }
            }
        }
    }

    public void levelTravelal(Node node) throws InterruptedException {
        if (node == null) {
            return;
        }

        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.put(node);

        while (node != null) {

        }
        while (queue.size() != 0) {
            node = queue.poll();
            System.out.println(node.data);
            if (node.leftNode != null) {
                queue.put(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.put(node.rightNode);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BinaryTree tree = new BinaryTree();
        tree.levelTravelal(tree.root);
    }


    class Node<T> implements Comparable{

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node leftNode, Node rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        private T data;
        private Node leftNode;
        private Node rightNode;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            Node anotherNode = (Node) o;
            if (anotherNode.data instanceof String) {
                return ((String) this.data).compareTo((String) anotherNode.data);
            }
            return 0;
        }
    }
}

