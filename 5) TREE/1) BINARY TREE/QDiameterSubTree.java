import java.util.Queue;
import java.util.LinkedList;

public class QDiameterSubTree {
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
                if(idx == nodes.length-1) {
                    idx = -1;
                }
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right) + 1;
    }

    public static int maxDiameter(Node root) {
        if(root == null) {
            return 0;
        }

        int leftDiameter = maxDiameter(root.left);
        int rightDiameter = maxDiameter(root.right);
        int rootDiameter = height(root.left) + height(root.right) + 1;

        return Math.max(Math.max(leftDiameter,rightDiameter),rootDiameter);
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo maxDiameter2(Node root) {
        if(root == null) {
            return new TreeInfo(0,0);
        }

        TreeInfo left = maxDiameter2(root.left);
        TreeInfo right = maxDiameter2(root.right);

        int myHeight = Math.max(left.ht,right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam1,diam2),diam3);

        TreeInfo myInfo = new TreeInfo(myHeight,myDiam);

        return myInfo;
    }

    public static boolean isIdentical(Node root,Node subRoot) {
        if(root == null  &&  subRoot == null) {
            return true;
        }
        if(root == null  || subRoot == null) {
            return false;
        }
        if(root.data == subRoot.data) {
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }
        return false;
    }

    public static boolean isSubtree(Node root,Node subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(root.data == subRoot.data) {
            if(isIdentical(root,subRoot))
                return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
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

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] arr = {2,4,-1,-1,6,-1,-1};
        BinaryTree tree1 = new BinaryTree();
        Node root = tree1.buildTree(nodes);
        BinaryTree tree2 = new BinaryTree();
        Node subRoot = tree2.buildTree(arr);
        System.out.println(maxDiameter(root));
        System.out.println(maxDiameter2(root).diam);
        System.out.println(maxDiameter2(subRoot).diam);
        System.out.println(isSubtree(root,subRoot));
        levelOrder(root);
    }
}
