import java.util.*;
import java.io.*;

public class is_bst {
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

        boolean isBinarySearchTree() {
          // Implement correct algorithm here
          //TEMP TEMP TEMP
          if (nodes == 0) {
        	  return true;
          }
          ArrayList<Integer> results = inOrder();
          int previousNum = results.get(0);
          for (int i = 1; i < results.size(); i++) {
        	  int currentNum = results.get(i);
        	  if (previousNum >= currentNum) {
        		  return false;
        	  }
        	  previousNum = currentNum;
          }
          return true;
        }
        
        //Method 2
        ArrayList<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			inOrderRecursive(0, result);
			return result;
		}
		void inOrderRecursive(int nodeIndex, ArrayList<Integer> result) {
			if (nodeIndex == -1) {
				return;
			}
			inOrderRecursive(tree[nodeIndex].left, result);
			result.add(tree[nodeIndex].key); //visit not print
			inOrderRecursive(tree[nodeIndex].right, result);
		}
        
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
