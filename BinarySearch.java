public class BinarySearch {

	

    public class Node {

        int key;

        Node left, right;

 

        public Node(int item) {

            key = item;

            left = right = null;

        }

        public String toString() {



    		return " " + key;

		



    	}

    }



    private Node root;

    

 

   public BinarySearch() { 

	   root = null; 

    }

 

    

    public void add(int key) {

       root = adding(root, key);

    }

     

   

    public Node adding(Node root, int key) {

       Node newNode = new Node(key);

        

        if (root == null) {

            root = newNode;

            return root;

        }

 

        

        if (key < root.key)

            root.left = adding(root.left, key);

        else if (key > root.key)

            root.right = adding(root.right, key);

 

        

        return root;

    }

 

   

   

    public void preorderTraverseTree(Node focusNode) {



		if (focusNode != null) {



			System.out.println(focusNode);



			preorderTraverseTree(focusNode.left);

			preorderTraverseTree(focusNode.right);



		}



	}

   public void deleteKey(int key)

    {

        root = deleteRec(root, key);

    }

 

    

   public  Node deleteRec(Node root, int key)

    {

       

        if (root == null)  return root;

 

        if (key < root.key)

            root.left = deleteRec(root.left, key);

        else if (key > root.key)

            root.right = deleteRec(root.right, key);

 

        

        else

        {

         

            if (root.left == null)

                return root.right;

            else if (root.right == null)

                return root.left;

 

           

            root.key = minValue(root.right);

 

            

            root.right = deleteRec(root.right, root.key);

        }

 

        return root;

    }

    public int minValue(Node root)

    {

        int minv = root.key;

        while (root.left != null)

        {

            minv = root.left.key;

            root = root.left;

        }

        return minv;

    }

    public Node findNode(int key) {

		Node focusNode = root;

		while (focusNode.key != key) {



			if (key < focusNode.key) {

				focusNode = focusNode.left;

			} else {

				focusNode = focusNode.right;

			}

			if (focusNode == null)

				return null;

		}

		return focusNode;

	}

    public static void main(String[] args) {

        BinarySearch tree = new BinarySearch();

 

      

        tree.add(5);

        tree.add(3);

        tree.add(2);

        tree.add(4);

        tree.add(7);

        tree.add(6);

        tree.add(8);

        tree.deleteKey(8);

        

        System.out.println("The found node is: " + tree.findNode(5));



        System.out.println("Pre-order traversal:");

        tree.preorderTraverseTree(tree.root);

        

        

    }

}
