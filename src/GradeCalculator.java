/*
 * Class: CMSC203 
 * Instructor: [Insert Instructor Name]
 * Description: A file-driven grade calculator that validates configuration files, 
 * processes student scores using category loops, provides interactive 
 * plus/minus grading options, and exports a written report.
 * Due: [Insert Due Date]
 * Platform/compiler: Eclipse / Java SE
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: [Insert Your Name]
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        String courseName = "";
        int numCategories = 0;
        String cat1Name = "";
        int cat1Weight = 0;
        String cat2Name = "";
        int cat2Weight = 0;
        String cat3Name = "";
        int cat3Weight = 0;
        String studentFName = "";
        String studentLName = "";
        
        boolean usedDefaultConfig = false;
        
        try {
            File configFile = new File("gradeconfig.txt");
            Scanner configScanner = new Scanner(configFile);
            
            if (configScanner.hasNextLine()) {
                courseName = configScanner.nextLine();
            }
            if (configScanner.hasNextInt()) {
                numCategories = configScanner.nextInt();
            }
            configScanner.nextLine();
            if (configScanner.hasNextLine()) {
                cat1Name = configScanner.next();
            }
            if (configScanner.hasNextInt()) {
                cat1Weight = configScanner.nextInt();
            }
            configScanner.nextLine();
            if (configScanner.hasNextLine()) {
                cat2Name = configScanner.next();
            }
            if (configScanner.hasNextInt()) {
                cat2Weight = configScanner.nextInt();
            }
            configScanner.nextLine();
            if (configScanner.hasNextLine()) {
                cat3Name = configScanner.next();
            }
            if (configScanner.hasNextInt()) {
                cat3Weight = configScanner.nextInt();
            }
            
            configScanner.close();
            
            if ((cat1Weight + cat2Weight + cat3Weight) != 100) {
                System.out.println("Warning: Invalid configuration weights total. Using default configuration.");
                courseName = "CMSC203 Computer Science I";
                numCategories = 3;
                usedDefaultConfig = true;
                cat1Name = "Projects";
                cat1Weight = 40;
                cat2Name = "Quizzes";
                cat2Weight = 30;
                cat3Name = "Exams";
                cat3Weight = 30;
            } else {
                System.out.println("Configuration loaded successfully.");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Warning: gradeconfig.txt not found. Using default configuration.");
            courseName = "CMSC203 Computer Science I";
            numCategories = 3;
            usedDefaultConfig = true;
            cat1Name = "Projects";
            cat1Weight = 40;
            cat2Name = "Quizzes";
            cat2Weight = 30;
            cat3Name = "Exams";
            cat3Weight = 30;
        }

        System.out.println("Active Course: " + courseName);
        System.out.println("Categories to process: " + numCategories + ": " + cat1Name + " " + cat2Name + " " + cat3Name);
        
        try {
            File inputFile = new File("grades_input.txt");
            Scanner inputScanner = new Scanner(inputFile);
            
            if (inputScanner.hasNextLine()) {
                studentFName = inputScanner.nextLine();
                studentLName = inputScanner.nextLine();
            }
            
            double totalWeightedPoints = 0;
            int totalWeightExecuted = 0;
            
            for (int c = 0; c < numCategories; c++) {
                if (!inputScanner.hasNextLine()) {
                    break;
                }
                String inputCat = inputScanner.nextLine().toLowerCase();
                int inputCatCount = inputScanner.nextInt();            
                double catAvg = 0;
                int currentWeight = 0;
                
                if (inputCat.equals(cat1Name.toLowerCase()) || inputCat.equals(cat2Name.toLowerCase()) || inputCat.equals(cat3Name.toLowerCase())) {
                    if (inputCat.equals(cat1Name.toLowerCase())) {
                        currentWeight = cat1Weight;
                    } else if (inputCat.equals(cat2Name.toLowerCase())) {
                        currentWeight = cat2Weight;
                    } else if (inputCat.equals(cat3Name.toLowerCase())) {
                        currentWeight = cat3Weight;
                    }
                    inputScanner.nextLine();
                    
                    double catSum = 0;
                    for (int i = 0; i < inputCatCount; i++) {
                        catSum += inputScanner.nextDouble();
                    }
                    catAvg = catSum / inputCatCount;
                    
                    if (inputCat.equals(cat1Name.toLowerCase())) {
                        System.out.println(cat1Name + " category grade: " + catAvg);
                    } else if (inputCat.equals(cat2Name.toLowerCase())) {
                        System.out.println(cat2Name + " category grade: " + catAvg);
                    } else if (inputCat.equals(cat3Name.toLowerCase())) {
                        System.out.println(cat3Name + " category grade: " + catAvg);
                    }
                    
                    totalWeightedPoints += (catAvg * currentWeight);
                    totalWeightExecuted += currentWeight;
                    inputScanner.nextLine();
                } else {
                    System.out.println("Error: " + inputCat + " doesn't match configurations.. Skipping Category");
                    for (int s = 0; s < inputCatCount; s++) {
                        if (inputScanner.hasNext()) {
                            inputScanner.next(); 
                        }
                    }
                    inputScanner.nextLine();
                }
            }
            inputScanner.close();
            
            double finalGrade = 0.0;
            if (totalWeightExecuted > 0) {
                finalGrade = totalWeightedPoints / totalWeightExecuted;
            }
            System.out.println(finalGrade);
            
            Scanner keyboard = new Scanner(System.in);
            char plusMinusInpt = 'x';
            while (plusMinusInpt != 'y' && plusMinusInpt != 'n') {
                System.out.println("Apply +/- grading (Y/N)? ");
                plusMinusInpt = keyboard.next().charAt(0);
                plusMinusInpt = Character.toLowerCase(plusMinusInpt);
            }
            
            String finalLetterGrade = "F";
            
            if (plusMinusInpt == 'y') {
                if (finalGrade >= 96.0) {
                    finalLetterGrade = "A+";
                } else if (finalGrade >= 93.0) {
                    finalLetterGrade = "A";
                } else if (finalGrade >= 90.0) {
                    finalLetterGrade = "A-";
                } else if (finalGrade >= 86.0) {
                    finalLetterGrade = "B+";
                } else if (finalGrade >= 83.0) {
                    finalLetterGrade = "B";
                } else if (finalGrade >= 80.0) {
                    finalLetterGrade = "B-";
                } else if (finalGrade >= 76.0) {
                    finalLetterGrade = "C+";
                } else if (finalGrade >= 73.0) {
                    finalLetterGrade = "C";
                } else if (finalGrade >= 70.0) {
                    finalLetterGrade = "C-";
                } else if (finalGrade >= 66.0) {
                    finalLetterGrade = "D+";
                } else if (finalGrade >= 63.0) {
                    finalLetterGrade = "D";
                } else if (finalGrade >= 60.0) {
                    finalLetterGrade = "D-";
                } else {
                    finalLetterGrade = "F";
                }
            } else {
                if (finalGrade >= 90.0) {
                    finalLetterGrade = "A";
                } else if (finalGrade >= 80.0) {
                    finalLetterGrade = "B";
                } else if (finalGrade >= 70.0) {
                    finalLetterGrade = "C";
                } else if (finalGrade >= 60.0) {
                    finalLetterGrade = "D";
                } else {
                    finalLetterGrade = "F";
                }
            }
            
            keyboard.close();
            
            System.out.println("Student: " + studentFName + " " + studentLName);
            System.out.println("Final Letter Grade: " + finalLetterGrade);
            
            try {
                PrintWriter writer = new PrintWriter("grades_report.txt");
                writer.println("Active Course: " + courseName);
                writer.println("Student: " + studentFName + " " + studentLName);
                writer.println("Final Grade: " + finalGrade);
                writer.println("Final Letter Grade: " + finalLetterGrade);
                writer.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error creating output file.");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Warning: grades_input.txt not found. Please upload input information. " + "\n" + "Exit Finalized.");
        }
    }
}