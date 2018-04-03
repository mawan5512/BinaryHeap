//Mohammed Awan 3/21/17 HHB 5037

package BinaryHeap;

public class NodeList {
  protected Node head;
  protected Node tail;

  public int size;

  public NodeList(){
    head = null;
    tail = null;
    size = 0;
  }

//function that adds a node to the end of the list
  public void add(String data, int prior){
    Node node = new Node(data, prior, null);

    if (head == null){
        head = node;
        tail = node;
    }
    else if (head.next == null){
      if(node.prior < head.prior){
        node.next = head;
        head = node;
      } else {
        head.next = node;
        tail = node;
      }
    }
    else{
      Node nptr;
      Node nptr_ahead;
      nptr = head.next;
      nptr_ahead = head;
      while(nptr != null){
        if(node.prior < head.prior){
           node.next = head;
           head = node;
           nptr = null;
        }
        else if (node.prior < nptr.prior) {
          nptr_ahead.next = node;
          node.next = nptr;
          nptr = null;
        }
        else if(nptr.next == null){
          nptr.next = node;
          tail = node;
          nptr = null;
        }
        else if (node.prior >= nptr.prior){
          nptr = nptr.next;
          nptr_ahead = nptr_ahead.next;
        }

      }
    }
  }

//This function takes the first priority piece of dat and deletes it
  public void deleteMin(){
    Node nptr;
    nptr = head;

    if(head.next == null){
      head = null;
      tail = null;
    } else {
      head = head.next;
      nptr = null;
    }
  }

//This is a function that displays the queue
  public void display(){
    Node nptr;

    nptr = head;

    while(nptr != null){
      size++;  //The size will increase as it traverses each node
      System.out.println(nptr.data + " " + nptr.prior);
      nptr = nptr.next;
    }
    System.out.print("The size is " + size);

  }
}
