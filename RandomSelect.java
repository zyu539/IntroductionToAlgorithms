//Chapter 9.2: Random Select(average O(n))
import java.util.Random;

public class RandomSelect {
  public static void main(String[] args) {
      int[] arr = new int[]{-2,-3,-1,-5};
      //quickSort(arr, 0, arr.length-1);
      //for (int i : arr) System.out.print(i + ", ");
      System.out.println(selection(arr, 0, arr.length-1, 1));
  }
  
  public static int selection(int[] arr, int l, int r, int i) {
	  if (l == r) return arr[l];
	  int q = partition(arr, l, r);
	  //for (int in : arr) System.out.print(in + ", ");
	  //System.out.println();
	  int len = q - l + 1;
	  //System.out.println(q + "   " + len);
	  if (len == i) {
		  return arr[q];
	  } else if (len < i) {
		  return selection(arr, q+1, r, i-len);
	  } else {
		  return selection(arr, l, q-1, i);
	  }
  }
  
  private static int partition(int[] arr, int l, int r) {
	  if (l >= r) return r;
	  Random rand = new Random();
	  int rn = rand.nextInt(r+1);
	  //System.out.println(rn);
	  exchange(arr, rn, r);
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
