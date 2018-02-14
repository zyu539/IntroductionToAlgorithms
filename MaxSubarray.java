//Chapter 4.1: Max Subarray
//This method use the divide-conquer method provided in the book, which is O(nlogn) complex.(DP can have a better time
//performance but need O(n) space);
public class MaxSubarray {
  public static void main(String[] args) {
      int[] arr = new int[]{3,2,1,3,-14,5,7};
      int res = findMaxSubArray(arr, 0, arr.length-1);
      System.out.println(res);
  }
  
  private static int findMaxSubArray(int[] arr, int l, int r) {
	  if (l >= r) return arr[r];
	  int m = (l + r) / 2;
	  return Math.max(findCross(arr, l, m, r), Math.max(findMaxSubArray(arr, l, m), findMaxSubArray(arr, m+1, r)));
  }
  
  private static int findCross(int[] arr, int l, int m, int r) {
	  if (l > r) return Integer.MIN_VALUE;
	  int leftSum = Integer.MIN_VALUE;
	  int rightSum = Integer.MIN_VALUE;
	  int sum = 0;
	  for (int i = m; i >= l; i--) {
		  sum += arr[i];
		  leftSum = Math.max(leftSum, sum);
	  }
	  sum = 0;
	  for (int i = m+1; i <= r; i++) {
		  sum += arr[i];
		  rightSum = Math.max(rightSum, sum);
	  }
	  return rightSum + leftSum;
  }
}
