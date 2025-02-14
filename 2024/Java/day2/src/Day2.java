import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) throws IOException {
        SafetySystems ss = new SafetySystems();

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

        System.out.println("ALL REPORTS");
        ss.checkLevels(reports);

        System.out.println("\nSafe report count: " + SafetySystems.safeReportCount);
        System.out.println("Unsafe report count: " + SafetySystems.unsafeReportCount);
        System.out.println("Total reports: " + (SafetySystems.safeReportCount + SafetySystems.unsafeReportCount));

        SafetySystems.safeReportCount = 0;
        SafetySystems.unsafeReportCount = 0;

        System.out.println();

        System.out.println("PROBLEM DAMPENER");
        ss.problemDampener(ss.unsafeReports);

        System.out.println();

        System.out.println("UNSAFE REPORTS");
        ss.checkLevels(ss.unsafeReports);

        System.out.println("\nSafe report count: " + SafetySystems.safeReportCount);
        System.out.println("Unsafe report count: " + SafetySystems.unsafeReportCount);
        System.out.println("Total reports: " + (SafetySystems.safeReportCount + SafetySystems.unsafeReportCount));
    }
}
