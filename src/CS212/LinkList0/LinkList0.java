package CS212.LinkList0;

import java.util.Scanner;

/**
 * Created by Venoth on 10/27/2016.
 */
public class LinkList0 {
    int info; //holds the first field of an node (1)
    LinkList0 link; //reference variable, the next pointer field (2)

    //intialize the list by null
    LinkList0() { //constructor
        this.link = null;
    }

}


class LinkedListDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //creating 3 nodes
        LinkList0 a = new LinkList0();
        LinkList0 b = new LinkList0();
        LinkList0 c = new LinkList0();

        //storing the data into the ingo field of the nodes...
        System.out.println("enter value of the node a");
        a.info = s.nextInt();
        System.out.println("enter value of the node b");
        b.info = s.nextInt();
        System.out.println("enter value of the node c");
        c.info = s.nextInt();

        // Linking the nodes together
        a.link = b;
        b.link = c;

        // printing the node a
        // a.link.info is the value of next node
        //a.link.link.info is the value of the node of next Next (2)

        System.out.println("a.info " + a.link.link.info);

    }// end of main ....
}
