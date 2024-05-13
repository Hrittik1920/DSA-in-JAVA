// LEXICOGRAPHIC (ASCENDING) - Lesser ASII value element will get priority

public class LongestWordwithAllPrefixes {
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

    public static String ans = "";
    
    public static void longestWord(Node root,StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0;i<26;i++) {
            if(root.childrens[i] != null  && root.childrens[i].eow == true) {
                temp.append((char)(i + 'a'));
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(root.childrens[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
