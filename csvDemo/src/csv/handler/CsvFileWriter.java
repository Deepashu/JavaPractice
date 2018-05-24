package csv.handler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csv.model.Student;


public class CsvFileWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "id,firstName,lastName,gender,age";

	public static void writeCsvFile(String fileName) {
		
		//Create new students objects
		Student student1 = new Student(1, "Ruchira", "Bhat", "F", 8);
		Student student2 = new Student(2, "Arya", "Achwan", "F", 7);
		Student student3 = new Student(3, "Pratyusha", "Raut", "F", 9);
		Student student4 = new Student(4, "Dhruv", "Gowda", "M", 10);
		Student student5 = new Student(5, "Shamanth", "Murthy", "M", 12);
		Student student6 = new Student(6, "Deepesh", "Reshi", "M", 11);
		
		//Create a new list of student objects
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Student student : students) {
				fileWriter.append(String.valueOf(student.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getFirstName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getLastName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getGender());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(student.getAge()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}
