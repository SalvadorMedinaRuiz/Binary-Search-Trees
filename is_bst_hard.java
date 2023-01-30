import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }
        ///////////////////////////////////////////////////
        boolean isBST()
        {
        	if (nodes == 0) {
        		return true;
        	}
            return isBSTUtil(tree[0], Integer.MIN_VALUE,
                             Integer.MAX_VALUE);
        }
     
        boolean isBSTUtil(Node node, long min, long max)
        {
            if (node == null)
                return true;
            if (node.key < min || node.key > max)
                return false;
            if (node.left != -1 && node.right == -1) {
            	return isBSTUtil(tree[node.left], min, node.key - 1);
  			}
            else if (node.right != -1 && node.left == -1) {
            	return isBSTUtil(tree[node.right], node.key, max);
            }
            else if (node.left == -1 && node.right == -1) {
            	return true;
            }
            return (
                isBSTUtil(tree[node.left], min, node.key - 1) //node.left passes over tree[#].left, which is an integer and does not work because isBSTUtil only accepts the node. Same as below but with right.
                	&& isBSTUtil(tree[node.right], node.key, max));
        }
        ///////////////////////////////////////////////////
      }
  		

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBST()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
