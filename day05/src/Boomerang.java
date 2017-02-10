public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        int numberOfBoomerangs = 0;
        for (int i =0; i < points.length; i++){
            MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
            for (int j = 0; j< points.length; j++){
                int distance = getSquaredDistance(points[i], points[j]);
                int number;
                if (map.get(distance) == null) {
                    number = 0;
                }
                else {
                    number = map.get(distance);
                }
                map.put(distance, number + 1);
            }
            for (int distance: map.keySet()){
                int number = map.get(distance);
                numberOfBoomerangs += number * (number - 1);
            }
        }
        return numberOfBoomerangs;
    }

    private static int getSquaredDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
