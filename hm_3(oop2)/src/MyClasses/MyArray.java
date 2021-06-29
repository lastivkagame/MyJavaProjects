package MyClasses;

import java.util.Arrays;
import java.util.Random;

public class MyArray implements IMath, ISort {

    public int[]arr;

    public MyArray(int len) {
        this.arr = new int[len];
    }

    public void FillArr(int min, int max){
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) + 1) + min;
        }
    }

    public void Show() {
        for (int item :
                this.arr) {
            System.out.printf("%d\t", item);
        }
    }

    @Override
    public int Max() {
        int[]temp = this.arr;
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }

    @Override
    public int Min() {
        int[]temp = this.arr;
        Arrays.sort(temp);
        return temp[0];
    }

    @Override
    public float Avg() {
        int res=0;

        for (int i=0;i<arr.length;i++){
            res +=arr[i];
        }

        float avg = res / arr.length;

        return avg;
    }

    @Override
    public void SortAsc() {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public void SortDesc() {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] > arr[i-1]) {
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
