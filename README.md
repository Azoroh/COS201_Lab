# CourseKeeper (Student Course Management System)

A lightweight, console-based Student Course Management System built in Java. This project was developed as the Mid-Semester Lab Assessment for **COS 201: Programming 1** at MIVA Open University.

The system allows students to record, manage, and persist the courses they are taking for the current semester.

## 🚀 Features

- **Add Courses:** Record new courses with a Course Code, Title, and Credit Units.
- **View Directory:** Display a clean list of all currently recorded courses.
- **Search Engine:** Case-insensitive search to locate specific courses by their Course Code.
- **Unit Computation (Recursive):** Calculates the total number of enrolled credit units using a recursive algorithm.
- **Data Persistence:** Automatically saves and loads course data to and from a local `courses.txt` file.
- **Input Validation:** Robust error handling using `try-catch` blocks to prevent crashes from invalid user inputs (e.g., entering strings instead of integers).

## 🛠️ Technical Implementation

- **Language:** Java (OpenJDK 21)
- **Architecture:** Object-Oriented Programming (OOP) using POJOs and an in-memory `ArrayList`.
- **Recursion:** The total unit calculation bypasses standard iteration in favor of a recursive method (`calculateTotalUnits`) that traverses the list index by index until the base case is met.
- **File I/O:** Utilizes `PrintWriter` for data serialization and `Scanner` with `File` for deserializing comma-separated values.

## 💻 How to Run

1. Ensure you have Java (JDK) installed on your machine.
2. Clone this repository and navigate to the project root directory.
3. Compile the Java files:
   ```bash
   javac *.java
   ```
