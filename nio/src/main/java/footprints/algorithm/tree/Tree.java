package footprints.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by luoquan on 14-5-15.
 */
public class Tree {

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.setlChild(n2);
        n1.setrChild(n3);

        n2.setlChild(n4);
        n2.setrChild(n5);

        n3.setlChild(n6);
        n3.setrChild(n7);

        n4.setlChild(n8);

        visitRecursive(n1);
    }


    public static void visitRecursive(Node node) {
        List<Node> list = new ArrayList<Node>();
        list.add(node);
        while (!list.isEmpty()) {
            List<Node> children = new ArrayList<Node>();
            for (Node n : list) {
                visitNode(n);
                Node l = n.getlChild();
                Node r = n.getrChild();
                if (r != null) {
                    children.add(r);
                }
                if (l != null) {
                    children.add(l);
                }
            }
            list = children;
        }
    }

    private static void visitNode(Node node) {
        node.setVisited(true);
        System.out.println(node.getValue());
    }
}
