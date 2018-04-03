//Mohammed Awan 3/21/17 HHB 5037

package BinaryHeap;

import java.util.Random;

public class HeapTest {

	public static void main(String[] args){

		//These functions call the binary heap priority queue
		//and the linked list priority queue respectively, so
		//you can comment out whichever of the data structures
		//don't want to see

		//PHeap();

		PList();

	}
	public static void PHeap(){
			//This is the code to run the binary heap priority queue
	 		Heap q = new Heap();

			Random randomGenerator = new Random();
		    for (int idx = 1; idx <= 10; ++idx){
		    	int randomInt = randomGenerator.nextInt(100);
		    	q.insert(randomInt);
		    }
				q.sort(1);
		    q.display();
				System.out.println();

	}
	public static void PList(){
			//This is the code to run the linked list priority queue
			NodeList list = new NodeList();

			list.add("Sally", 3);
			list.add("Jennifer", 2);
			list.add("Mike", 2);
			list.add("Kim", 1);
			list.add("Jimmy", 3);
			list.add("Scot", 2);
			list.add("Joe", 1);
			list.add("Lucy", 4);
			list.display();
			System.out.println();
		//	list.deleteMin();

	}
}
