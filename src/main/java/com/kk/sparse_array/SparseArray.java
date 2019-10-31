package com.kk.sparse_array;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组11*11
        // 0:表示没有棋子1：表示黑子 2 表示篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 二维数组 转 稀疏数组思路
        // 1、先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2、创建 对应的 稀疏数组
        int spareseArr[][] = new int[sum + 1][3];
        //3、 给稀疏数组赋值
        spareseArr[0][0] = 11;
        spareseArr[0][1] = 11;
        spareseArr[0][2] = sum;

        //遍历二维数组 赋值稀疏数组
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    spareseArr[count][0] = i;
                    spareseArr[count][1] = j;
                    spareseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组如下");
        File file = new File("D://map.txt");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        String s = JSONObject.toJSONString(spareseArr);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(s.getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < spareseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spareseArr[i][0], spareseArr[i][1], spareseArr[i][2]);
        }

        //将稀疏数组 --》恢复 原始的二维数组
        //先读取稀疏数组的第一行 根据第一行的数据创建原始的二维数组
        String str = null;
        StringBuilder strs = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                strs.append(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<Integer>> lists = (List<List<Integer>>) JSON.parseObject(strs.toString(),
                new TypeReference<List<List<Integer>>>() {
                });

        int[][] chessArr2 = new int[lists.get(0).get(0)][lists.get(0).get(1)];
        for (int i = 1; i < lists.size(); i++) {
            chessArr2[lists.get(i).get(0)][lists.get(i).get(1)] = lists.get(i).get(2);
        }
        System.out.println("恢复后的棋盘");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        int[][] arr = new int[2][3];
        System.out.println(arr.length);
    }
}
