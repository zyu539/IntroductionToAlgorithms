//Chapter 2.1: Insertion Sort
public class InsertionSort {
  public static void main(String[] args) {
      int[] arr = new int[]{3,2,1,3,5,-1};
      insertionSort(arr);
      for (int i : arr) {
    	  System.out.print(i + ", ");
      }
  }
  
  private static void insertionSort(int[] arr) {
	  if (arr == null || arr.length < 2) return;
	  for (int i = 1; i < arr.length; i++) {
		  int key = arr[i];
		  int j = i-1;
		  while (j >= 0 && arr[j] > key) {
			  arr[j+1] = arr[j];
			  j--;
		  }
		  arr[j+1] = key;
	  }
  }
}
