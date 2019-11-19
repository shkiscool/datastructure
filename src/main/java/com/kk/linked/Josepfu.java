package com.kk.linked;

public class Josepfu {
    public static void main(String[] args) {

    }


}
// 创建一个环行链表
class CircleSingleLinkedList {
    // 创建一个first节点当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    public void addBoy (int nums) {
        // nums 做一个数据的校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        // 创建一个辅助指针。帮助构建环形链表
        Boy curBoy = null;
        // 使用 for来创建我们的环形链表
        for(int i = 1; i <= nums; i++) {
            //根据编号，创建小孩的节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if(i ==1){
                first = boy;
                first.setNext(first); // 构成环
                curBoy = first; //让curboy指向第一个小屁孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    // 遍历当前的环形链表
    public void showBoy() {
        // 判断链表是否为空
        if(first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        // 因为first 不能动， 因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext() == first) { //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); //后移
        }
    }
    // 根据用户的输入，计算小孩的 出圈顺序
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误请重新输入");
            return;
        }
        // 创建一个辅助指针帮助完成小孩的出圈
        Boy helper = first;
        // 需求创建一个辅助指针变量 herler 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true) {
            if(helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //

        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }
}

// 创建一个boy类 表示一个节点
class Boy {
    private int no; //boy的编号
    private Boy next;// 指向下一个节点

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
    public Boy (int no) {
        this.no = no;
    }
}