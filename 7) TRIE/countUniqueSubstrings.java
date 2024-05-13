public class countUniqueSubstrings {
    static class Node {
        Node[] childrens;
        boolean eow; //endofword

        public Node() {
            childrens = new Node[26]; //alphabets(a to z)
            for(int i=0;i<26;i++) { 
                childrens[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) { // O(L) -- L => Length of String

        Node node = root;

        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(node.childrens[idx] == null) {
                // add new node
                node.childrens[idx] = new Node();
            }
            if(i == word.length()-1) {
                node.childrens[idx].eow = true;
            }

            node = node.childrens[idx];
        }
    }

    public static int countNode(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;

        for(int i=0;i<26;i++) {
            if(root.childrens[i] != null) {
                count += countNode(root.childrens[i]);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String str = "apple";

        for(int i=0;i<str.length();i++) {
            insert(str.substring(i));
        }

        System.out.println(countNode(root));
    }
}
