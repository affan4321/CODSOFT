// This is Task 2     <<<< Word Counter >>>>

import java.util.*;
import java.io.*;

public class codSoftTask2 {
    public static void print(String str) { 
        System.out.println(str);
    }

    public static void main(String[] args) {

        // Local Variables
        String wordString = "";
        String Data;
        int wordCounter = 0;

        // Initializing scanner object
        Scanner sc = new Scanner(System.in);

        // Game Logic
        print("Press 1 to enter data directly\nPress 2 to enter from File\n");
        if(sc.nextInt() == 1){
            sc.nextLine();
            wordString = sc.nextLine();
            // Use regular expression to split words based on whitespace and punctuation
            String[] words = wordString.split("[\\s\\p{Punct}]+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCounter++;
                    print("Next word: " + word);
                }
            }

            print("\nTotal words found: " + wordCounter + "\n");
        }
        else{
            // Initializing File object
            File myFile = new File("C:\\GitHub\\CodSoft\\data.txt");

            try {
                if (myFile.exists()) {
                    Scanner fsc = new Scanner(myFile);
                    print("File Opened!");
                    while (fsc.hasNextLine()) {
                        Data = fsc.next();
                        // Use regular expression to split words based on whitespace and punctuation
                        String[] words = Data.split("[\\s\\p{Punct}]+");
                        for (String word : words) {
                            if (!word.isEmpty()) {
                                wordCounter++;
                                print("Next word: " + word);
                            }
                        }
                    }
                    fsc.close();

                    print("\nTotal words found: " + wordCounter + "\n");
                } else {
                    print("File doesn't exist!");
                }
            } catch (FileNotFoundException e) {
                // Handle the exception here, e.g., print an error message.
                print("File not found: " + e.getMessage());
            }
        }

        sc.close();

    }
    
}