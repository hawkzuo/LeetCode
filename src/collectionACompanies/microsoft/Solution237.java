package collectionACompanies.microsoft;

import collectionUtils.ListNode;

public class Solution237 {

	public Solution237() {
		// TODO Auto-generated constructor stub
	}
    public void deleteNode(ListNode node) {
        // Assume: node.next != null
        node.val = node.next.val;
        node.next = node.next.next;        
    }
}
