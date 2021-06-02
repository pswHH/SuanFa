package com.pengsw.suanfa;

//定义一个数组


/**
 * 递归的数据结构就是栈
 * left right代表该段数组的起点和终点
 */

public class Test {
    static int[] nums = {5, 2, 6, 8, 4, 7, 9, 1};
    static int n = nums.length - 1;

    public void quick(int left, int right) {
        //已经不满足条件就可以不用递归了
        if (left > right) {
            return;
        }
        //定义俩指针 用于移动
        int start = left;//起点下标
        int end = right;//终点下标
        int temp = nums[left];//把第一个数作为基准点

        pri(left, right);//打印此时的结果，不用在意

        while (start != end) {    //如果左右指针还没有走到一起，代表还有位置没有遍历
            while (start < end && nums[end] >= temp) { //右指针先走，找到小于基准数的停止
                end--;            //这是往左在移动指针
            }
            while (start < end && nums[start] <= temp) { //左指针后走，找到大于基准数的停止
                start++;     //这是往右在移动指针
            }
            if (start < end) {    //如果左右指针在未相遇时都找到了目标，则交换位置
                int i = nums[start];
                nums[start] = nums[end];
                nums[end] = i;
            }
        }
        //此时的left和right走到了一起
        //把基准数与该点交换位置
        nums[left] = nums[start];
        nums[start] = temp;

        prin(start);//打印输出，不用在意

        //以上代码的作用就是把小于基准数的移到左边，把大于基准数的移到右边
        quick(left, start - 1); //继续处理左边的，这里是一个递归的过程
        quick(start + 1, right); //继续处理右边的 ，这里是一个递归的过程

    }

    /**
     * 主程序入口
     */
    public static void main(String[] args) {
        new Test().quick(0, n);
    }


    /**
     * 以下代码忽略即可，用于打印输出
     */
    private void pri(int start, int end) {
        StringBuffer s = new StringBuffer();
        s.append("对数组 [");
        while (start <= end) {
            s.append(nums[start] + " ");
            start++;
        }
        s.append("]");
        s.append(" 排序");
        System.out.print(s);
    }

    private void prin(int j) {
        StringBuffer s = new StringBuffer();
        s.append("， 排序后 [");
        int start = 0;
        while (start <= n) {
            if (start == j) {
                s.append("(" + nums[start] + ") ");
            } else {
                s.append(nums[start] + " ");
            }
            start++;
        }
        s.append("]");
        s.append(" ");
        System.out.println(s);
    }

}