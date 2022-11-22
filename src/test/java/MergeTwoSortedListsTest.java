import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MergeTwoSortedListsTest {

    ListNode list1 = new ListNode();
    ListNode list2 = new ListNode();
    ListNode result = new ListNode();
    @BeforeEach
    void setUp() {
        list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // Expected [1,1,2,3,4,4]
    }

    @Test
    void run(){
        result = solution(new ListNode(), list1, list2);
        while (result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    private ListNode solution(ListNode node, ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            node = listNode2;
        } else if (listNode2 == null) {
            node = listNode1;
        } else if (listNode1.val > listNode2.val){
            node = new ListNode(listNode2.val, solution(new ListNode(), listNode1, listNode2.next));
        } else if(listNode1.val <= listNode2.val) {
            node = new ListNode(listNode1.val, solution(new ListNode(), listNode1.next, listNode2));
        }
        return node;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}