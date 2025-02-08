import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day2 {
    public static void main(String[] args) throws IOException {
        // Part One
        // Read the input file
        String filePath = "src/resources/input.txt";
        BufferedReader read = new BufferedReader(new FileReader(filePath));

        ArrayList<ArrayList<Integer>> reports = new ArrayList<>();

        String fileLine;

        // Add the report lines to the reports array as numbers
        while ((fileLine = read.readLine()) != null) {
            ArrayList<Integer> report = new ArrayList<>();

            // Split the line by space and add the numbers to the report array
            for (String level : fileLine.split(" ")) {
                report.add(Integer.parseInt(level));
            }

            // Add the report array to the reports array
            reports.add(report);
        }

        read.close();

        checkLevels(reports);
    }

    private static void checkLevels(ArrayList<ArrayList<Integer>> reports) {
        ArrayList<Integer> report;
        int reportNumber = 0;
        int ascending = 0;
        int descending = 0;
        int safeReportCount = 0;
        int unsafeReportCount = 0;

        while (reportNumber != reports.size()) {
            report = reports.get(reportNumber);

            System.out.println();
            System.out.println("Report " + (reportNumber + 1) + ": " + reports.get(reportNumber));

            // Check the levels of the report
            for (int levelColumn = 1; levelColumn < report.size(); levelColumn++) {
                // Get the previous and selected level
                int previousLevel = report.get(levelColumn - 1);
                int selectedLevel = report.get(levelColumn);

                System.out.println("Previous Level: " + previousLevel + " | Selected level: " + selectedLevel);

                // Check if the levels are ascending or descending
                if (previousLevel > selectedLevel) {
                    // Check if the difference between the levels is between 1 and 3
                    if (((previousLevel - selectedLevel) > 0) && ((previousLevel - selectedLevel) < 4)) {
                        descending++;
                    }
                } else if (selectedLevel > previousLevel) {
                    if (((selectedLevel - previousLevel) > 0) && ((selectedLevel - previousLevel) < 4)) {
                        ascending++;
                    }
                }
            }

            System.out.println();

            // Check if the report is safe or unsafe
            if ((ascending == report.size() - 1) || (descending == report.size() - 1)) {
                System.out.println("Safe Report");
                safeReportCount++;
            } else {
                System.out.println("Unsafe Report");
                unsafeReportCount++;
            }

            System.out.println("-------------------------------------");

            ascending = 0;
            descending = 0;
            reportNumber++;
        }

        System.out.println("\nSafe report count: " + safeReportCount);
        System.out.println("Unsafe report count: " + unsafeReportCount);
        System.out.println("Total reports: " + (safeReportCount + unsafeReportCount));
    }
}
