package com.CS201;
import java.util.Scanner;
import java.util.ArrayList;

public class project_main {
    public static void main(String [] args) {
        // Call the MainMenu upon startup
        MainMenu(null);
        }
    public static void MainMenu(BinarySearchTree bst) {
        // Create new default tree
        if (bst == null) {
            bst = new BinarySearchTree();
        }
        // Main options
        System.out.println("Welcome! Please select an option:\n1. Create a binary search tree\n" +
                "2. Add a node\n" +
                "3. Delete a node\n" +
                "4. Print nodes by InOrder\n" +
                "5. Print nodes by PreOrder\n" +
                "6. Print nodes by PostOrder\n" +
                "7. Exit program");
        // Actual menu and prompts with references to sub scripts
        while (true) {
            Scanner welcome = new Scanner(System.in);
            int holdWelcome = welcome.nextInt();
            switch (holdWelcome){
                case (1): makeATree(bst);
                case (2): addNode(bst);
                case (3): deleteNode(bst);
                case (4): printInorder(bst);
                case (5): printPreorder(bst);
                case (6): printPostorder(bst);
                case (7): System.exit(0);
                default: main(null);

            }
        }
    }
    //Option 1 Make a new BST
    public static void makeATree(BinarySearchTree bst) {
        //Create defaults for use
        Scanner userInput = new Scanner(System.in);
        ArrayList<Integer> newUserInput = new ArrayList<Integer>();
        System.out.println("Please list your data: (Numbers only, use comma list (3, 2, 5, ...); AA to exit to main menu");
        // Will catch any exceptions in the code
        try {
            String value = userInput.nextLine();
            // Accepts a specific string and splits it into an array for easy looping
            String[] valueArray = value.split(", ");
            //Loops through the array and converts the strings to ints
            for (String s : valueArray) {
                int hold = Integer.parseInt(s);
                newUserInput.add(hold);
            }
            System.out.println("Saving Results! One Moment!");
            // Loops through the input array
            for (int hold : newUserInput) {
                // Creates a base BST
                bst.insert(hold);
            }
            System.out.println("Balancing BST!");
            // Balances the BST afterwards
            bst.balanceBST();
            //back to main menu
            System.out.println("Returning to Main Menu");
            System.out.println(" ");
            MainMenu(bst);
            // if anything else is inputted
        } catch (Exception e) {
            // Exit phrase to get out quick
            if (userInput.nextLine().equals("AA") || userInput.nextLine().equals("aa")) {
                System.out.println("Returning to Main Menu");
                System.out.println(" ");
                MainMenu(bst);
            }
            // Returns to the top of the addNode script
            System.out.println("Only numbers, try again");
            makeATree(bst);
        }
    }

    // Option 2 adds a new node to the bst
    public static void addNode(BinarySearchTree bst) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the new value? (Only numbers; AA to exit to menu)");
        try {
            int value = userInput.nextInt();
            // Inserts the new node
            bst.insert(value);
            System.out.println("Balancing BST!");
            // Re-balances the BST afterwards
            bst.balanceBST();
            // Returns to the main menu
            System.out.println("Returning to Main Menu");
            System.out.println(" ");
            MainMenu(bst);
            //everything else
        } catch (Exception e){
            //exit phrase
            if (userInput.nextLine().equals("AA") || userInput.nextLine().equals("aa")){
                System.out.println("Returning to Main Menu");
                System.out.println(" ");
                MainMenu(bst);
                // returns to the top of the script
            } else{
            System.out.println("Only numbers, try again");
            addNode(bst);
            }
        }
    }

    // Option 3 deletes nodes
    public static void deleteNode(BinarySearchTree bst) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Which value would you like to delete? (Only numbers; AA to exit to menu)");
        try {
            int value = userInput.nextInt();
            // calls the delete method to delete the inserted value
            bst.delete(value);
            // back to main menu
            System.out.println("Returning to Main Menu");
            System.out.println(" ");
            MainMenu(bst);
            //everything else
        } catch (Exception e){
            if (userInput.nextLine().equals("AA") || userInput.nextLine().equals("aa")){
                System.out.println("Returning to Main Menu");
                System.out.println(" ");
                MainMenu(bst);
            } else {
                System.out.println("This value does not exist! Try again: ");
                deleteNode(bst);
            }
        }
    }

//    Option 4 print the bst Inorder
    public static void printInorder(BinarySearchTree bst){
        System.out.print("Your Inorder BST contains: ");
        bst.inOrder();
        System.out.println(" ");
        System.out.println("Returning to Main Menu");
        System.out.println(" ");
        MainMenu(bst);
    }

    // Option 5 print the bst Preorder
    public static void printPreorder(BinarySearchTree bst){
        System.out.print("Your Preorder BST contains: ");
        bst.preOrder();
        System.out.println(" ");
        System.out.println("Returning to Main Menu");
        System.out.println(" ");
        MainMenu(bst);
    }

    // Option 6 print hte bst Postorder
    public static void printPostorder(BinarySearchTree bst){
        System.out.print("Your Postorder BST contains: ");
        bst.postOrder();
        System.out.println(" ");
        System.out.println("Returning to Main Menu");
        System.out.println(" ");
        MainMenu(bst);
    }
}
