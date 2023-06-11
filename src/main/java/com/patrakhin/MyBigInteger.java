package com.patrakhin;

import java.util.ArrayList;
import java.util.List;

public class MyBigInteger {
    private static final int BLOCK_SIZE = 1000000;  // Размер блока
    private List<Long> blocks;  // Список блоков числа

    public MyBigInteger(String number) {
        blocks = new ArrayList<>();

        // Делим число на блоки заданного размера
        int startIndex = number.length();
        int endIndex = Math.max(0, number.length() - BLOCK_SIZE);
        while (startIndex > 0) {
            String blockStr = number.substring(endIndex, startIndex);
            long block = Long.parseLong(blockStr);
            blocks.add(block);

            startIndex = endIndex;
            endIndex = Math.max(0, endIndex - BLOCK_SIZE);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Преобразуем блоки числа в строку, начиная с последнего блока
        for (int i = blocks.size() - 1; i >= 0; i--) {
            sb.append(blocks.get(i));
        }

        return sb.toString();
    }

    // Здесь можно добавить реализацию математических операций над BigInteger

    public static void main(String[] args) {
        String numberStr = "123456789123456789123456789";
        MyBigInteger myBigInteger = new MyBigInteger(numberStr);
        System.out.println(myBigInteger.toString());
    }
}
