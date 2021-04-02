/*************************************************************************
 *  Compilation:  javac MyBST.java
 *  Execution:    java MyBST
 *  Dependencies: StdIn.java StdOut.java Queue.java Stack.java
 *  Example Data file:   easy.txt
 *
 *  % more easy.txt
 *  E A S Y Q U E S T I O N
 *
 *
 *  This class implements a symbol table with a binary search tree and
 *  is  based on BST in algs4.jar. It already contains several important methods.
 *
 *  What you need to do is to implement the following methods, using the ideas
 *  described in class on Tuesday, April 23: (a) indented print and, optionally,
 *  (b) delete.
 *
 *  Below is the current output for the given example:
 *
 *  % java MyBST < easy.txt
 *
 *  **** initial tree *****
 *  keys() based print:
 *  A 1
 *  E 6
 *  I 9
 *  N 11
 *  O 10
 *  Q 4
 *  S 7
 *  T 8
 *  U 5
 *  Y 3
 *  indented print:
 *         To do
 *
 *  Also to do: delete and more testing
 * Luke Watson-Sharer
 * I had a running code but the errors in the API make it unrunable.
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class MyBST<Key extends Comparable<Key>, Value>
        implements Iterable<Key> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return root == null;
    }


    /***********************************************************************
     *  Search BST for given key, and return associated value if found,
     *  return null if not found
     ***********************************************************************/
    // does there exist a key-value pair with given key?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key, or null if no such key exists
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    /***********************************************************************
     *  Insert key-value pair into BST
     *  If key already exists, update with new value
     ***********************************************************************/
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }


    /***********************************************************************
     *  Min, Max: return min or max node
     ***********************************************************************/
    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else
            return min(x.left);
    }

    public Key max() {
        if (isEmpty()) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else
            return max(x.right);
    }


    /***********************************************************************
     *  return an iterable of keys in order
     ***********************************************************************/
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node x, Queue<Key> queue) {
        if (x == null) return;
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

    /*************************************************************************
     *  BST iterator: iterates through the nodes in-order
     *************************************************************************/

    public Iterator<Key> iterator() {
        return new BSTIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class BSTIterator implements Iterator<Key> {

        private Stack<Node> stack = new Stack<Node>();

        public BSTIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node x) {
            Node temp = x;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }
    }

//add timer method

    /*************************************************************************
     *  To do:
     *
     *  use indented print to show the BST structure, as discussed in class
     *   indentedPrint(x.left, depth+1);
     *  E: 6
     *    A: 1
     *    S: 7
     *      Q: 4
     *        I: 9
     *          O: 10
     *            N: 11
     *      Y: 3
     *        U: 5
     *          T: 8
     *
     *************************************************************************/

    public void indentedPrint() {
        if (isEmpty()) {
            System.out.println("an empty tree");
        } else
            indentedPrint(root, 0);
    }

    private void indentedPrint(Node x, int depth) {
        if (x == null) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.print(x.key + ": " + x.val + "\n");

        indentedPrint(x.left, depth + 1);
        indentedPrint(x.right, depth + 1);
    }


    /***********************************************************************
     *  To do:
     *
     *  Delete a specified key. If key does not exist, do nothing. Otherwise,
     *  follow an algorithm described in class.
     ***********************************************************************/

    public void delete(Key key) {
        root = delete(root, key);

    }

    private Node delete(Node x, Key key) {
        StdOut.println("To do: delete");
        return null; //a token return, to be changed
// Could not figure this out :(
    }





    /*****************************************************************************
     *  Main method: demo several important methods
     *****************************************************************************/
    public static void main(String[] args) {
        String l = "EASYQUESTION"; //test string
        MyBST<String, Integer> st = new MyBST<String, Integer>();
        for (int i= 0; i< l.length(); i++){
            st.put(Character.toString(l.charAt(i)), l.indexOf(l.charAt(i)));
        }
        st.indentedPrint(st.root, 0);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println("\n**** initial tree *****");

        StdOut.println("keys() based print:");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));


        StdOut.println("indented print:");
        st.indentedPrint();


        StdOut.println("\nAlso to do: delete and more testing");


    }
}



