import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1 {
    public static void main(String[] args) throws IOException {
        // Part One
        // Read the input file
        String filePath = "src/resources/input.txt";
        BufferedReader read = new BufferedReader(new FileReader(filePath));

        List<Integer> leftNumbers = new ArrayList<>();
        List<Integer> rightNumbers = new ArrayList<>();

        // Read the file line by line and store the numbers in the left and right lists
        String fileLine;

        while ((fileLine = read.readLine()) != null) {
            leftNumbers.add(Integer.parseInt(fileLine.substring(0, 5)));
            rightNumbers.add(Integer.parseInt(fileLine.substring(8, 13)));
        }

        read.close();

        // Sort the numbers
        Collections.sort(leftNumbers);
        Collections.sort(rightNumbers);

        // Calculate the difference between the numbers and the total amount
        int farApart;
        int totalAmount = 0;
        List<Integer> diferenceBetween = new ArrayList<>();

        for (int arrayLine = 0; arrayLine < leftNumbers.size(); arrayLine++) {
            System.out.println("Line " + (arrayLine + 1) +
                    "\nLeft: " + leftNumbers.get(arrayLine) + " | Right: " + rightNumbers.get(arrayLine));

            farApart = leftNumbers.get(arrayLine) - rightNumbers.get(arrayLine);

            if (farApart < 0) {
                farApart = farApart * -1;
            }

            diferenceBetween.add(farApart);

            System.out.println("Far Apart: " + diferenceBetween.get(arrayLine));
            System.out.println();

            totalAmount += diferenceBetween.get(arrayLine);
        }

        System.out.println("Total Amount: " + totalAmount);

        // Part Two
        
    }
}
