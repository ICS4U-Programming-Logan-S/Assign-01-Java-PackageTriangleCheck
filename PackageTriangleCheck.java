import java.util.Scanner;

/**
* This program either receives the properties
* of a package or 2 angles of a triangle.
* it then either calculates if the package
* is acceptable or what type of triangle
* they entered based on the angle.
*
* @author Logan S
* @version 1.0
*
* @since   2023-03-08
*/

public final class PackageTriangleCheck {

    /**
    * This is a private constructor.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private PackageTriangleCheck() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check package acceptance");
            System.out.println("2. Check triangle type and area");
            System.out.println("3. Quit");

            // Get user's choice
            System.out.print("Enter your choice (1/2/3): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            // Perform the chosen operation
            switch (choice) {
                case 1:
                    // Get package details from user
                    final float weight;
                    final float length;
                    final float width;
                    final float height;
                    try {
                        System.out.print("Enter package weight (in kg): ");
                        weight = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter package length (in cm): ");
                        length = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter package width (in cm): ");
                        width = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter package height (in cm): ");
                        height = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.println("Invalid input. Please enter a "
                            + "valid number.");
                        continue;
                    }

                    // Check package acceptance
                    final float volume = length * width * height;
                    if (weight > 27f) {
                        System.out.println("Sorry, package weight exceeds "
                            + "27 kg limit.");
                    } else if (volume > 10000f) {
                        System.out.println("Sorry, package volume exceeds "
                            + "10,000 cubic cm limit.");
                    } else {
                        System.out.println("Package accepted!");
                    }
                    break;

                case 2:
                    // Get angle values from user
                    final float angle1;
                    final float angle2;
                    try {
                        System.out.print("Enter angle 1 (in degrees): ");
                        angle1 = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter angle 2 (in degrees): ");
                        angle2 = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.println("Invalid input. Please enter a "
                            + "valid number.");
                        continue;
                    }

                    // Check if triangle is valid
                    if (angle1 + angle2 >= 180f) {
                        System.out.println("Sorry, these angles do not "
                            + "form a valid triangle.");
                    } else {
                        // Determine triangle type and calculate area
                        if (angle1 == angle2) {
                            if (angle1 == 60f) {
                                System.out.println("The triangle is "
                                    + "equilateral.");
                            } else {
                                System.out.println("The triangle is "
                                    + "isosceles.");
                            }
                        } else {
                            System.out.println("The triangle is scalene.");
                        }
                        final double area = 0.5f * 10f * 10f
                            * (1 - (Math.cos(Math.toRadians(angle1))
                                    * Math.cos(Math.toRadians(angle2))
                                    + Math.sin(Math.toRadians(angle1))
                                    * Math.sin(Math.toRadians(angle2))));
                        System.out.println("The area of the triangle is: "
                            + area);
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a "
                        + "valid number.");
                    break;
            }
            // Closing scanner
            scanner.close();
        } while (true);
    }
}
