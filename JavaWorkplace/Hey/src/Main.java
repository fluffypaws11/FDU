/**
 * File name: Assignment4YingyanDu
 * purpose for file: Java code for BST
 */

/**
 * @author Yingyan_Du
 * Email: fluffypaws2096066@gmail.com
 */
import java.util.Scanner;
import java.util.Random;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // 添加这一行
        BinarySearchTree bst = new BinarySearchTree();
        int[] randomArray = new int[10];

        while (true) {
            System.out.println("---- menu");
            System.out.println("1. Generate a random integer array");
            System.out.println("2. Display the integer array");
            System.out.println("3. Build a Binary Search Tree");
            System.out.println("4. Inorder traversal on the BST");
            System.out.println("5. Preorder traversal on the BST");
            System.out.println("6. Postorder traversal on the BST");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    randomArray = generateRandomArray(10);
                    scanner.nextLine(); // 清除回车符
                    displayArray(randomArray); // 显示生成的数组
                    break;

                case 2:
                    displayArray(randomArray);
                    break;

                case 3:
                    for (int num : randomArray) {
                        bst.insert(num);
                    }
                    System.out.println("BST built successfully.");
                    break;

                case 4:
                    System.out.print("Inorder Traversal: ");
                    bst.inorderTraversal(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder Traversal: ");
                    bst.preorderTraversal(bst.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder Traversal: ");
                    bst.postorderTraversal(bst.root);
                    System.out.println();
                    break;

                case 7:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(100);
        }

        System.out.println("Random integer array generated.");
        return randomArray;
    }

    public static void displayArray(int[] arr) {
        System.out.print("Integer Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

