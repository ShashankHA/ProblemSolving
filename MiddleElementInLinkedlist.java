public class MiddleElementInLinkedlist {
	public static void main(String args[]) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.print();
		ListNode res = getMiddleNode(node);
		res.print();
	}

	private static ListNode getMiddleNode(ListNode node) {
		ListNode slow, fast;
		slow = fast = node;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		slow.next = null;
		return slow;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	void print() {
		System.out.print(val + "-->");
		if (next == null) {
			System.out.println("null");
			return;
		}
		next.print();
	}
}