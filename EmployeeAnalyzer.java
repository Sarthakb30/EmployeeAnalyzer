import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAnalyzer {

    public static  void main(String[] args) {
        try {
            // Provide the path to the Excel fileA
            String filePath = "D:\\OneDrive\\Desktop\\Program\\Assignment_Timecard_1.xlsx";

            // Load the Excel workbook
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook =new XSSFWorkbook(fileInputStream);

            // Analyze the workbook and print the results
            analyzeAndPrintEmployees((org.apache.poi.xssf.usermodel.XSSFWorkbook) workbook);

            // Close the workbook and input stream
            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeAndPrintEmployees(XSSFWorkbook workbook) {
        // Initialize variables to store employee data
        List<String> consecutiveDaysEmployees = new ArrayList<>();
        List<String> timeBetweenShiftsEmployees = new ArrayList<>();
        List<String> longShiftEmployees = new ArrayList<>();

        // Assuming the data is in the first sheet (you may need to modify this based on your actual file)
        // Assuming the employee name is in column A, position in column B, and work hours in column C

        // Get the first sheet
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

        // Iterate through rows
        for (Row row : sheet) {
            // Skip header row
            if (row.getRowNum() == 0) {
                continue;
            }

            // Get values from columns
            String name = row.getCell(0).getStringCellValue();
            String position = row.getCell(1).getStringCellValue();
            double workHours = row.getCell(2).getNumericCellValue();

            // Implement your logic for analyzing employees here
            // ...

            // Example: Check for consecutive days
            if (hasConsecutiveDays(row)) {
                consecutiveDaysEmployees.add(name + " - " + position);
            }

            // Example: Check for time between shifts
            if (hasShortTimeBetweenShifts(row)) {
                timeBetweenShiftsEmployees.add(name + " - " + position);
            }

            // Example: Check for long shifts
            if (hasLongShift(row)) {
                longShiftEmployees.add(name + " - " + position);
            }
        }

        // Print results to console
        System.out.println("Employees with 7 consecutive days of work: " + consecutiveDaysEmployees);
        System.out.println("Employees with less than 10 hours between shifts (but greater than 1 hour): " + timeBetweenShiftsEmployees);
        System.out.println("Employees with more than 14 hours in a single shift: " + longShiftEmployees);
    }

    private static boolean hasConsecutiveDays(Row row) {
        // Implement logic to check for consecutive days
        // ...
        return false;
    }

    private static boolean hasShortTimeBetweenShifts(Row row) {
        // Implement logic to check for short time between shifts
        // ...
        return false;
    }

    private static boolean hasLongShift(Row row) {
        // Implement logic to check for long shifts
        // ...
        return false;
    }
}
