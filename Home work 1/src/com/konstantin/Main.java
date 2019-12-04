package com.konstantin;



public class Main {

    public static void main(String[] args) {
        worker wrk = new worker();

        // 1.Определение максимального числа из двух чисел
        int num1 = 26;
        int num2 = 99;
        String result = wrk.getMaxNum(num1, num2);
        if (result == "equal") System.out.println("Числа равны");
        else System.out.println(result);

        // 2.Определение века по году
        int year = 1100;

        System.out.println( wrk.getCentury(year) );

        // 3.Определение високосного года
        year = 2020;

        System.out.println( wrk.isLeapYear(year) );

        // 4.Заполнение одномерного массива числами от 1 до 10
        int[] nums_arr = new int[10];
        int start = 0;

        while (start < 10) {
            nums_arr[start] = ++start;
        }
        // Вывод результата
        System.out.print('[');
        for (int num : nums_arr) {
            if( num != 10 )
                System.out.print(num + ", ");
            else
                System.out.print(num);
        }
        System.out.println(']');

        //  5.Вывод линейного массива
        double[] arr = new double[]{ 3.14, 2.727665, 6.7266, -2.34800, 1.26666, 1235};
        int flag = 0;

        System.out.print('[');
        for( double k : arr ){
            String fNum = String.format("%.2f", k);
            if( ++flag == arr.length ) System.out.print(fNum);
            else System.out.print(fNum + "; ");
        }
        System.out.println(']');

        //  6. Посчитать сумму цифр
        int numForCount = 963;
        int summa = wrk.getNumSumm(numForCount);

        System.out.println("Сумма числа " + numForCount + " равняется " + summa);

        //  *7. Делится ли число на 3 -- Fixed 05/09/2019
        String[] divByThree = new String[]{"123", "489", "100853", "33333333", "7", "0"};

        for( String k : divByThree ){
            System.out.println( wrk.divisibleByThree(k) );
        }

        // *8. Привести интервал к читаемому виду -- Fixed 05/09/2019
        int timeInterval = 91536001;

        System.out.println( wrk.formatInterval(timeInterval) );
    }
}
