package com.zhengpengcoder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println(System.currentTimeMillis()/1000);

//        int[] arrays = {2, 7, 6,7,11, 13, 15};
//        int [] result = twoSum(arrays,13);
//        for(int i =0;i<result.length;i++){
//            System.out.println(result[i]);
//        }


        //链表删除指定元素测试
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        //ListNode result  = removeElements(node1,3);
        //System.out.println(result);
        System.out.println(isPalindrome(1111));

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        //step1 遍历外层
        for(int i =0;i<nums.length;i++){
            int num1 = nums[i];
            for(int j=i;j<nums.length;j++){
                if((num1+nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }

            }

        }
        return null;

    }


    /**
     * 删除链表中指定元素的值
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        //先将前面满足删除条件的元素全部删除掉
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;

    }


    /**
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        //转成字符
        String s1 = String.valueOf(x);
        String s2 = new StringBuffer(s1).reverse().toString();
        //字符reverse
        //判断字符串奇偶
        int size = s1.length()/2;
        for(int i =0;i< size;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        //比较是否equals

        return true;

    }

    static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
