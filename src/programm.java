public class programm {

    double f(double x) {
        return sqrt(1 - x * x);
    }

    double simple_integr(double a, double b, double N) {
        double dx = (b - a) / N;
        double S = 0;

        for (int i = 0; i < N; i++) {
            S += f(0.5 * dx + dx * i);
        }
        return S * dx;
    }

    void mp_integr(double a, double b, double N, int i_th, int np, double*r) {
        double dx = (b - a) / N;
        double S = 0;

        for (int i = i_th; i < N; i += np) {
            S += f(0.5 * dx + dx * i);
        }
        *r = S * dx;
    }

    int main(int argc, char**argv) {
        int N = 1000000000;
        int s;
        int e;
        s = clock();
        double result = 4 * simple_integr(0, 1, 1000000000);
        e = clock();
        System.out.println("you have 1 core\n");
        System.out.println("%.15lf\n" + result);
        System.out.println("%.15lf\n" + M_Pl);
        System.out.println("%.15lf\n" + fabs(result - M_Pl));
        System.out.println("%i" + ((e - s) / 1000));

        //Multicore programming

        int num_proc = std::thread::hardware_concurrency();
        double*r = new double[num_proc];
        std::queue < std::thread * > qu;
        std::thread * t;

        s = clock();
        for (int i = 0; i < num_proc; i++) {
            t = new std::thread (mp_integr, 0, 1, N, i, num_proc, &r[i]);
            qu.push(t);
        }

        while (!qu.empty()) {
            t = qu.front();
            t -> join();
            qu.pop();
        }
        e = clock();

        System.out.println("you have %i core\n" + num_proc);
        double S = 0;
        for (int i = 0; i < num_proc; i++)
            S += r[i];

        System.out.println("%.15lf\n" + (4 * S));
        System.out.println("%i" + ((e - s) / 1000));
        getchar();
        return 0;
    }
}
}
