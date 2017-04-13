import  java.util.*;

public class BarnRepair {
    public static int solve(int M, int S, int C, int[] occupied) {
        PriorityQueue<Integer> gaps = new PriorityQueue<>();
        java.util.Arrays.sort(occupied);
        int covered = C;

        for (int i = 1; i < C; i++) {
            int currGap = occupied[i] - occupied[i-1] -1;
            gaps.add(currGap);
        }

        if (M >= C){
//            System.out.println( "M>=C");
            return C;
        }

        if (M - 1 >= gaps.size()) {
            return C;
        }

        while (gaps.size() != M -1){
            covered += gaps.poll();
        }

//        System.out.println(covered);
        return covered;
    }
//    public static int solve(int M, int S, int C, int[] occupied) {
//        PriorityQueue<Integer> gaps = new PriorityQueue<>(C, Collections.reverseOrder());
//        java.util.Arrays.sort(occupied);
//        int uncoveredStalls = 0;
//
//        for (int i = 1; i < occupied.length; i++) {
//            int currGap = occupied[i] - occupied[i-1] - 1;
//            gaps.add(currGap);
//        }
//
//        //redundant
//        if (M >= C) {
//            return C;
//        }
//
//        if (M - 1 >= gaps.size()) {
//            return C;
//        }
//
//        for (int i = 0; i < M; i++) {
//            if (gaps.size() > 0) {
//                uncoveredStalls += gaps.poll();
//            }
//        }
//
//        uncoveredStalls += (occupied[0] -1);
//        uncoveredStalls += (S - occupied[occupied.length-1] - 1);
//        System.out.println(S-uncoveredStalls);
//        return S-uncoveredStalls;
//    }

    // So that sucked for so reason and generates a fuckload of off by 1 errors. Time to do it the hardway
//    public static int solve(int M, int S, int C, int[] occupied) {
//        ArrayList<ArrayList> cowClumps = new ArrayList<>(); // Start end pair of clumped cows.
//        java.util.Arrays.sort(occupied);
//        HashMap<Integer, ArrayList> gapsMap = new HashMap<>(); // Map of gap sizes to locations
//        PriorityQueue<Integer> gapsQueue = new PriorityQueue<>(); //Minqueue of gap sizes
//
//        Boolean streak = false;
//        Integer streakStart = -1;
//        for (int i = 1; i < occupied.length; i++) {
//            int currGap = occupied[i] - occupied[i-1] - 1;
//            if (currGap > 0) {
//                if (gapsMap.get(currGap) != null){
//                    ArrayList toPut = gapsMap.get(currGap);
//                    toPut.add((i-1));
//                    gapsMap.put(currGap, toPut);
//                } else {
//                    ArrayList toPut = new ArrayList();
//                    toPut.add((i-1));
//                    gapsMap.put(currGap, toPut);
//                }
//                gapsQueue.add(currGap);
//                if (streak) {
//                    ArrayList bounds = new ArrayList();
//                    bounds.add(streakStart);
//                    bounds.add(occupied[i-1]);
//                    cowClumps.add(bounds);
//                }
//                streak = false;
//            }
//            if (currGap == 0) {
//                if (!streak) {
//                    streakStart = occupied[i-1];
//                    streak = true;
//                }
//            }
//        }
//        System.out.println(cowClumps.toString());
//        System.out.println(gapsMap.toString());
//        System.out.println(gapsQueue.toString());
//
//
//
//        return 0;
//    }
}
