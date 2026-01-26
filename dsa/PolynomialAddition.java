
import java.util.Scanner;

public class PolynomialAddition {

    // Node for polynomial term
    static class PolyNode {
        int coeff, pow;
        PolyNode next;

        PolyNode(int c, int p) {
            coeff = c;
            pow = p;
            next = null;
        }
    }

    // Polynomial represented as linked list
    static class PolynomialList {
        PolyNode head = null;

        // Insert term in decreasing power order
        void insertTerm(int coeff, int pow) {
            if (coeff == 0)
                return;

            PolyNode newNode = new PolyNode(coeff, pow);

            if (head == null || head.pow < pow) {
                newNode.next = head;
                head = newNode;
                return;
            }

            PolyNode temp = head;
            while (temp.next != null && temp.next.pow > pow)
                temp = temp.next;

            if (temp.next != null && temp.next.pow == pow) {
                temp.next.coeff += coeff;
                if (temp.next.coeff == 0)
                    temp.next = temp.next.next; // remove zero term
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

        // Input polynomial from user
        void inputPolynomial() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of terms: ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("Term " + i + ":");
                System.out.print("Coefficient: ");
                int c = sc.nextInt();
                System.out.print("Power: ");
                int p = sc.nextInt();
                insertTerm(c, p);
            }
        }

        // Display polynomial
        void display() {
            if (head == null) {
                System.out.println("Polynomial is empty.");
                return;
            }
            PolyNode temp = head;
            while (temp != null) {
                System.out.print(temp.coeff + "x^" + temp.pow);
                temp = temp.next;
                if (temp != null)
                    System.out.print(" + ");
            }
            System.out.println();
        }

        // Add two polynomials
        static PolynomialList add(PolynomialList p1, PolynomialList p2) {
            PolynomialList result = new PolynomialList();
            PolyNode a = p1.head;
            PolyNode b = p2.head;

            while (a != null && b != null) {
                if (a.pow == b.pow) {
                    result.insertTerm(a.coeff + b.coeff, a.pow);
                    a = a.next;
                    b = b.next;
                } else if (a.pow > b.pow) {
                    result.insertTerm(a.coeff, a.pow);
                    a = a.next;
                } else {
                    result.insertTerm(b.coeff, b.pow);
                    b = b.next;
                }
            }

            while (a != null) {
                result.insertTerm(a.coeff, a.pow);
                a = a.next;
            }

            while (b != null) {
                result.insertTerm(b.coeff, b.pow);
                b = b.next;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PolynomialList P1 = new PolynomialList();
        PolynomialList P2 = new PolynomialList();
        PolynomialList P3 = null;

        while (true) {
            System.out.println("\n--- POLYNOMIAL MENU ---");
            System.out.println("1. Enter Polynomial 1");
            System.out.println("2. Enter Polynomial 2");
            System.out.println("3. Display Polynomials");
            System.out.println("4. Add Polynomials");
            System.out.println("5. Display Resultant Polynomial");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter Polynomial 1:");
                    P1 = new PolynomialList();
                    P1.inputPolynomial();
                    break;
                case 2:
                    System.out.println("Enter Polynomial 2:");
                    P2 = new PolynomialList();
                    P2.inputPolynomial();
                    break;
                case 3:
                    System.out.println("Polynomial 1:");
                    P1.display();
                    System.out.println("Polynomial 2:");
                    P2.display();
                    break;
                case 4:
                    System.out.println("Adding Polynomials...");
                    P3 = PolynomialList.add(P1, P2);
                    System.out.println("Addition Complete!");
                    break;
                case 5:
                    System.out.println("Result Polynomial:");
                    if (P3 == null)
                        System.out.println("No result yet. Please add polynomials first.");
                    else
                        P3.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


// ----------------sample input -------------

// 1
// Enter Polynomial 1:
// Enter number of terms: 3
// Term 1:
// Coefficient: 5
// Power: 3
// Term 2:
// Coefficient: 4
// Power: 1
// Term 3:
// Coefficient: 2
// Power: 0

// 2
// Enter Polynomial 2:
// Enter number of terms: 3
// Term 1:
// Coefficient: 3
// Power: 3
// Term 2:
// Coefficient: -4
// Power: 1
// Term 3:
// Coefficient: 7
// Power: 0

// 3
// Polynomial 1:
// 5x^3 + 4x^1 + 2x^0
// Polynomial 2:
// 3x^3 + -4x^1 + 7x^0
