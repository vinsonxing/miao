package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/4/14
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
//http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
//http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
public class MedianofSortedArray {
//  int getMedian(int ar1[], int ar2[], int n)
//  {
//    int m1; /* For median of ar1 */
//    int m2; /* For median of ar2 */
//
//    /* return -1  for invalid input */
//    if (n <= 0)
//      return -1;
//
//    if (n == 1)
//      return (ar1[0] + ar2[0])/2;
//
//    if (n == 2)
//      return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;
//
//    m1 = median(ar1, n); /* get the median of the first array */
//    m2 = median(ar2, n); /* get the median of the second array */
//
//    /* If medians are equal then return either m1 or m2 */
//    if (m1 == m2)
//      return m1;
//
//     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
//    if (m1 < m2)
//    {
//      if (n % 2 == 0)
//        return getMedian(ar1 + n/2 - 1, ar2, n - n/2 +1);
//      else
//        return getMedian(ar1 + n/2, ar2, n - n/2);
//    }
//
//    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
//    else
//    {
//      if (n % 2 == 0)
//        return getMedian(ar2 + n/2 - 1, ar1, n - n/2 + 1);
//      else
//        return getMedian(ar2 + n/2, ar1, n - n/2);
//    }
//  }

  public static double findMedianSortedArrays(int A[], int B[]) {
    int m = A.length;
    int n = B.length;

    if ((m + n) % 2 != 0) // odd
      return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
    else { // even
      return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
              + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
    }
  }

  public static int findKth(int A[], int B[], int k,
                            int aStart, int aEnd, int bStart, int bEnd) {

    int aLen = aEnd - aStart + 1;
    int bLen = bEnd - bStart + 1;

    // Handle special cases
    if (aLen == 0)
      return B[bStart + k];
    if (bLen == 0)
      return A[aStart + k];
    if (k == 0)
      return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

    int aMid = aLen * k / (aLen + bLen); // a's middle count
    int bMid = k - aMid - 1; // b's middle count

    // make aMid and bMid to be array index
    aMid = aMid + aStart;
    bMid = bMid + bStart;

    if (A[aMid] > B[bMid]) {
      k = k - (bMid - bStart + 1);
      aEnd = aMid;
      bStart = bMid + 1;
    } else {
      k = k - (aMid - aStart + 1);
      bEnd = bMid;
      aStart = aMid + 1;
    }

    return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
  }
}
