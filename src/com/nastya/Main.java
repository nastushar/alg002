package com.nastya;


import java.util.*;


public class Main {


    private static Map<String, Long> map = new HashMap<> ( );

    public static void main( String[] args) {
	int[] arr = {10, 3, 6, 0, 7, 2, 9, -4, 8, 4};
	int[] arr2 = {10, 3, 6, 0, 7, 2, 9, -4, 8, 4};



        task2_1 ( arr , arr2 );
        task2_2_line ( 3 , arr );
        task2_2_binary ( 3 , arr );
        task2_3 ( newArray ( 400 ) );
        task2_4 ( newArray ( 400 ) );
        task2_5 ( newArray ( 400 ) );
        task2_6 ( newArray ( 400 ) );
        compare ();

    }

    private static void task2_2_line ( int findInt, int[] arr ) {
        //линейный поиск
        long t1 = System.nanoTime ( );
        for ( int i = 0 ; i < arr.length ; i++ ) {
            if ( arr[ i ] == findInt ) {
                System.out.println ( "Линейный поиск. Искомое значение находится на позиции №" + (i + 1) );//считаем от 1
            }
        }

        long t2 = System.nanoTime ( );
        System.out.println ("Время прохода "+(t2-t1) );

    }
    private static int task2_2_binary ( int findInt, int[] arr ) {
        System.out.println ("Task2_2" );
        //двоичный поиск
        long t1 = System.nanoTime ( );
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (lastIndex - firstIndex) / 2;
            if ( arr[ middleIndex ] == findInt ) {
               System.out.println ( "Бинарный поиск.Искомое значение находится на позиции №"+ (middleIndex+1));//считаем от 1
                long t2 = System.nanoTime ( );
                System.out.println ("Время прохода "+(t2-t1) );
               return  middleIndex;
            }
            else if (arr[ middleIndex ] > findInt ){
                firstIndex= middleIndex-1;
            }
            else if (arr[ middleIndex ] < findInt ){
                lastIndex= middleIndex+1;
            }
        }

        return -1;
    }

    private static int[] task2_1 ( int[] arr , int[] arr2 ) {
        //сотрировка методом перебора
        System.out.println ("Task2_1" );
        long t1 = System.nanoTime ();
        System.out.println ("Исходный массив "+Arrays.toString ( arr ) );
        System.out.println ("Сравнение массивов " +Arrays.equals ( arr , arr2 ) );
        Arrays.sort ( arr );
        System.out.println ("Отсортированный массив: "+Arrays.toString ( arr ) );
        long t2 = System.nanoTime ();
        System.out.println ("Время прохода "+(t2-t1) );
        return arr;
    }
    public static int[] newArray(int arrLenght){
        int[] array;
        array = new int[arrLenght];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 100) );
        }
        return array;
    }
    public static void  task2_3(int[] array){
        //метод sort
        System.out.println ("Task2_3" );
        System.out.println ("Исходный массив "+Arrays.toString ( array ) );
        long t1 = System.nanoTime ();
        Arrays.sort ( array );
        long t2 = System.nanoTime ();
        System.out.println ("Отсортированный массив "+Arrays.toString ( array ) );
        long tl23 = t2-t1;
        System.out.println ("Время прохода "+tl23 );
        map.put("Метод SORT ", tl23);
        }

    private static void task2_4(int[] array){
        //пузырьковый
        System.out.println ("Task2_4" );
        System.out.println ("Исходный массив "+Arrays.toString ( array ) );
        long t1 = System.nanoTime ();
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) { // измените на < для сортировки по убыванию
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
        long t2 = System.nanoTime ();
        System.out.println ("Отсортированный массив "+Arrays.toString ( array ) );
        long tl24 = t2-t1;
        System.out.println ("Время прохода "+(tl24) );
        map.put("Метод пузырьков ", tl24);
    }
    public static void task2_5 ( int[] array ){
        //сортировка методом выбора
        System.out.println ("Task2_5" );
        System.out.println ("Исходный массив "+Arrays.toString ( array ) );
        long t1 = System.nanoTime ();
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[ i ];
            for ( int j = i + 1 ; j < array.length ; j++ ) {
                if ( array[ j ] < min ) {
                    pos = j;
                    min = array[ j ];
                }
            }

            array[ pos ] = array[ i ];
            array[ i ] = min;
        }
            long t2 = System.nanoTime ();
            System.out.println ("Отсортированный массив "+Arrays.toString ( array ) );
            long tl25 = t2-t1;
            System.out.println ("Время прохода "+(tl25) );
            map.put("Метод выбора ", tl25);

    }
    public static void task2_6(int array[]) {
        //метод вставки
        System.out.println ("Task2_6" );
        System.out.println ("Исходный массив "+Arrays.toString ( array ) );
        long t1 = System.nanoTime ();
        for ( int left = 0 ; left < array.length ; left++ ) {

            int value = array[ left ];

            int i = left - 1;
            for ( ; i >= 0 ; i-- ) {

                if ( value < array[ i ] ) {
                    array[ i + 1 ] = array[ i ];
                } else {

                    break;
                }
            }
            array[ i + 1 ] = value;
        }
        long t2 = System.nanoTime ();
        System.out.println ("Отсортированный массив "+Arrays.toString ( array ) );
        long tl26=t2-t1;
        System.out.println ("Время прохода "+(tl26) );
        map.put("Метод вставки ", tl26);
    }
    public static void compare (){
        System.out.println ("Сортировка методов в порядке наращивания эффективности:\n" );

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

    }
}

