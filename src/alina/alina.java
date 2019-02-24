package alina;
import java.util.*;
import java.time.Clock;

public class alina {

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

/*            //multicore programming
            int num_proc = std::thread.hardware_concurrency();
            double[] r = new double[num_proc];
            LinkedList<std::thread > qu = new LinkedList<std::thread > ();
            std::thread t;

            s = clock();
            for (int i = 0; i < num_proc; i++) {
                t = new std::thread (mp_integr, 0, 1, N, i, num_proc, r[i]);
                qu.offer(t);
            }
            while (!qu.isEmpty()) {
                t = qu.peek();
                t.join();
                qu.poll();
            }
            */
            long start2 = System.nanoTime();
            long end2 = System.nanoTime();
            int num_proc = 0;

            System.out.printf("you have %i core\n" + num_proc);
            double S = 0;
            int[] r = new int [num_proc];
            for (int i = 0; i < num_proc; i++) {
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

