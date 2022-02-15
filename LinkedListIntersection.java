import java.util.HashSet;

//print intersecting node of two linked lists

public class LinkedListIntersection {
	
	public static void main(String[] args) {

		// 1 -> 2-> 3 -> 4 -> 5
		// 7 -> 8 -> 3 -> 4 -> 5
		Node common = new Node(3);
		common.next = new Node(4);
		common.next.next = new Node(5);

		Node list1 = new Node(1);
		list1.next = new Node(2);
		list1.next.next = common;

		Node list2 = new Node(7);
		list2.next = new Node(8);
		list2.next.next = common;
		// list2.next.next = new Node(8);

		print(list1);
		print(list2);

		findIntersectingNode(list1, list2);

	}

	private static void findIntersectingNode(Node list1, Node list2) {
		HashSet<Node> set = new HashSet<Node>();
		while (list1 != null) {
			set.add(list1);
			list1 = list1.next;
		}
		while (list2 != null) {
			if (set.contains(list2)) {
				System.out.println(list2.val);
				return;
			}
			list2 = list2.next;
		}
		System.out.println("No intersection");
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
