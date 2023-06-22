package MediumProblems;

public class RemoveNthNode {

    static int k = 0;
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2));
        removeNthFromEnd(listNode,2);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n)
    {
        ListNode fast = head, slow = head;
        for(int i=0;i<n;i++) fast = fast.next;
        if (fast==null) return head.next;
        while (fast.next!=null)
        {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1,head), sentinel2 = sentinel;
        if (head==null || head.next==null)
            return null;
        k=n;
        helper(sentinel2);
        return sentinel.next;
    }
    public static void helper(ListNode listNode)
    {
        if (listNode.next==null)
            return;

        helper(listNode.next);
        k--;
        if (k==0)
            listNode.next = listNode.next.next;

    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}