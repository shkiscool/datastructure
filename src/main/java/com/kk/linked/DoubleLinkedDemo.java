package com.kk.linked;

public class DoubleLinkedDemo {

}

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2();

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表
    public void show() {

        if (head.next == null) {
            System.out.println("没有数据");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环的时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;

    }
}

class HeroNode2 {

    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; // 指向下一个节点 默认为null
    public HeroNode2 pre;  // 指向前一个节点 默认为null

    public HeroNode2() {

    }

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}
