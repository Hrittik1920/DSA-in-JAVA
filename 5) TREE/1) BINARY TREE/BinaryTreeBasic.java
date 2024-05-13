import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* BASIC
1) BinaryTree  implementation
2) PreOrder ArrayList to Tree
3) Tree to PreOrder ArrayList
4) TRAVERSALS (PreOrder,InOrder,PostOrder,LevelOrder)
5) CountNode,SumNodes,Height */

public class BinaryTreeBasic {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static void preOrder(Node root) {
        if(root == null) {
            list.add(-1);
            System.out.print(-1 + " ");
            return;
        }
        list.add(root.data);
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNode(Node root) {
        if(root == null) {
            return 0;
        }

        int left = countNode(root.left);
        int right = countNode(root.right);

        return left + right + 1;
    }

    public static int SumNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int left = SumNodes(root.left);
        int right = SumNodes(root.right);

        return left + right + root.data;
    }

    public static int Height(Node root) {
        if(root == null) {
            return 0;
        }

        int left = Height(root.left);
        int right = Height(root.right);

        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preOrder(root);
        System.out.println();
        System.out.println(list);
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(countNode(root));
        System.out.println(SumNodes(root));
        System.out.println(Height(root));
    }
}