
import sun.applet.Main;

class Node {
    int key, height;
    Node left, right;
    Node(int d) {
        key = d;
        height = 1;
    }
}
class AVLTree {
    Node root;
    //tree'nin height'ini almak için metod
    int height (Node N) {
        if(N == null) {
            return 0;
        }
        return N.height;
    }
    //iki integer arsından maximumu dönmesi için metod
    int max(int a, int b){
        return(a > b) ? a : b;
    }
    //right rotate
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        //perform rotation
        x.right = y;
        y.left = T2;
        //heightleri güncelleriz
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        
        //return new root
        
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        
        //perform rotation
        
        y.left = x;
        x.right = T2;
        
        x.height = max(height(x.right), height(x.left)) + 1;
        y.height = max(height(y.right), height(y.left)) + 1;
        
        return y;
    }
    //get balance factor of node N
    int getBalance(Node N) {
        if(N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    
    Node insert(Node node, int key) {
        //1.perform the normal BST insertion
        if(node == null)
            return(new Node(key));
        if(key < node.key)
            node.left = insert(node.left, key);
        else if(key > node.key)
            node.right = insert(node.right, key);
        else 
            return node;
        
        //2. update height of this ancestor node
        
        node.height = 1 + max(height(node.left), height(node.right));
        
        
        //3.Get the balance factor of this ancestor node to check whether this node became unbalanced
        
        int balance = getBalance(node);
        //solun heighti sağdan fazla
        //left left case
        if(balance > 1 && key < node.left.key)
            return rightRotate(node);
        //solun heighti sağdan az
        //right right case
        if(balance < -1 && key > node.right.key)
            return leftRotate(node);
        //left right case
        if(balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //right left case
        if(balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
            
        }
    }
    Node minValueNode(Node node) {
        
        Node current = node;
        while(current.left != null) {
            current = current.left;
        }
        return current;
            
    }
    
    Node deleteNode(Node root, int key) {
        if(root == null) 
            return null;
        if(key < root.key){
            root.left = deleteNode(root.right, key);
        }
        else if(key > root.key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            //node with only one child or no child
            if((root.left == null) || (root.right == null)) {
                Node temp = null;
                if(temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
             // no child
            if(temp == null){
                temp = root;
                root = null;
            }
            else // one child
                root = temp; //copy the contents of the non-empty child
            }
            else {
                //node with two children
                //successor = summalest in the right subtree
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }
        
        if(root == null)
            return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        //left left case
        if(balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        //left right case
        if(balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //right right case
        if(balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        //right left case
        if(balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        
        return root;
    }
    
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 9);  
        tree.root = tree.insert(tree.root, 5);  
        tree.root = tree.insert(tree.root, 10);  
        tree.root = tree.insert(tree.root, 0);  
        tree.root = tree.insert(tree.root, 6);  
        tree.root = tree.insert(tree.root, 11);  
        tree.root = tree.insert(tree.root, -1);  
        tree.root = tree.insert(tree.root, 1);  
        tree.root = tree.insert(tree.root, 2);  
        
        System.out.println("Preorder traversal of contrducted tree is:");
        tree.preOrder(tree.root);
        
        tree.root = tree.deleteNode(tree.root, 10);
        System.out.println("Preorder traversal of contrducted tree is:");
        tree.preOrder(tree.root);
      
    }
}
