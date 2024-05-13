import java.util.Stack;

public class StackQuestions {
    public static void pushAtBottom(int element,Stack<Integer> s) {
        if(s.isEmpty()) {
            s.push(element);
            return;
        }
        int top = s.pop();
        pushAtBottom(element,s);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(top, s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        pushAtBottom(5, s);
        reverseStack(s);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
