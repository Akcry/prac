package BinarySearchTree;

import java.util.Scanner;

public class BST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    
    static Node root;
    
    static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }
        if(key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        
        return root;
    }
    
    static Node delete(Node root, int key) {
        if(root == null) {
            // System.out.println("Your tree is empty connot delete");
            return null;
        }
        if(key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        
        return root;
    }
    
    static int findMin(Node root){
            while(root.left != null) {
                root = root.left;
            }
            
            return root.data;
        }
        
        static int findMax(Node root){
           
            while(root.right != null) {
                root = root.right;
            }
            
            return root.data;
        }
        
        static void inorder(Node root) {
            if(root != null) {
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }
        
        static void preorder(Node root) {
            if(root != null) {
                System.out.print(root.data + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }
        
        static void postorder(Node root) {
            if(root != null) {
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data + " ");
            }
        }
        
        static int height(Node root) {
            if(root == null) {
                return -1;
            }
            
            return 1 + Math.max(height(root.left), height(root.right));
        }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value, choice;
        
        while(true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Inorder");
            System.out.println("4. Preorder");
            System.out.println("5. Postorder");
            System.out.println("6. Height");
            System.out.println("7. Find Minimum");
            System.out.println("8. Find Maximum");
            System.out.println("9. Exit");
            
            System.out.println("Enter choice to perform action: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter element to insert: ");
                    value = sc.nextInt();
                    root = insert(root, value);
                    break;
                    
                case 2:
                    System.out.println("Enter element to Delete: ");
                    value = sc.nextInt();
                    root = delete(root, value);
                    break;
                    
                case 3:
                    inorder(root);
                    break;
                    
                case 4:
                    preorder(root);
                    break;
                    
                case 5:
                    postorder(root);
                    break;
                    
                case 6:
                    int height = height(root);
                    System.out.println("Height of the tree is: " + height);
                    break;
                    
                case 7:
                    int min = findMin(root);
                    System.out.println("Minimum in the tree is: " + min);
                    break;
                    
                case 8:
                    int max = findMax(root);
                    System.out.println("Maximum in the tree is: " + max);
                    break;
                    
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}