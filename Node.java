//Mohammed Awan 3/21/17 HHB 5037

package BinaryHeap;

public class Node {

  String data;
  int prior;
  Node next;

  public Node(){
    this.data = "";
    this.prior = 0;
    this.next = null;
  }

  public Node(String data, int prior, Node next){
    this.data = data;
    this.prior = prior;
    this.next = next;
  }
}
