

public class Tree
{

    Node root;

    public Tree()
    {

    }

    public void print(Node node)
    {
        if (node == null)
        {
            System.out.println("the Tree is empty");
        }
        else
        {
            System.out.println(node.val);
            if (node.left != null)
            {
                System.out.println(node.left.val);
                print(node.left);
            }
            if (node.right != null)
            {
                System.out.println(node.right.val);
                print(node.right);
            }
        }

    }

    public Node insert(Node node, int val)
    {
        if (node == null)
        {
            node = new Node(val);
        }
        else
        {
            if (val > node.val)
            {
                node.right = insert(node.right, val);

            } else {
                node.left = insert(node.left, val);
            }

        }
        return node;
    }
}
