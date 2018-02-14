//Chapter 6.4: Heap Sort
public class HeapSort {
  public static void main(String[] args) {
      int[] arr = new int[]{-2,-3,-1,-5};
      heapSort(arr);
      for (int i : arr) System.out.print(i + ", ");
  }
  
  private static void heapSort(int[] arr) {
	  buildHeap(arr);
	  int count = 1;
	  for (int i = arr.length-1; i >= 1; i--) {
		  int tmp = arr[i];
		  arr[i] = arr[0];
		  arr[0] = tmp;
		  heapify(arr, 0, arr.length-(count++));
	  }
  }
  
  private static void buildHeap(int[] arr) {
	  for (int i = arr.length/2; i >= 0; i--) {
		  heapify(arr, i, arr.length);
	  }
  }
  
  private static void heapify(int[] arr, int i, int size) {
	  int left = i * 2 + 1;
	  int right = i * 2 + 2;
	  int maxIndex = i;
	  if (left < size && arr[left] > arr[maxIndex]) {
		  maxIndex = left;
	  }
	  if (right < size && arr[right] > arr[maxIndex]) {
		  maxIndex = right;
	  }
	  
	  if (maxIndex != i) {
		  int tmp = arr[i];
		  arr[i] = arr[maxIndex];
		  arr[maxIndex] = tmp;
		  heapify(arr, maxIndex, size);
	  }
  }
}

