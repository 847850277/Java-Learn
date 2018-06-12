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
        //System.out.println(isPalindrome(1111));

        //int[] arrays = {1,2,3};
        //int[] arrays = {-2,0,-1};
        //int[] arrays = {-2,1};
        //int[] arrays = {1};
        int a1 = -1;
        int a2 = 0;
        //System.out.println(a1<a2);
        int[] arrays = {2,-1,1,1};
        //System.out.println(minMoves(arrays));
        System.out.println(maxProduct(arrays));


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


    public static int minMoves(int[] nums) {

        int result = 0;



        return result;

    }


    public static int maxProduct(int[] nums) {
        if(nums.length > 2){
            //TODO 二维数组
            int[][] result1 = new int[nums.length-1][];
            //TODO 二维数组 初始化
            for(int i =0;i<result1.length;i++){
                result1[i] = new int[nums.length-1-i];
            }
            //TODO 二维数组 赋值
            for(int j=0;j<nums.length -1;j++){
                for(int i=0;i<nums.length-1-j;i++){
                    int result = 1;
                    for(int m =0;m<j;m++){
                        result *= nums[m + 1 + 1 + i];
                    }
                    result1[j][i] = result * nums[i] * nums[i + 1];
                }
            }
            //遍历二维数组找最大
            int sum = 0;
            for (int[] ints : result1) {
                for (int anInt : ints) {
                    sum++;
                }
            }
            int[] waitForSort = new int[sum] ;
            sum = 0;
            for (int[] ints : result1) {
                for (int anInt : ints) {
                    waitForSort[sum] = anInt;
                    sum++;
                }
            }

            //冒泡拍序
           for(int i=0;i<waitForSort.length;i++){
               for(int j=0;j<waitForSort.length;j++){
                   if(waitForSort[i]>waitForSort[j]){
                       int temp = waitForSort[i];
                       waitForSort[i] = waitForSort[j];
                       waitForSort[j] = temp;
                   }
               }
           }
           if(waitForSort[0] > 0){
               for(int i =0;i<nums.length;i++){
                   for(int j =0;j<nums.length;j++){
                       if(nums[i]>nums[j]){
                           int temp = nums[i];
                           nums[i] = nums[j];
                           nums[j] = temp;
                       }
                   }
               }

               if(nums[0] > waitForSort[0]){
                   return nums[0];
               }else {
                   return waitForSort[0];
               }

           }else {
               //return 0; 找出原来数组最大的数
               for(int i =0;i<nums.length;i++){
                   for(int j =0;j<nums.length;j++){
                       if(nums[i]<nums[j]){
                           int temp = nums[i];
                           nums[i] = nums[j];
                           nums[j] = temp;
                       }
                   }
                   return nums[0];
               }
           }

        }else if(nums.length == 2){
            if(nums[0] * nums[1] >0){
                return nums[0] * nums[1];
            }else if(nums[0] > nums[1]){
                return nums[0];
            } else {
                return nums[1];
            }
        }else if(nums.length == 1){
            return nums[0];
        }
        return 0;


    }

    /**
     * 二维数组赋值
     * @param result1
     * @param nums
     * @return
     */
    private static int[][] setValueForArray(int[][] result1, int[] nums) {

        for(int j=0;j<nums.length -1;j++){
            for(int i=0;i<nums.length-1-j;i++){
                result1[j][i] = getValue(nums,j,i);
            }

        }

        return result1;
    }

    private static int getValue(int[] nums, int j, int i) {

//        int result =1;
//        //arrays[]
//        for(int i=0;i<j;i++){
//            result *= arrays[i];
//        }
//        System.out.println(result);

//        if(j == 0){
//            return nums[i] * nums[i +1];
//        }else if(j == 1){
//            return nums[i] * nums[i +1] * nums[i +1 + j];
//        }else if(j == 1+1){
//            return nums[i] * nums[i+ 1] * nums[i + 1 + 1] * nums[i + 1 + j];
//        }else if(j == 3){
//            return nums[i] * nums[i+ 1] * nums[i + 1 + 1] * nums[i + 1 + 1 + 1] *nums[i + 1 + j] ;
//        }
        int result = 1;
        for(int m =0;m<j;m++){
            result *= nums[m + 1 + 1];
        }
        result = result * nums[i] * nums[i + 1];
        return result;

    }

    public static int f(int n){
        int sum = 1;
        for(int i = 1;i <= n;++i){
            sum *= i;
        }
        return sum;
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
