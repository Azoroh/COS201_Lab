import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {

  private ArrayList<Course> courses = new ArrayList<>();

  public void addCourse(Course course) {
    courses.add(course);
    System.out.println("Course added successfully.");
  }

  public void viewAllCourses() {
    if (courses.isEmpty()) {
      System.out.println("No courses recorded yet.");
      return;
    }
    System.out.println("\n--- Recorded Courses ---");
    for (Course c : courses) {
      System.out.println(
        c.getCode() + " - " + c.getTitle() + " (" + c.getUnits() + " units)"
      );
    }
  }

  public void searchCourse(String code) {
    String searchCode = code.trim().toUpperCase();
    for (Course c : courses) {
      if (c.getCode().toUpperCase().equals(searchCode)) {
        System.out.println(
          "Found: " +
            c.getCode() +
            " - " +
            c.getTitle() +
            " (" +
            c.getUnits() +
            " units)"
        );
        return;
      }
    }
    System.out.println("Course not found.");
  }

  //recursive method
  public int calculateTotalUnits(int index) {
    if (index >= courses.size()) {
      return 0; //base case
    }
    return courses.get(index).getUnits() + calculateTotalUnits(index + 1); //recursive call
  }

  public void saveToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(new File(filename))) {
      for (Course c : courses) {
        writer.println(c.getCode() + "," + c.getTitle() + "," + c.getUnits());
      }
      System.out.println("Courses saved to " + filename);
    } catch (FileNotFoundException e) {
      System.out.println("Error saving file: " + e.getMessage());
    }
  }

  public void loadFromFile(String filename) {
    courses.clear(); //clear current list before loading
    try (Scanner fileScanner = new Scanner(new File(filename))) {
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split(",");
        if (parts.length == 3) {
          courses.add(
            new Course(parts[0], parts[1], Integer.parseInt(parts[2]))
          );
        }
      }
      System.out.println("Courses loaded from " + filename);
    } catch (FileNotFoundException e) {
      System.out.println("No existing save file found. Starting fresh.");
    } catch (Exception e) {
      System.out.println("Error reading file data.");
    }
  }
}
