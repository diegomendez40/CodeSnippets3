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

        ListNode prePreFirstResult = new ListNode();
        prePreFirstResult.next = new ListNode();
        ListNode result = prePreFirstResult.next;
        int carry = 0;
        // While a new node is necessary...
        while (carry == 1 || l1 != null || l2 != null){
            if (l1 == null){
                l1 = new ListNode(0);
            }
            if (l2 == null){
                l2 = new ListNode(0);
            }
            ListNode nextResult = new ListNode ((l1.val + l2.val + carry)%10);
            result.next = nextResult;
            if (l1.val + l2.val + carry >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            result = nextResult;            
        }
        return prePreFirstResult.next.next;
    }
}