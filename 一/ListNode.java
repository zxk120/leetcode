package exercise1;

public class ListNode {
    public Object val;
    public ListNode next;
    public int weight;

    ListNode() {
    }

    public ListNode(Object val) {
        this.val = val;
    }

    public ListNode(Object val, int weight) {
        this.val = val;
        this.weight = weight;
    }

}
