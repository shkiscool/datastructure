package com.kk.recursion;

public class MiGong {

    public static void main(String[] args) {
    // 先创建一个二维数组，模拟迷宫
    // 地图
    int[][] map = new int[8][7];
    for (int i = 0; i<7; i++) {
        map[0][i] = 1;
        map[7][i] = 1;
    }
    for(int i = 0; i < 8; i++) {
        map[i][0] = 1;
        map[i][6] = 1;
    }
    map[3][1] = 1;
    map[3][2] = 1;

    for(int i = 0; i < 8; i++){
        for (int j = 0; j < 7; j++) {
            System.out.print(map[i][j]+ " ");
        }
        System.out.println();
    }

    setWay(map, 1,1);

        System.out.println("小球走过路线");
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }

    // 使用递归回溯来给小球找路
    // 1.map表示地图
    // 2.i,j 表示从地图的哪个位置开始出发（1，1）
    // 3.如果小球能到map[6][5]位置，则说明通路找到了
    // 4.约定 当map[i][j]为0表示该点没有走过当为1表示墙；2表示通路可以走，3表示该点已经走过，但是走不通
    // 5.在走迷宫时，需要确定一个策略（方法） 下-》右-》上-》左。如果该点走不通，在回溯
    public static boolean setWay(int[][]map,int i,int j) {
        if (map[6][5] ==2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                // 如果当前的这个节点还没走过
                // 按照策略走
                map[i][j] = 2; //假设该点是可以走通的
                if (setWay(map,i+1,j)) {
                    // 向下走
                    return true;
                }else if (setWay(map,i,j+1)) {
                    //向右走
                    return true;
                }else if (setWay(map,i-1,j)) {
                    // 向上走
                    return true;
                }else if (setWay(map,i,j-1)) {
                    // 向左走
                    return true;
                }else {
                    // 说明该点是走不通的 ，是死路
                    map[i][j] = 3;
                    return false;
                }

            } else {
                // 如果map[i][j] != 0 可能是1，2，3
                return false;
            }
        }

    }
}
