//Тема: Переменные, условия, циклы, массивы, методы

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {
        public static Scanner in = new Scanner(System.in);

        public static void main(String[] args) {

            //#region Задание 1
            /*Выведите на экран надпись "Your time is limited, so don’t waste it living someone else’s life" Steve Jobs на разных строках.
            Пример вывода:
                “Your time is limited,
                    so don’t waste it
                        living someone else’s life”
                            Steve Jobs*/

            //Task_1();

            //#endregion

            //#region Задание 2
            /*Пользователь вводит с клавиатуры два числа. Первое число — это значение, второе число процент,
             который необходимо посчитать. Например, мы ввели с клавиатуры 50 и 10.
             Требуется вывести на экран 10 процентов от 50. Результат: 5*/

            //Task_2();

            //#endregion

            //#region Задание 3
            /*Пользователь вводит с клавиатуры три цифры. Необ-ходимо создать число, содержащее эти цифры.
             Например, если с клавиатуры введено 7, 3, 8, тогда нужно сформи-ровать число 738.*/

            //Task_3();

            //#endregion

            //#region Задание 4
            /*Пользователь вводит шестизначное число. Необходимо поменять в этом числе первую и шестую цифры,
             а также вторую и пятую цифры. Например, 723895 должно превратиться в 593827.
             Если пользователь ввел не шестизначное число тре-буется вывести сообщение об ошибке.*/

            //Task_4();

            //#endregion

            //#region Задание 5
            /*Пользователь вводит с клавиатуры номер месяца (от 1 до 12).
            В зависимости от полученного номера месяца программа выводит на экран надпись:
             Winter (если введено значение 1,2 или 12),
             Spring (если введено значение от 3 до 5),
             Summer (если введено значение от 6 до 8),
             Autumn(если введено значение от 9 до 11).
             Если пользователь ввел значение не в диапазоне от 1 до 12 требуется вывести сообщение об ошибке*/

            //Task_5();

            //#endregion

            //#region Задание 6
            /*Пользователь вводит с клавиатуры количество метров.
            В зависимости от выбора пользователя программа переводит метры в мили, дюймы или ярды.*/

            //Task_6();

            //#endregion

            //#region Задание 7
            /*Пользователь вводит с клавиатуры два числа. Нужно показать все нечетные числа в указанном диапазоне.
            Если границы диапазона указаны неправильно требуется произвести нормализацию границ.
             Например, пользователь ввел 20 и 11, требуется нормализация, после которой начало диапазона станет равно 11, а конец 20.*/

            //Task_7();

            //#endregion

            //#region Задание 8
            /*Показать на экран таблицу умножения в диапазоне, указанном пользователем.
             Например, если пользователь указал 3 и 5, таблица может выглядеть так:
             3*1 = 3 3*2 = 6 3*3 = 9 ............ 3* 10 = 30
             ............................................................
             5*1 = 5 5 *2 = 10 5 *3 = 15 .............*/

            //Task_8();

            //#endregion

            //#region Задание 9
            /*В одномерном массиве, заполненном случайными числами, определить минимальный и максимальный элементы,
            посчитать количество отрицательных элементов, посчитать количество положительных элементов, посчитать количество нулей.
            Результаты вывести на экран. */

            //Task_9();

            //#endregion

            //#region Задание 10
            /*Есть одномерный массив, заполненный случайными числами. На основании данных этого массива нужно:
                ■  Создать одномерный массив, содержащий только четные числа из первого массива;
                ■  Создать одномерный массив, содержащий только нечетные числа из первого массива;
                ■  Создать одномерный массив, содержащий только отрицательные числа из первого массива;
                ■  Создать одномерный массив, содержащий только положительные числа из первого массива */

            //Task_10();

            //#endregion

            //#region Задание 11
            /*Напишите метод, который отображает горизонтальную или вертикальную линию из некоторого символа.
             Метод принимает в качестве параметра: длину линии, направление, символ*/

            //Task_11();

            //#endregion

            //#region Задание 12
            /*Напишите метод, сортирующий массив по убыванию или возрастанию в зависимости от выбора пользователя.*/

            Task_12();

            //#endregion
        }

    public static int FillArrByRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static void Show(int[] arr) {
        for (int item :
                arr) {
            System.out.printf("%d\t", item);
        }
        System.out.println();
    }

    public static void Task_1(){
        System.out.println("\t“Your time is limited, \n\t\t so don’t waste it \n\t\t\t living someone else’s life” \n\t\t\t\t Steve Jobs");
    }

    public static void Task_2(){

        System.out.println("Enter number: ");
        int num = in.nextInt();

        System.out.println("Enter persent: ");
        int persent = in.nextInt();

        System.out.printf("%s persent from %s is %s", persent, num, (persent / 100.00)*num);

    }

    public static void Task_3(){
        System.out.println("Enter first digit: ");
        int num1 = in.nextInt();

        System.out.println("Enter second digit: ");
        int num2 = in.nextInt();

        System.out.println("Enter third digit: ");
        int num3 = in.nextInt();

        String str = String.valueOf(num1) +String.valueOf(num2)+String.valueOf(num3);

        int res=Integer.parseInt(str);

        System.out.printf("Result: %s", res);
    }

    public static void Task_4(){
        System.out.println("Enter number: ");
        int num = in.nextInt();
        int condition = num / 100000;

        if(condition >= 1 && condition < 10){
            int second = num / 10000;
            int first = second / 10;

            second %= 10;

            int last = num %  100;
            int under_last = last / 10;
            last %=10;

            int center = num % 10000 / 100;

            String resalt = String.valueOf(last) + String.valueOf(under_last) + String.valueOf(center) + String.valueOf(second) + String.valueOf(first);

            System.out.printf("Resalt: %s", resalt);
        }
        else{
            System.out.println("Error! You input incorrect number!");
        }
    }

    public static void Task_5(){
        System.out.println("Enter number of month: ");
        int num = in.nextInt();

        switch (num)
        {
            case 1:
            case 2:
            case 12:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Not correct number!");
                break;
        }
    }

    public static void Task_6(){
        System.out.println("Enter number of meters: ");
        int num = in.nextInt();

        System.out.println("Menu \n 1.To Mile\n 2.To Inches \n 3.To Yards");

        System.out.println("Choose a number: ");
        int choose = in.nextInt();

        switch (choose){
            case 1:
                System.out.printf("Resalt: %s", (num * 0.000621371192237334));
                break;
            case 2:
                System.out.printf("Resalt: %s", (num * 39.370078740157));
                break;
            case 3:
                System.out.printf("Resalt: %s", (num * 1.0936132983));
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }

    public static void Task_7(){
        System.out.println("Enter begin of diapason: ");
        int begin = in.nextInt();

        System.out.println("Enter end of diapason: ");
        int end = in.nextInt();

        if(begin > end){
            int temp = begin;
            begin = end;
            end = temp;
        }

        System.out.print("Not even: ");

        for (int i = begin; i<end; i++){
            if(i % 2 != 0){
                System.out.print(i + ", ");
            }
        }

        System.out.println();
    }

    public static void Task_8() {
        System.out.println("Enter begin of diapason: ");
        int begin = in.nextInt();

        System.out.println("Enter end of diapason: ");
        int end = in.nextInt();

        if(begin > end){
            int temp = begin;
            begin = end;
            end = temp;
        }

        for (int i=begin; i<=end;i++)
        {
            for (int j=1; j<=10;j++)
            {
                System.out.printf("%s * %s = %s, ", i, j, i*j);
            }
            System.out.println();
        }
    }

    public static void Task_9(){
        int n = 10;
        int plus=0, minus=0, nuls = 0;
        int[] arr = new int[n];

        System.out.print("Arr: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = FillArrByRandom(-10, 10);
            System.out.print(arr[i]+", ");
        }

        System.out.println();

        Arrays.sort((arr));

        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i]<0){
                minus++;
            }
            else if(arr[i]>0){
                plus++;
            }
            else{
                nuls++;
            }
        }

        System. out. println("Minimum = " + arr[0]);
        System. out. println("Maximum = " + arr[arr.length-1]);

        System. out. println("el > 0: " + plus);
        System. out. println("el < 0: " + minus);
        System. out. println("el == 0: " + nuls);
    }

    public static void Task_10(){
        int n = 10;
        int plus=0, minus=0, nuls = 0;
        int[] arr = new int[n];

        System.out.print("Arr: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = FillArrByRandom(-10, 10);
            System.out.print(arr[i]+", ");
        }

        System.out.println();

        Arrays.sort((arr));

        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i]<0){
                minus++;
            }
            else if(arr[i]>0){
                plus++;
            }
            else{
                nuls++;
            }
        }

        int even = 0, not_even=0;
        for (int i = 0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                not_even++;
            }
            else{
                even++;
            }
        }

        int[] even_arr = new int[even];
        int[] not_even_arr = new int[not_even];

        int[] plus_arr = new int[plus];
        int[] minus_arr = new int[minus];

        even = not_even = plus = minus = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i]<0){
                minus_arr[minus++] = arr[i];
            }
            else if(arr[i]>0){
                plus_arr[plus++] = arr[i];
            }

            if(arr[i] % 2 == 0){
                even_arr[even++] = arr[i];
            }
            else{
                not_even_arr[not_even++] = arr[i];
            }
        }

        System.out.println("Minus: ");
        Show(minus_arr);

        System.out.println("Plus: ");
        Show(plus_arr);

        System.out.println("Not even: ");
        Show(not_even_arr);

        System.out.println("Even: ");
        Show(even_arr);
    }

    public static void Task_11(){

            ShowLine(5, false, '*');
            ShowLine(15, true, '@');
    }

    public static void ShowLine(int lenght, boolean is_horisontal, char symbol){
            for (int i=0;i<lenght;i++){
                System.out.print(symbol);

                if(!is_horisontal){
                    System.out.println();
                }
            }
    }

    public static void Task_12(){
            int n=10;
            int[] arr = new int[n];
            System.out.print("Arr: ");

            for (int i = 0; i < arr.length; i++) {
                arr[i] = FillArrByRandom(-10, 10);
                System.out.print(arr[i]+", ");
            }

            System.out.println("Menu \n 1.By Up\n 2.By down \n ");

            System.out.println("Choose a number: ");
            int choose = in.nextInt();

            switch (choose){
                case 1:
                    BubbleSortUp(arr);
                    Show(arr);
                    break;
                case 2:
                    BubbleSortDown(arr);
                    Show(arr);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
    }

    public static void BubbleSortUp(int[] a) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void BubbleSortDown(int[] a) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = a.length - 1; i > 0; i--) {
                if (a[i] > a[i-1]) {
                    temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void InsertionSortUp(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            array[j+1] = current;
        }
    }
}
