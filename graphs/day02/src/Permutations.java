import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.*;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        int k = 0;
        return permsHelp(A, k, new ArrayList<>());
    }

    public static List<List<Integer>> permsHelp (List<Integer> A, int k, List<List<Integer>> res){
        for (int i = k; i < A.size(); i++) {
            java.util.Collections.swap(A, i, k);
            permsHelp(A, (k+1), res);
            java.util.Collections.swap(A, k, i);
        }
        if (k == A.size() -1){
            ArrayList<Integer> curr = new ArrayList<>(A);
            res.add(curr);
        }
        if (res.size() == IntStream.rangeClosed(2, A.size()).reduce(1, (x, y) -> x * y)){
            return res;
        }
        return null;
    }


}
