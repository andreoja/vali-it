package ee.bcs.vali.it;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) throws FileNotFoundException {
//        exercise1();
//        exercise2(6);
//        exercise3(3, 3);
//        System.out.println(fibonacci(10));
//        exercise5();
//        exercise6();
    }

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras
        int[] massiiv = new int[10];
        Scanner skanner = new Scanner(System.in);
        for (int i=0; i<10; i++) {
            int userInput = skanner.nextInt();
            massiiv[i] = userInput;
        }
        for (int i = massiiv.length-1; i >= 0; i--){
            System.out.println(massiiv[i]);
        }

    }

    public static int exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
        int a = 0;
        for (int i=2; i<100; i+=2){
            if (a<x){
                System.out.print(i + " ");
                a+=1;
            }
        }
        return a;
    }

    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        for (int i=1; i<=x; i++) {
            for (int j=1; j<=y; j++) {
                System.out.print(" " + i*j);
            }
            System.out.println();
        }
    }

    public static int fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
        int c = 0, d=1;
        int sum = 0;
        for (int i=1; i<n; i++) {
            sum = c + d;
            d = c;
            c = sum;
        }
        return sum;
    }

    public static void exercise5() {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
    }

    public static void exercise6() throws FileNotFoundException {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */
        File file = new File("C:\\Users\\opilane\\Desktop\\vali-it\\resources\\visits.txt");
        Scanner scan = new Scanner(file);
        Map<String, String> visits = new HashMap<>();
        while(scan.hasNextLine()) {
            visits.put(scan.next(),scan.next());
            System.out.println(scan.nextLine());
        }
    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }


    }
