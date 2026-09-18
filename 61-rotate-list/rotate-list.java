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
    public ListNode rotateRight(ListNode head, int k) {
        // if(k<=0||head==null||head.next==null) return head;
        // ListNode last=head;
        // int length=1;
        // while(last.next!=null){
        //     last=last.next;
        //     length++;
        // }
        // last.next=head;
        // int rotation=k%length;
        // int skip=length-rotation;
        // ListNode lastNode =head;
        // for(int i=0;i<skip-1;i++){
        //     lastNode=lastNode.next;
        // }
        // head=lastNode.next;
        // lastNode.next=null;
        // return head;
        if(head==null|| head.next==null) return head;
        ListNode last = head;
        int n=1;
        while(last.next!=null){
            n++;
            last=last.next;
        }
        k=k%n;
        if(k==0) return head;
        ListNode t=head;
        int count=1;
        while(t!=null){
            if(count==(n-k)) break;
            count++;
            t=t.next;
        }
        last.next=head;
        ListNode res=t.next;
        t.next=null;
        return res;
    }
}