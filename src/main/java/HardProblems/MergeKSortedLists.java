package HardProblems;


import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode res = null;
        for (ListNode listNode: lists)
        {
            res = mergeTwoLists(res,listNode);
        }
        return res;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        if (l1.val<l2.val)
        {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((x,y)->{
            return Integer.compare(x.val, y.val);
        });
        for (ListNode listNode:lists)
        {
          while (listNode!=null)
          {
              priorityQueue.add(listNode);
              listNode = listNode.next;
          }
        }
        ListNode sentinel = new ListNode(-1001), sentinel2 = sentinel;
        sentinel.next = priorityQueue.peek();
        while (!priorityQueue.isEmpty())
        {
            sentinel2.next = priorityQueue.poll();
            sentinel2 = sentinel2.next;
        }
        sentinel2.next = null;
        return sentinel.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}