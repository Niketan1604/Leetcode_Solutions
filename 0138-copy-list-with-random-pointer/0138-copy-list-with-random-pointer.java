/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Node copy_head; //head of copy list
    Node list_head; //head of given list
    void assignRandomPointer(Node head, Node main){
        if(head == null || main == null) return;
        Node k = main.random;

        if(k == null){
            head.random = null;
        }
        else{
            Node temp1 = copy_head.next;
            Node temp2 = list_head;
            while(temp2!=k){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            head.random = temp1;
            
        }

        assignRandomPointer(head.next,main.next);

    }
    public Node copyRandomList(Node head) {
        Node root = new Node(-1);
        copy_head = root;
        list_head = head;
        while(head != null){
            Node new_node = new Node(head.val);
            root.next = new_node;
            root = root.next;
            head = head.next;
        }
        assignRandomPointer(copy_head.next,list_head);
        return copy_head.next;
    }
}