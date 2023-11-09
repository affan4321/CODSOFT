// This is Task 1     <<<< Number Game >>>>

import java.util.*;

public class codSoftTask1 {
    public static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {

        // Local Variables
        int ans;
        int life;
        int score;

        // Initializing scanner object
        Scanner sc = new Scanner(System.in);


        // Game Logic
        while(true){
            
            life = 5;  // User has 5 chances to guess the number
            score = 100;

            // Initiating Random Class instance
            Random rObj = new Random();
            int randomVal = rObj.nextInt(1,100);

            // Display
            print("\n/////////////// Welcome to Number Guessing Game ///////////////\n");
            print("Press 1 to Play\nPress 2 to Exit.");
            ans = sc.nextInt();
            if(ans == 2)
                break;

            // User Input
            print("Enter your guess for the number: ");
            
            ans = sc.nextInt();


            // Comparison conditions

            do{
                print("Score: " + score + "\n");
                if (ans > randomVal) {
                    print("Guess > Answer");
                    ans = sc.nextInt();
                }
                else if(ans < randomVal){
                    print("Guess < Answer");
                    ans = sc.nextInt();
                }

                life--;
                score-=20;
            }while(ans != randomVal && life > 0);

            if(life == 0){
                print("You have lost!");
                print("Your final Score: " + score);
            }
            else{
                print("You won!");
                print("Your final Score: " + score);
            }
        }
        



        sc.close();

    }
    
}