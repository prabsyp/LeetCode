/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbersUsingLinkedList {
	public class ListNode {
     int val;
	ListNode next;
	ListNode(int x) { val = x; }
 }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int size1 = 0;
        int size2 = 0;
        
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;
        while(curNode1 != null) {
            curNode1 = curNode1.next;
            size1++;
        }
        
        while(curNode2!=null) {
            curNode2 = curNode2.next;
            size2++;
        }
        
        if(size1>size2) {
            curNode1 = l1;
            curNode2 = l2;
        }
        else {
            curNode1 = l2;
            curNode2 = l1;
        }
        ListNode root = null;
        ListNode cur = null;
        int curSum = 0;
        int carry = 0;
        int newVal = 0;
        while(curNode2!= null) {
            curSum = curNode2.val + curNode1.val + carry;
            newVal = curSum%10;
            carry = curSum/10;
            ListNode n1 = new ListNode(newVal);
            if(root == null) {
                root = n1;
                cur = root;
                
            }
            else
            {
                cur.next = n1;
                cur = cur.next;
            }
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        
        while(curNode1 != null) {
            curSum = curNode1.val + carry;
            newVal = curSum%10;
            carry = curSum/10;
            ListNode n1 = new ListNode(newVal);
            cur.next = n1;
            cur = cur.next;
            curNode1 = curNode1.next;
        }
        
        if(carry > 0) {
            ListNode n1 = new ListNode(carry);
            cur.next = n1;
        }
        
        return root;
    }

}
