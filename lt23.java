class lt23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            int n = lists.length;
            ListNode[] merged = new ListNode[(n + 1) / 2];

            for (int i = 0; i < n / 2; i++) {
                merged[i] = merge(lists[i * 2], lists[i * 2 + 1]);
            }

            if (n % 2 == 1) {
                merged[merged.length - 1] = lists[n - 1];
            }

            lists = merged;
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;

        return dummy.next;
    }
}