/*
Runtime: 1 ms, faster than 33.56% of Java online submissions for Remove Duplicates from Sorted List.
Memory Usage: 39 MB, less than 77.05% of Java online submissions for Remove Duplicates from Sorted List.

Time: 5-10 minutes

Difficulty: 2

The only trick is to rectify the pointers in order to delete a node.
*/

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
    public ListNode deleteDuplicates(ListNode head) {
        //Set to keep track of distinct numbers in list
        HashSet<Integer> set = new HashSet<Integer>();
        //Previous ListNode to keep track of the previous pointer and to link that to the pointer .next in order to delete.
        ListNode previous = null;
        //Current Pointer to keep track of current location
        ListNode pointer = head;
        //Loops through the pointer 
        while(pointer != null){
            //If there is a duplicate that should be deleted then set the previous's pointer to the ucrrent pointer's next and the current pointer to the pointer's next
            if(!set.add(pointer.val)){
                previous.next = pointer.next;
                pointer = pointer.next;
            //Otherwise traverse through the list.
            }else{
                previous = pointer;
                pointer = pointer.next;
            }
        }
        
        return head;
    }
}
