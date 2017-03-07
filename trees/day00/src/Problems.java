import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        BinarySearchTree<Integer> minTree = new BinarySearchTree<>();
        Collections.sort(values);
        BSTadd(minTree, values);
        return minTree;
    }

    private static void BSTadd(BinarySearchTree<Integer> tree, List<Integer> values){
        tree.add(values.get(values.size()/2));
        if (values.size() > 1){
            BSTadd(tree, values.subList(0, values.size()/2));
            BSTadd(tree, values.subList(values.size()/2, values.size()));
        }
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if ((n1 == null) && (n2 == null) || (n1.isLeaf() && n2.isLeaf())){
            return true;
        }
        if ( !n1.isLeaf() && !n2.isLeaf()){
            if (n1.leftChild.key == n2.leftChild.key && n1.rightChild.key == n2.rightChild.key){
                return isIsomorphic(n1.leftChild, n2.leftChild) && isIsomorphic(n1.rightChild, n2.rightChild);
            }
            if (n1.rightChild.key == n2.leftChild.key && n1.leftChild.key == n2.rightChild.key){
                return isIsomorphic(n1.rightChild, n2.leftChild) && isIsomorphic(n1.leftChild, n2.rightChild);
            }
        }

        return false;
    }
}
