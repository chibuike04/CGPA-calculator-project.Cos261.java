import java.util.Scanner;

public class CGPACalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int numberOfCourses = scanner.nextInt();

        // Arrays to store grades and credit hours for each course
        String[] grades = new String[numberOfCourses];
        int[] creditHours = new int[numberOfCourses];

        // Get input for each course
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("Enter details for course " + (i + 1) + ":");
            System.out.print("Grade (e.g., A, B+, C): ");
            grades[i] = scanner.next().toUpperCase(); // Convert to uppercase to handle both cases
            System.out.print("Credit hours: ");
            creditHours[i] = scanner.nextInt();
             if (creditHours[i] <= 0) {
                System.out.println("Invalid credit hours. Please enter a positive number for course " + (i+1));
                return; // Exit the program

            }
        }

        // Calculate CGPA
        double totalGradePoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < numberOfCourses; i++) {
            double gradePoint = getGradePoint(grades[i]); // Get grade point for each grade
            if(gradePoint == -1){
                System.out.println("Invalid grade entered for course " + (i+1) + ".  Please enter a valid grade like A, B+, C etc.");
                return;
            }
            totalGradePoints += gradePoint * creditHours[i];
            totalCreditHours += creditHours[i];
        }

        if (totalCreditHours == 0) {
            System.out.println("No credit hours entered. CGPA cannot be calculated.");
            return;
        }
        double cgpa = totalGradePoints / totalCreditHours;

        System.out.println("CGPA: " + String.format("%.2f", cgpa)); // Display CGPA with two decimal places

        scanner.close();
    }

    // Function to get grade point based on the grade. Returns -1 if invalid grade.
    public static double getGradePoint(String grade) {
        double gradePoint;
        if (grade.equals("A")) {
            gradePoint = 5.0;
        } else if (grade.equals("B+")) {
            gradePoint = 4.5;
        } else if (grade.equals("B")) {
            gradePoint = 4.0;
        } else if (grade.equals("C+")) {
            gradePoint = 3.5;
        } else if (grade.equals("C")) {
            gradePoint = 3.0;
        } else if (grade.equals("D")) {
            gradePoint = 2.0;
        } else if (grade.equals("E")) {
            gradePoint = 1.0;
        } else if (grade.equals("F")) {
            gradePoint = 0.0;
        } else {
            gradePoint = -1; // Return -1 for invalid grades
        }
        return gradePoint;
    }
}

