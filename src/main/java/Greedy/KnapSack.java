package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {

    public int value, weight, index;
    public float ratio;

    public KnapSack(int value, int weight, float ratio, int index) {
        this.value = value;
        this.weight = weight;
        this.ratio = ratio;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public float getRatio() {
        return ratio;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfItems = new Scanner(System.in).nextInt();

        KnapSack[] items = new KnapSack[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            String[] arrayTemp = br.readLine().split(" ");

            int value = Integer.parseInt(arrayTemp[0]);
            int weight = Integer.parseInt(arrayTemp[1]);
            float ratio = (float) value / (float) weight;

            items[i] = new KnapSack(value, weight, ratio, i);
        }

        int knapSackCapacity = new Scanner(System.in).nextInt();

        System.out.println(Arrays.toString(items));


        // sort the objects according to profit/weight ratio
        Arrays.sort(items, (o1, o2) -> {

            if (o1.getRatio() < o2.getRatio())
                return 1;
            else
                return -1;
        });

        int profit = 0;
        boolean[] usedOrNot = new boolean[numberOfItems];

        int i;
        for (i = 0; i < items.length; i++) {
            if (knapSackCapacity > items[i].getWeight() && knapSackCapacity > 0) {
                profit += items[i].getValue();
                usedOrNot[items[i].index] = true;
                knapSackCapacity -= items[i].getWeight();
            } else
                break;
        }

        if (knapSackCapacity > 0) {
            usedOrNot[i] = true;
            profit += (knapSackCapacity * items[i].getValue()) / items[i].getWeight();
        }

        System.out.println(profit);
        for (int j = 0; j < items.length; j++) {
            if (usedOrNot[j])
                System.out.print("1  ");
            else
                System.out.print("0  ");
        }

    }
}