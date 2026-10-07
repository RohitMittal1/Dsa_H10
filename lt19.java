class lt19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1=head;
        ListNode p2=head;

        for(int i=0;i<n-1;i++)
        {
            p2=p2.next;
        }

        while(p2!=null)
        {
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return head;
    }
}