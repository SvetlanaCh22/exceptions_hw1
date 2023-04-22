/*
Урок 1. Обработка ошибок в программировании.
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

Посмотрите на код, и подумайте сколько разных типов исключений
вы тут сможете получить? Код приложен в виде картинки к семинару.

Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен разности элементов
двух входящих массивов в той же ячейке. Если длины массивов
не равны, необходимо как-то оповестить пользователя.

Автор: Чубченко Светлана
*/

import java.io.File;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {
        // создадим три метода с разными исключениями
        // арифметическая ошибка
        int ret1 = exceptMethod1(10, 0);
        System.out.println(ret1);
        // ошибка чтения из файла
        String ret2 = exceptMethod2("C:\\nofile.bin");
        System.out.println(ret2);
        // ошибка выхода за границы массива
        byte[] arr = new byte[] {1, 2, 3};
        String ret3 = exceptMethod3(arr, 10);
        System.out.println(ret3);
        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        // и возвращающий новый массив, каждый элемент которого равен разности элементов
        // двух входящих массивов в той же ячейке. Если длины массивов не равны,
        // необходимо как-то оповестить пользователя.
        int[] arr1 = new int[] {1, 2, 3};
        int[] arr2 = new int[] {1, 2, 3, 4, 5};
        int[] arr3 = calcArrs(arr1, arr2);
        if (arr3.length > 0) System.out.println(arr3.toString());
    }

    static int exceptMethod1(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return -1;
        }
    }

    static String exceptMethod2(String filename) {
        File file = new File(filename);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = fis.readAllBytes();
            return new String(bytes);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    static String exceptMethod3(byte[] arr, int index) {
        try {
            return Integer.toString(arr[index]);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    static int[] calcArrs(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Arrays has different size");
            return new int[0];
        } else {
            int[] arr3 = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr1[i] - arr2[i];
            }
            return arr3;
        }
    }

}

