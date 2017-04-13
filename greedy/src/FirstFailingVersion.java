public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        long lo = 0;
        long hi = n;
        while (lo <= hi) {
            long mid = lo + (hi-lo)/2;
            if (isBadVersion.isFailingVersion(mid) && !isBadVersion.isFailingVersion(mid - 1)) {
                return mid;
            }
            if (!isBadVersion.isFailingVersion(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
