import java.util.Scanner;

public class BalanceParenthesis {
    static int top = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an expression to check for balanced parentheses:");
        String str = sc.nextLine();

        char[] stack = new char[str.length()];
        boolean status = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                stack[++top] = ch;
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (top < 0) {
                    status = false;
                    break;
                }

                char last = stack[top--];

                if ((ch == '}' && last != '{') ||
                    (ch == ']' && last != '[') ||
                    (ch == ')' && last != '(')) {
                    status = false;
                    break;
                }
            }
        }

        if (status && top == -1) {
            System.out.println("It is balanced");
        } else {
            System.out.println("It is not balanced");
        }

        sc.close();
    }
}









// ---------------sample input--------------
// Enter an expression to check for balanced parentheses:
// {[(])}


// ---------------output------------
// It is not balanced



// ---------------sample input--------------
// Enter an expression to check for balanced parentheses:
// {[()()]()}



// ---------------output------------
// It is balanced
