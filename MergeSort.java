//Chapter 2.3: merge sort
public class MergeSort {
  public static void main(String[] args) {
      int[] arr = new int[]{3,2,1,3,5,7,-1};
      mergeSort(arr);
      for (int i : arr) {
    	  System.out.print(i + ", ");
      }
  }
  
  public static void mergeSort(int[] arr) {
	  if (arr == null || arr.length < 2) return;
	  decompose(arr, 0, arr.length-1);
  }
  
  private static void decompose(int[] arr, int l, int r) {
	  if (l >= r) return;
	  int index = (l + r) / 2;
	  decompose(arr, l, index);
	  decompose(arr, index+1, r);
	  merge(arr, l, index, r);
  }
  
  private static void merge(int[] arr, int l, int m, int r) {
	  int n1 = m - l + 1;
	  int n2 = r - m;
	  int[] L = new int[n1+1];
	  int[] R = new int[n2+1];
	  for (int i = 0; i < n1; i++) {
		  L[i] = arr[l+i];
	  }
	  for (int i = 0; i < n2; i++) {
		  R[i] = arr[m+1+i];
	  }
	  //Set a gurd so that the array cant be empty;
	  L[n1] = Integer.MAX_VALUE;
	  R[n2] = Integer.MAX_VALUE;
	  int nl = 0, nr = 0;
	  for (int i = l; i < r+1; i++) {
		  if (L[nl] < R[nr]) {
			  arr[i] = L[nl];
			  nl++;
		  } else {
			  arr[i] = R[nr];
			  nr++;
		  }
	  }
  }
}
