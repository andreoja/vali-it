package ee.bcs.vali.it;

public class Lesson3 {

    public static void main(String[] args) {
//        System.out.println(sum(5,7));
//        int[] sum={23,45,6,16,10};
//        System.out.println(sum(sum));
//        System.out.println(factorial(5));
//        int[] sorting = {12,32,3,56,7,1};
//        System.out.println(Arrays.toString(sort(sorting)));
//        String a = "Test";
//        System.out.println(reverseString(a));
//        System.out.println(isPrime(25));


    }

    public static int sum(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        int summa = x+y;
        return summa;
    }

    public static int sum(int[] x){
        // Todo liida kokku kõik numbrid massivis x
        int summa = 0;
        for (int i=0;i< x.length; i++){
            summa = summa + x[i];
        }
        return summa;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int vastus=1;
        for (int i=0;i<x;i++){
            vastus = vastus*(x-i);
        }
        return vastus;
    }

    public static int[] sort(int[] number) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        int tempA;
        for (int i=0; i<number.length; i++){
            for (int j=0; j<number.length-1; j++){
                if (number[j]>number[j+1]){
                    tempA = number[j];
                    number[j] = number[j+1];
                    number[j+1] = tempA;
                }
            }
        }
        return number;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        String reverse = "";
        for (int i = a.length()-1;i>=0; i--){
            reverse = reverse + a.charAt(i);
        }
        return reverse;
    }

    public static boolean isPrime(int x){
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)

        for (int i=2; i<x/2; ++i) {
            if (x % i == 0) {
                return true;
            }
        }
        return false;
    }

}
