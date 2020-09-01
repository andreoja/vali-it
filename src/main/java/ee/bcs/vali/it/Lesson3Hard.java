package ee.bcs.vali.it;

import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {
    public static void main(String[] args) {
        randomGame();
    }

    public static int evenFibonacci(int x){
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        return 0;
    }

    public static void randomGame(){
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random randomNumber = new Random();
        int numberToGuess = randomNumber.nextInt(100);
        int numberOfTries = 0;
        Scanner scanner = new Scanner(System.in);
        int guess;
        boolean win = false;

        while (win == false) {
            System.out.println("Guess the number between 1 and 100. ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess == numberToGuess) {
                win = true;
                System.out.println("You guessed the correct number" + guess);
            } else if (guess < numberToGuess) {
                System.out.println("Number too LOW!!!");
            } else if (guess > numberToGuess) {
                System.out.println("Number too High!!!");
            }

        }
        System.out.println("You WIN!!!");
        System.out.println("The number was " + numberToGuess);
        System.out.println("It took "+ numberOfTries + " guesses.");
    }

    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";
    }
}
