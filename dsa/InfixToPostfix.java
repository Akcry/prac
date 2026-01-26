import java.util.*;

public class InfixToPostfix {

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
                
            case '^':
                return 3;
        }
        return -1;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ')
                continue;

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression:");
        String infix = sc.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}

// --------------- sample input ------------
// Enter an infix expression:
// a+b*(c^d-e)^(f+g*h)-i

// --------------- output --------------
// Postfix expression: abcd^e-fgh*+^*+i-