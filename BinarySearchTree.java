import java.util.*;

class BinarySearchTree {
    // Root of Binary Tree
    Node root;
    String s = "shesellseashells";
    HashMap<Character, String> hash_map = new HashMap<Character, String>();

    // Constructors
    BinarySearchTree(int key) {
        root = new Node(key);
    }


    BinarySearchTree() {
        root = null;
    }

    public void insert(Node node, int data) {
        if (node.getLeft() == null) {
            Node temp = new Node(data);
            node.left = temp;
        }
        else if (node.getLeft().getData() > data) {
            insert(node.left, data);
        }
        else if (node.getRight() == null) {
            Node temp = new Node(data);
            node.right = temp;
        }
        else if (node.getRight().getData() < data) {
            insert(node.right, data);
        }
    }

    public boolean find(Node node, int value) {
        if (node.getLeft().getData() == value) {
            return true;
        }
        else if (node.getLeft().getData() > value) {
            find(node.left, value);
        }
        else if (node.getRight().getData() == value) {
            return true;
        }
        else if (node.getRight().getData() < value) {
            find(node.right, value);
        }
        /*} else if (node.getRight().getData() <= value) {
            if (node.getRight() == null) {
                Node temp = new Node(value);
                node.right = temp;
                return true;
            }
        }
        if (node.getLeft().getData() == value) {
            return true;
        } else if (node.getRight().getData() == value) {
            return true;
        } else {
            find(node, value);
        }*/
        return false;
    }

    public void showValues(Node node){
        int value = node.getData();
        // hash_map.put(node.c,s);
        if(node.getLeft() != null){
            System.out.println("Parent: " + value);
            System.out.println("Left " + node.getLeft().getData());
            showValues(node.left);
        }
        if(node.getRight() != null){
            System.out.println("Parent: " + value);
            System.out.println("Right " + node.getRight().getData());
            showValues(node.right);
        }
    }

    public void showHuff(Node node, String s){
        int value = node.getData();
        if(node.getLeft() == null && node.getRight() == null){
            hash_map.put(node.c,s);
            System.out.println(node.c + ":" + s);
        }
         if(node.getLeft() != null){
            showHuff(node.left, s + "0");
        }
         if(node.getRight() != null){
            showHuff(node.right, s + "1");
        }
    }



    /*public boolean find(int value){

    }*/
}
