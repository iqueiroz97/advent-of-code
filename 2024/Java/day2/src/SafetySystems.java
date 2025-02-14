import java.util.ArrayList;

public class SafetySystems {
    public static int safeReportCount = 0;
    public static int unsafeReportCount = 0;

    public ArrayList<ArrayList<Integer>> safeReports;
    public ArrayList<ArrayList<Integer>> unsafeReports;

    public void checkLevels(ArrayList<ArrayList<Integer>> reports) {
        ArrayList<Integer> report;
        this.safeReports = new ArrayList<>();
        this.unsafeReports = new ArrayList<>();
        int reportNumber = 0;
        int ascending = 0;
        int descending = 0;

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
                    if (((previousLevel - selectedLevel) >= 1) && ((previousLevel - selectedLevel) <= 3)) {
                        descending++;
                    }
                } else if (selectedLevel > previousLevel) {
                    if (((selectedLevel - previousLevel) >= 1) && ((selectedLevel - previousLevel) <= 3)) {
                        ascending++;
                    }
                }
            }

            System.out.println();

            // Check if the report is safe or unsafe
            if ((ascending == report.size() - 1) || (descending == report.size() - 1)) {
                System.out.println("Safe Report");
                safeReportCount++;
                safeReports.add(report);
            } else {
                System.out.println("Unsafe Report");
                unsafeReportCount++;
                unsafeReports.add(report);
            }

            System.out.println("-------------------------------------");

            ascending = 0;
            descending = 0;
            reportNumber++;
        }
    }

    public void problemDampener(ArrayList<ArrayList<Integer>> unsafeReports) {
        ArrayList<Integer> unsafeReport;
        int reportNumber = 0;

        while (reportNumber != unsafeReports.size()) {
            unsafeReport = unsafeReports.get(reportNumber);

            System.out.println();
            System.out.println("Report " + (reportNumber + 1) + ": " + unsafeReports.get(reportNumber));

            // Check the levels of the report
            for (int levelColumn = 1; levelColumn < unsafeReport.size(); levelColumn++) {
                // Get the previous and selected level
                int previousLevel = unsafeReport.get(levelColumn - 1);
                int selectedLevel = unsafeReport.get(levelColumn);

                System.out.println("Previous Level: " + previousLevel + " | Selected level: " + selectedLevel);

                // Check if the difference between the levels is between 1 and 3
                if (((previousLevel - selectedLevel) < 1) && ((previousLevel - selectedLevel) > 3)) {
                    unsafeReport.remove(previousLevel);
                } else if (((selectedLevel - previousLevel) < 1) && ((selectedLevel - previousLevel) > 3) || (previousLevel - selectedLevel == 0)) {
                    unsafeReport.remove(selectedLevel);
                }
            }
            reportNumber++;
        }
    }
}
