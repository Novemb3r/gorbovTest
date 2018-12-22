package Helpers;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Склад говнокода на тему рандома.
 * Оставь надежду всяк сюда входящий.
 */
public class Random {

    private static void shuffle(int[] array) {
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, ThreadLocalRandom.current().nextInt(i));
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Я еще не начал писать этот метод, но уже
     *
     * @TODO: оптимиировать логику
     */
    public static int[][][] getRandomGameField() {
        int[] buf = new int[49];
        for (int i = 0; i < 49; i++) {
            buf[i] = i;
        }

        shuffle(buf);

        int[][][] result = new int[7][7][2];

        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                if (buf[i * 7 + j] >= 25) {
                    result[i][j][0] = 0;
                    result[i][j][1] = buf[i * 7 + j] - 24;
                } else {
                    result[i][j][0] = 1;
                    result[i][j][1] = buf[i * 7 + j] + 1;
                }
            }
        return result;
    }
}
