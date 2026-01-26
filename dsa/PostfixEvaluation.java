import java.util.Scanner;

public class PostfixEvaluation {
    static int top = -1;

    // Pop method for stack
    public static int pop(int[] stack) {
        return stack[top--];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a valid postfix expression (space separated):");
        String str = sc.nextLine();

        String[] tokens = str.split("\\s+"); // split by space

        int[] stack = new int[tokens.length];

        for (String token : tokens) {
            // If token is a number (multi-digit)
            if (token.matches("\\d+")) {
                stack[++top] = Integer.parseInt(token);
            } else {
                // It's an operator
                int num2 = pop(stack);
                int num1 = pop(stack);
                switch (token) {
                    case "+":
                        stack[++top] = num1 + num2;
                        break;
                    case "-":
                        stack[++top] = num1 - num2;
                        break;
                    case "*":
                        stack[++top] = num1 * num2;
                        break;
                    case "/":
                        stack[++top] = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid operator encountered: " + token);
                        sc.close();
                        return;
                }
            }
        }

        System.out.println("Value of the postfix expression is: " + stack[top]);
        sc.close();
    }
}


// --------------sample input -----------------
// Enter a valid postfix expression (space separated):
// 12 5 3 + 4 - +

// -----------------output ------------------
// Value of the postfix expression is: 16
