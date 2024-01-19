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

// ekdam simple logic - jitne bhi nodes less than x h unko ek stack m push kro aur node delete kro, uske baad me stack se pop krke head p insert krte jaao nodes ko
class Solution {
    public ListNode partition(ListNode head, int x) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        ListNode prev = new ListNode(101);
        while(temp != null){
            if(temp.val < x){
                st.push(temp.val);
                if(prev.val == 101){
                    head = head.next;
                    temp = temp.next;
                    continue;
                }
                else{
                    prev.next = temp.next;
                    temp = temp.next;
                    continue;
                }
            }
            prev = temp;
            temp = temp.next;
        }

        while(!st.isEmpty()){
            ListNode node = new ListNode(st.pop());
            node.next = head;
            head = node;
        }
        
        return head;
    }
}