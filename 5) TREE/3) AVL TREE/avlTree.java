public class avlTree {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int getBalanceFactor(Node root) {
        if(root == null) {
            return 0;
        }
        return (getHeight(root.left) - getHeight(root.right));
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public static Node insert(Node node, int data) {
        if (node == null)
            return (new Node(data));
        if (node.data > data) {
            node.left = insert(node.left, data);
        } else if (node.data < data) {
            node.right = insert(node.right, data);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int bf = getBalanceFactor(node);

        // Left Left Insertion
        if (bf > 1 && data < node.left.data)
            return rightRotate(node);

        // Right Right Insertion
        if (bf < -1 && data > node.right.data)
            return leftRotate(node);

        // Left Right Insertion
        if (bf > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Insertion
        if (bf < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static Node inOrderPredecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        Node ipre;
        if (root == null) {
            return null;
        }
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else { // node is found
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            ipre = inOrderPredecessor(root);
            root.data = ipre.data;
            root.left = delete(root.left, ipre.data);
        }
        return root;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        } else {
            System.out.print("-1 ");
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 1);
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 6);
        root = insert(root, 5);
        root = insert(root, 5);
        root = insert(root, 7);
        root = insert(root, 8);
        root = insert(root, 8);
        root = insert(root, 10);
        root = insert(root, 17);
        root = insert(root, 15);
        root = insert(root, 11);
        root = insert(root, 13);

        root = delete(root, 7);
        root = delete(root, 1);

        preOrder(root);
    }
}
