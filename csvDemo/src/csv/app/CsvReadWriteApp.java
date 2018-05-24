package csv.app;

import csv.handler.CsvFileReader;
import csv.handler.CsvFileWriter;

public class CsvReadWriteApp {

	public static void main(String[] args) {
		String fileName = System.getProperty("user.home") + "/student.txt";

		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);

		System.out.println("\nRead CSV file:");
		CsvFileReader.readCsvFile(fileName);

	}

}
