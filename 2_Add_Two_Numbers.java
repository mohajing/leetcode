class Solution {
    // public class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode cursor = answer;
        int up = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int sum = l1Val + l2Val + up;
            if (sum > 9) {
                sum = sum - 10;
                up = 1;
            } else {
                up = 0;
            }

            cursor.next = new ListNode(sum);
            cursor = cursor.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (up == 1) {
            cursor.next = new ListNode(1);
        }

        return answer.next;
    }
}