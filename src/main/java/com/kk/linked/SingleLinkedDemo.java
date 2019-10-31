package com.kk.linked;

public class SingleLinkedDemo {

    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();

        singleLinked.add(new HeroNode(1, "kk", "KKISCOOL"));
        singleLinked.add(new HeroNode(1, "mm", "KKISCOOL"));
        singleLinked.add(new HeroNode(1, "cc", "KKISCOOL"));

        singleLinked.show();
    }
}
class SingleLinked {

    public HeroNode head = new HeroNode();

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        if (head.nextHeroNode == null) {
            head.nextHeroNode = heroNode;
            return;
        }
        while (true) {
            if (temp.nextHeroNode == null) {
                temp.nextHeroNode = heroNode;
                break;
            }
            temp = temp.nextHeroNode;
        }
    }

    public void show() {
        HeroNode temp = head;
        if (head.nextHeroNode == null) {
            System.out.println("没有数据");
            return;
        }
        while (true) {
            if (temp.nextHeroNode == null) {
                return;
            }
            System.out.println(temp.nextHeroNode);
            temp = temp.nextHeroNode;
        }
    }
}

class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode nextHeroNode;

    public HeroNode() {

    }

    public HeroNode(int no, String name, String nickName) {
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