/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode helper(ListNode head, int k, ListNode next){
        if(k==0){
            head.next = next;
            return head;
        }
        ListNode temp = helper(head.next, k-1, head);
        head.next = next;
        return temp;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || right-left ==  0) return head;
        ListNode temp = head;
        ListNode prevNode = new ListNode(-502);
        int diff = right - left;
        while(left-->1){
            prevNode = temp;
            temp = temp.next;
        }
        ListNode next = head;
        while(right-->0){
            next = next.next;
        }
        if(prevNode.val == -502){ // list has to be reversed from the beginning
            return helper(temp, diff, next);
        }
        else{
            prevNode.next = helper(temp, diff, next);
            return head;
        }
        

    }
}