import java.util.HashSet;

//Reverse a given Linked List

public class ReverseLinkedList {
	public static void main(String[] args) {
		// 7 -> 8 -> 3 -> 4 -> 5
		Node list = new Node(7);
		list.next = new Node(8);
		list.next.next = new Node(4);
		list.next.next.next = new Node(6);
		list.next.next.next.next = new Node(10);
		print(list);
		print(reverseList(list));
	}

	private static Node reverseList(Node list) {
		// 7 -> 8 -> 3 -> 4 -> 5
		Node head = null;
		while (list != null) {
			Node newNode = new Node(list.val);
			newNode.next = head;
			head = newNode;
			list = list.next;
		}
		return head;
	}

	private static void print(Node list) {
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
		System.out.println();
	}

}

class Node {
	int val;
	Node next;
	Node(int val) {
		this.val = val;
	}
}
