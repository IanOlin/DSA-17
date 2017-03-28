import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> levelOrderTraversal(TreeNode<Integer> n) {
        List order = new LinkedList();
        Queue q = new LinkedList();
        q.add(n);
        TreeNode current;
        while (!q.isEmpty()){
            current = (TreeNode) q.remove();
            if (current.hasLeftChild()){
                q.add(current.leftChild);
            }
            if (current.hasRightChild()){
                q.add(current.rightChild);
            }
            order.add(current.key);
        }
        return order;
    }
}
