import java.util.*;

public class Huff {
    String s;

    public static void main(String[] args) {
        ArrayList<Node> frequencyList = new ArrayList<>();
        String s = "shesellsseashells";

        // assigning values to the f node.
        // f.data = x.data + y.data;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            boolean found = false;
            for (Node node : frequencyList){
                if(node.c == currentChar) {
                    found = true;
                    node.data++;
                }
            }
            if (!found){
                Node n = new Node();
                n.data = 1;
                n.c = currentChar;
                frequencyList.add(n);
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<Node> (frequencyList.size(), new MyComparator());
        for (int j = 0; j < frequencyList.size(); j++) {

            q.add(frequencyList.get(j));
        }


        /*for (int j = 0; j < frequencyList.size(); j++) {
            Node n = q.poll();
            System.out.print(n.data + " " + n.c + " -- ");
        }*/




       // to the sum of the frequency of the two nodes
        // Assume 'queue' is your PriorityQueue of Node objects
        while (q.size() > 1) {
            // Remove the two nodes with the smallest frequencies
            Node node1 = q.poll();
            Node node2 = q.poll();

            // Create a new node with these two nodes as children
            Node parentNode = new Node(node1.data + node2.data, '_');
            parentNode.left = node1;
            parentNode.right = node2;

            // Insert the new node back into the queue
            q.add(parentNode);
        }
    BinarySearchTree b = new BinarySearchTree();
        Node nn = q.poll();
        b.root = nn;
        b.showHuff(b.root, "");

        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            System.out.print(b.hash_map.get(currentChar) + " ");
        }
    HashMap<String,Character> rev_map = new HashMap<String, Character>();
        for(char key : b.hash_map.keySet()){
            rev_map.put(b.hash_map.get(key), key);
        }
        String temp = "1100110111001011111100001100110010111";
        String temp2 = "";
        String newstring = "";
        for(int i = 0; i < temp.length(); i ++){
            char currentChar = temp.charAt(i);
            temp2 += currentChar;
            if(rev_map.get(temp2) != null){
                newstring += rev_map.get(temp2);
                temp2 = "";
            }
        }
        System.out.println(newstring);

    }
}
