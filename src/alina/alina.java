package alina;

import java.util.*;
import java.time.Clock;

public class alina extends java.lang.Thread {

    //   import java.util.tangible

    // public class GlobalMembers {
    ///#define _USE_MATH_DEFINES

    public static double f(double x) {
        return Math.sqrt(1 - x * x);
    }

    public static double simple_integr(double a, double b, double N) {
        double dx = (b - a) / N;
        double S = 0;

        for (int i = 0; i < N; i++) {
            S += f(0.5 * dx + dx * i);
        }
        return S * dx;
    }

    public static void mp_integr(double a, double b, double N, int i_th, int np) {
        double dx = (b - a) / N;
        double S = 0;
        double r = 0;

        for (int i = i_th; i < N; i += np) {
            S += f(0.5 * dx + dx * i);
        }
        r = S * dx;
    }

    public static void Main(String[] args) {
        int N = 1000000000;
        int s;
        int e;
        long start = System.nanoTime();
        double result = 4 * simple_integr(0, 1, 1000000000);
        long end = System.nanoTime();
        System.out.print("you have 1 core\n");
        System.out.printf("%.15lf\n" + result);
        System.out.printf("%.15lf\n" + Math.PI);
        System.out.printf("%.15lf\n" + Math.abs(result - Math.PI));
        System.out.printf("%i" + (end - start) / 1000);


//Java multicore

        alina num_proc = new alina();   //наследуем класс
        System.out.println("Main Thread started");
        for (int i = 0; i < 6; i++) {
            new alina("Thread" + i).start();
            //t.start();
            try {
                alina.join();
            }
            catch (InterruptedException b){
                System.out.println("$b has been interrupted", alina.getName());
            }
        }
        System.out.println("Main Thread finished");




            /*            //multicore programming

https://habr.com/ru/post/182610/

https://habr.com/ru/post/164487/

https://metanit.com/java/tutorial/8.2.php

http://developer.alexanderklimov.ru/android/java/thread.php


            int num_proc = std::thread.hardware_concurrency();  максимально допустимое число одновременно выполняемых потоков.
                                                                Если значение не определено или не поддаётся вычислению, возвращается 0.
            double[] r = new double[num_proc];  Первая часть – объявление указателя, вторая часть – выделение памяти под массив
            LinkedList<std::thread > qu = new LinkedList<std::thread > ();  реализует одностороннюю очередь.
                                                                            В данном случае создали очередь с типом std::thread* , и присвоили ей имя qu.
            std::thread t;  что-то делаем с потоком, при этом t является идентификатором потока.

            s = clock();    возвращает число тактов, прошедшее с момента запуска программы.
            for (int i = 0; i < num_proc; i++) {
                t = new std::thread (mp_integr, 0, 1, N, i, num_proc, r[i]);
                qu.offer(t);
            }
                    запуск цикла. До тех пор, пока выполняется цикл, происходит добавление нового элемента в поток.
                    Для добавления в очередь нового элемента нужно воспользоваться функцией — push().
                    В круглых скобках должно находится значение, которое мы хотим добавить.

            while (!qu.isEmpty()) {
                t = qu.peek();
                t.join();
                qu.poll();
            }
                    запуск цикла. До тех пор, пока выполняется цикл, происходит добавление нового элемента в поток.
                    Для добавления в очередь нового элемента нужно воспользоваться функцией — push().
                    В круглых скобках должно находится значение, которое мы хотим добавить.
                    join() блокирует выполнение других потоков, пока не завершится дочерний.
                    qu.pop() удаляет элемент из очереди.
            */
        long start2 = System.nanoTime();
        long end2 = System.nanoTime();

        System.out.printf("you have %i core\n" + num_proc);
        double S = 0;
        int[] r = new int[num_proc];
        for (alina i = 0; i < num_proc; i++) {
            S += r[i];
        }

        System.out.printf("%.15lf\n" + 4 * S);
        System.out.printf("%i" + (end2 - start2) / 1000);
        //System.in.read();
    }
}

//package tangible;

//----------------------------------------------------------------------------------------
//	Copyright © 2006 - 2019 Tangible Software Solutions, Inc.
//	This class can be used by anyone provided that the copyright notice remains intact.
//
//	This class is used to replicate the ability to pass arguments by reference in Java.
//----------------------------------------------------------------------------------------
//   public final class RefObject<T> {
//     public T argValue;
//
//      public RefObject(T refArg) {
//        argValue = refArg;
//        }
// }

