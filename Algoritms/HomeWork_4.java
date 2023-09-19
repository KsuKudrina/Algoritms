package Algoritms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class BinaryTree{
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        Color color;
        // color
    }

    public boolean insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        }else{
            boolean result = insert(root, value);
            root = Rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
        
        
    }

    private boolean insert(Node node, int value){
        if(node.value == value){
            return false;
        }else{
            if(node.value < value){
                if(node.right != null){
                    boolean result = insert(node.right, value);
                    node.right = Rebalance(node.right);
                    return result;
                }else{
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                    return true;
                }
            }else{
                if(node.left != null){
                    boolean result = insert(node.left, value);
                    node.left = Rebalance(node.left);
                    return result;
                }else{
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                    return true;
                }
            }
        }
    }

    public boolean find(int value){
        return find(root, value);
    }

    private boolean find(Node node, int value){
        if(node == null){
            return false;
        }
        if(node.value == value){
            return true;
        }

        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }
    
    private Node Rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED && 
                   (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightRurn(result);
            }
            if (result.left != null && result.left.color == Color.RED && 
                    result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = leftRurn(result);  
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED){
                needRebalance = true;
                colorChange(result);
            }
        }
        while(needRebalance);
        return result;
    }

    private enum Color{
        RED, BLACK
    }
    
    private Node leftRurn(Node node){
        Node left = node.left;
        Node temp = left.right;
        left.right = node;
        node.left = temp;
        node.color = Color.RED;
        return left;
    }

    private Node rightRurn(Node node){
        Node right = node.right;
        Node temp = right.left;
        right.left = node;
        node.right = temp;
        node.color = Color.RED;
        return right;
    }

    private void colorChange(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }
}

public class HomeWork_4 {
     public static void main(String[] args) {

        final BinaryTree tree = new BinaryTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.insert(value);
                    System.out.println("------");
                } catch (Exception ignored) {
                    
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        // tree.insert(5);
        // tree.insert(3);
        // tree.insert(4);
        // tree.insert(1);
        // tree.insert(2);
        // tree.insert(7);
        // tree.insert(8);
        // tree.insert(6);

        // System.out.println(tree.find(7));
        // System.out.println(tree.find(9));

    }
}
