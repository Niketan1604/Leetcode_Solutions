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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, next_carry, num;
        ListNode head = l1;
        ListNode last = head;
        while(l1!=null && l2!=null){
            num = l1.val + l2.val + carry;
            next_carry = num/10;
            num = num%10;

            l1.val = num;
            carry = next_carry;
            next_carry = 0;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            num = l1.val + carry;
            next_carry = num/10;
            num = num%10;
            l1.val = num;
            carry = next_carry;
            next_carry = 0;

            l1 = l1.next;
        }

        while(last.next!=null) last = last.next;
        while(l2!=null){
            num = l2.val + carry;
            next_carry = num/10;
            num = num%10;

            ListNode node = new ListNode(num);
            last.next = node;
            carry = next_carry;
            next_carry = 0;

            last = last.next;
            l2 = l2.next;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            last.next = node;
        }
        return head;
    }
}