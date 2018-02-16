public class QuickSort {
  public static void main(String[] args) {
      int[] arr = new int[]{-2,-3,-1,-5};
      quickSort(arr, 0, arr.length-1);
      for (int i : arr) System.out.print(i + ", ");
  }
  
  public static void quickSort(int[] arr, int l, int r) {
	  if (l >= r) return;
	  int piv = partition(arr, l, r);
	  //for (int i : arr) System.out.print(i + ", ");
	  quickSort(arr, l, piv-1);
	  quickSort(arr, piv+1, r);	  
  }
  
  private static int partition(int[] arr, int l, int r) {
	  if (l >= r) return r;
	  int k = l - 1;
	  for (int i = l; i < r; i++) {
		  if (arr[i] <= arr[r]) {
			  k++;
			  exchange(arr,k, i);
		  }
	  }
	  exchange(arr, k+1, r);
	  return k+1;
  }
  
  private static void exchange(int[] arr, int i, int j) {
	  int tmp = arr[i];
	  arr[i] = arr[j];
	  arr[j] = tmp;
  }
  
}
