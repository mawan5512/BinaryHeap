//Mohammed Awan 3/21/17 HHB 5037

package BinaryHeap;

public class Heap {

	double[] heap;
	int size = 0;

	public Heap() {
		// set default size
		heap = new double[10];
		heap[0] = Double.MIN_VALUE;
	}

	// get parent of node at position i
	private int parent(int i){
		return i / 2;
	}

	// get left child of node at position i
	private int leftChild(int i){
		return i * 2;
	}

	// get right child of node at position i
	private int rightChild(int i){
		return (i*2) + 1;
	}


	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public double findMin() {
		if(!isEmpty()){
			return heap[1];
		}
		return 0;
	}

	private void doubleHeap(){
		double[] newHeap = new double[(heap.length)*2];
		for(int i = 0; i < heap.length; i++){
			newHeap[i] = heap[i];
		}
		heap = newHeap;
	}

	private void swap(int index1, int index2){
		double temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	public void insert(double x) {
		// increase size
		size++;
		// add value to heap
		heap[size] = x;
		// index where the value is
		int currIndex = size;
		// change position of value to meet min-heap property
		while(heap[currIndex] < heap[parent(currIndex)]){
			// if the value is smaller than its parent then swap the values
			swap(currIndex, parent(currIndex));
			// change current index to the position of the parent
			currIndex = parent(currIndex);
		}

		// check to see if heap is full
		if(size == heap.length - 1){
			doubleHeap();
		}

		// Check to see if the added section of the array is 50% full
		//if(size == ((heap.length) * 3/ 4) - 1){
		//	doubleHeap();
		//}

		//Checks to see if the added section of the array is 75% full
		//if(size == ((heap.length) * 7/8) - 1){
		//	doubleHeap();
		//}
	}

//make sure that values within the same levels are arranged
	public void sort(int currIndex){

		//If the current value is the root then do nothing
		if(currIndex == 1){
		}
		//It checks if the currIndex is the right-child
		else if(currIndex == rightChild(parent(currIndex))){
			//If the currIndex is less than the leftChild than it will swap the two children
			if(heap[leftChild(parent(currIndex))] > heap[currIndex]){
				swap(currIndex, leftChild(parent(currIndex)));
			}
		}

		// It will make sure that the heap property doesn't get messed up when sorting
		while(heap[currIndex] < heap[parent(currIndex)]){
			// if the value is smaller than its parent then swap the values
			swap(currIndex, parent(currIndex));
			// change current index to the position of the parent
			currIndex = parent(currIndex);
		}

		//If the currIndex has children it will recursively check it's children if they need to be sorted
		if(hasRightChild(currIndex)){
			sort(rightChild(currIndex));
		}

		if(hasLeftChild(currIndex)){
			sort(leftChild(currIndex));
		}
	}

	private boolean hasLeftChild(int i){
		return (leftChild(i) <= size);
	}

	private boolean hasRightChild(int i) {
		return (rightChild(i) <=  size);
	}

	private boolean isLeaf(int i){
		if (hasLeftChild(i)){
			return false;
		} else {
			return true;
		}
	}

	private void minHeapify(int i){
		if (!isLeaf(i)){
			int minIndex;
			if(hasRightChild(i)){
				// check to see whether left or right child is smaller
				if(heap[rightChild(i)] < heap[leftChild(i)]){
					minIndex = rightChild(i);
				} else {
					minIndex = leftChild(i);
				}
			} else {
				// if the node is not a leaf you can assume it has at least a left node
				minIndex = leftChild(i);
			}
			// swap with smallest child
			if(heap[minIndex] < heap[i]){
				swap(minIndex, i);
				minHeapify(minIndex);
			}
		}
	}

	public double deleteMin() {
		// make sure the heap is not empty
		double min = 0.0;
		if(!isEmpty()){
			min = heap[1];
			// set the root equal to the last element in the heap
			heap[1] = heap[size];
			// decrease size
			size--;
			// make sure heap follows min-heap property
			if(!isEmpty()){
				minHeapify(1);
			}
		}
		return min;
	}

	public void makeEmpty() {
		// reset size and array
		size = 0;
		heap = new double[10];
		heap[0] = Double.MIN_VALUE;
	}

	public void display(){
		for (int i=1; i<=size; i++)
			System.out.println(heap[i]);
	}

}
