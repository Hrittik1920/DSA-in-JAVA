public class startWithProblem {
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

    public static boolean search(String word) { // O(L) -- L => Length of String
        Node node = root;

        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(node.childrens[idx] == null) {
                return false;
            }
            if(i == word.length()-1  && node.childrens[idx].eow == false) {
                return false;
            }

            node = node.childrens[idx];
        }

        return true;
    }

    public static boolean startWith(String word) {
        Node curr = root;

        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.childrens[idx] == null) {
                return false;
            }

            curr = curr.childrens[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        String words[] = {"apple","app","mango","man","woman"};
        String prefix = "app";
        for(int i=0;i<words.length;i++) {
            insert(words[i]);
        }
        System.out.println(search("apple"));

        System.out.println(startWith(prefix));
    }
}

