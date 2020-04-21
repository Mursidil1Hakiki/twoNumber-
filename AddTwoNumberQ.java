/**
 * AddTwoNumberQ
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

* You may assume the two numbers do not contain any leading zero, except the number 0 itself.

* Example:
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.

*	class ListNode {
*		int val;
*		ListNode next;
*		ListNode(int x) { val = x; }
*	}

 */


import java.util.*;

public class AddTwoNumberQ {

	public static void main(String[] args) {
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(5);
		ListNode ans = new ListNode(0);
		ans.next = new ListNode(1);

		assertTrue(addTwoNumbers(a, b).equals(ans));
		a = new ListNode(2);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);

		b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(4);

		ans = new ListNode(7);
		ans.next = new ListNode(0);
		ans.next.next = new ListNode(8);
		assertTrue(addTwoNumbers(a, b).equals(ans));
	}

	public static void assertTrue(boolean v) {
		if(!v) {
			Thread.dumpStack();
			System.exit(0);
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy_head = null;
      	ListNode return_head = null;
      	ListNode l3 = null;
      	int carry = 0;
      	
      while(l1 != null || l2 != null){
      	int l1_val = (l1 != null)?l1.val : 0;
        int l2_val = (l2 != null)?l2.val : 0;
       
        int current_sum = l1_val +  l2_val + carry;
        carry = current_sum /10;
        int last_digit = current_sum %10;
        
        if(dummy_head == null){          
        	dummy_head = new ListNode(last_digit);
          	return_head = new ListNode(last_digit);
          	l3 = dummy_head;
        }else{
          	ListNode new_node = new ListNode(last_digit);
        	l3.next = new_node; 
        	l3 = l3.next;
        }
        if(l1 != null){
          		l1 = l1.next;
        	}
        	if(l2!=null){
          		l2 = l2.next;
        	}
      }
      
      if(carry >0){
        ListNode new_node = new ListNode(carry);
        l3.next = new_node;
        l3 = l3.next;        
      }
      //print the content of dummy_head 
      while(dummy_head != null){
        System.out.print(dummy_head.val+"->");
        dummy_head = dummy_head.next;
      }      
      System.out.println();
      return return_head;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }

	@Override
	public boolean equals(Object obj) {
		ListNode otherNode = (ListNode)obj;
		ListNode curNode = this;
		ListNode curOtherNode = otherNode;
		boolean valid = true;

		while (curNode != null) {
			if (curNode.val != curOtherNode.val) {
				valid = false;
			}

			curNode = curNode.next;
			curOtherNode = curOtherNode.next;
		}

		return valid;
	}
}
