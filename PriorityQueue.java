class PriorityQueue {
	private int[] arr;
	private int size;
	
	public PriorityQueue(int size) {
		arr = new int[size];
		this.size = size;
	}
	
	public PriorityQueue(int[] array) {
		arr = new int[array.length];
		size = array.length;
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
		}
		System.out.println();
		buildHeap();
	}
	
	public int peek() {
		return size > 0 ? arr[0] : Integer.MIN_VALUE;
	}
	
	public int pop() {
		int max = arr[0];
		arr[0] = arr[--size];
		heapify(0);
		return max;
	}
	
	public boolean insert(int i) {
		if (size < arr.length) {
			arr[++size] = Integer.MIN_VALUE;
			increaseKey(size, i);
		}
		return false;
	}
	
	public boolean increaseKey(int i, int k) {
		if (i >= size) return false;
		if (k < arr[i]) return false;
		arr[i] = k;
		while (i > 0 && arr[(i-1)/2] < arr[i]) {
			int tmp = arr[i];
			  arr[i] = arr[(i-1)/2];
			  arr[(i-1)/2] = tmp;
			  i = (i-1)/2;
		}
		return true;
	}
	  
	  private void buildHeap() {
		  for (int i = (size-1)/2; i >= 0; i--) {
			  heapify(i);
		  }
	  }
	  
	  private void heapify(int i) {
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
			  heapify(size);
		  }
	  }
}
