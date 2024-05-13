public class WordBreakProblem {
    static class Node {
        Node[] childrens;
        boolean eow; // EndofWord

        public Node() {
            childrens = new Node[26]; // a to z
            for(int i=0;i<26;i++) {
                childrens[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.childrens[idx] == null) {
                curr.childrens[idx] = new Node();
            }

            if(i == word.length()-1) {
                curr.childrens[idx].eow = true;
            }

            curr = curr.childrens[idx];
        }
    }

    public static boolean search(String word) {
        Node curr = root;

        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.childrens[idx] == null) {
                return false;
            }

            if(i == word.length()-1  &&  curr.childrens[idx].eow == false) {
                return false;
            }

            curr = curr.childrens[idx];
        }
        return true;
    }

    public static boolean wordBreak(String word) {
        if(word.length() == 0) {
            return true;
        }

        for(int i=1;i<=word.length();i++) {
            String firstPart = word.substring(0,i);
            String secondPart = word.substring(i);

            if(search(firstPart)  &&  wordBreak(secondPart)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i","like","sam","samsung","mobile","ice"};
        String key = "ilikesung";
        for(int i=0;i<words.length;i++) {
            insert(words[i]);
        }
        System.out.println(wordBreak(key));
    }
}
