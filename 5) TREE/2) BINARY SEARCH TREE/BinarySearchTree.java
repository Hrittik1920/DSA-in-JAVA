import java.util.ArrayList;

public class BinarySearchTree {
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

    public static void inOrder(Node root) {
        if(root == null)
            return;
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if(root == null) 
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static Node prev;
    static Node rec;

    public static boolean isBST(Node root) {
        if(root != null) {
            if(!isBST(root.left))
                return false;
            if(prev!=null  &&  root.data <= prev.data)
                return false;
            prev = root;
            return isBST(root.right);
        } else {
            return true;
        }
    }

    public static boolean searchElementinBST(Node root,int data) {
    
        while(root != null) {
            if(root.data == data) {
                return true;
            } 
            else if(data < root.data) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return false;
    }

    public static boolean searchElementinBSTRec(Node root,int data) {
        if(root == null)
            return false;
        if(root.data == data) {
            return true;
        } else if(data < root.data) {
            return searchElementinBSTRec(root.left, data);
        } else {
            return searchElementinBSTRec(root.right, data);
        }
    }

    public static Node insert(Node root,int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(val < root.data) {
            root.left = insert(root.left, val);
        } else if(val > root.data) {
            root.right = insert(root.right,val);
        } else {
            System.out.println("Can't Insert! Element " + val + " is already present in BST");
        }
        return root;
    }

    public static void insertItre(Node root,int val) {
        rec = null;
        while(root != null) {
            rec = root;
            if(root.data == val) {
                System.out.println("Can't Insert! Element " + val + " is already present in BST");
            } else if(val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if(rec == null) {
            return;
        }
        if(val < rec.data) {
            rec.left = new Node(val);
        } else {
            rec.right = new Node(val);
        }
    }

    public static Node inOrderPredecessor(Node root) {
        root = root.left;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public static Node delete(Node root,int val) {
        Node ipre;
        if(root == null) {
            return null;
        }
        if(root.left == null &&  root.right == null) {
            return null;
        }

        //Search for the node to be deleted
        if(val < root.data) {
            root.left = delete(root.left, val);
        } else if(val > root.data) {
            root.right = delete(root.right,val);
        }

        //Delete strategy when the node is found
        else {
            ipre = inOrderPredecessor(root);
            root.data = ipre.data;
            root.left = delete(root.left, ipre.data);
        }
        
        return root;
    }

    public static void printInRange(Node root,int X,int Y) {
        if(root == null) {
            return;
        }
        if(root.data >= X  &&  root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y) {
            printInRange(root.left, X, Y);
        }
        else 
            printInRange(root.right, X, Y);
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0;i<path.size();i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.print("NULL\n");
    }

    public static void printRoot2Leaf(Node root,ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);

        //Leaf
        if(root.left == null  &&  root.right == null) {
            printPath(path);
        } else { //non leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<values.length;i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        root = insert(root, 1);
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        System.out.println(isBST(root));
        System.out.println(searchElementinBST(root, 5));
        insert(root, 5);
        inOrder(root);
        System.out.println();
        delete(root,3);
        inOrder(root);
        System.out.println();
        printInRange(root, 2,6);
        System.out.println();
        int[] arr = {8,5,3,6,10,11,14};
        Node root2 = null;
        
        for(int i=0;i<arr.length;i++) {
            root2 = insert(root2, arr[i]);
        }
        inOrder(root2);
        System.out.println();
        ArrayList<Integer> path = new ArrayList<>();
        printRoot2Leaf(root2, path);
    }
}
