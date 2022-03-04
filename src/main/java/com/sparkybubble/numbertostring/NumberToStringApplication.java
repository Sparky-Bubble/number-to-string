package com.sparkybubble.numbertostring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


@SpringBootApplication
public class NumberToStringApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(NumberToStringApplication.class, args);
		display();
	}

	public static void display() throws IOException {
		List<String> data = readIntoFile();
		String[][] array = sortArray(data);

		String[][] filteredArr = Arrays.stream(array)
						.map(row->Arrays.stream(row)
								.filter(Objects::nonNull)
								.toArray(String[]::new))
						.toArray(String[][]::new);

		Stream.of(filteredArr)
				.map(s -> String.join(" \t", s))
				.forEach(System.out::println);
	}

	public static List<String> readIntoFile() throws IOException {
		List<String> data = Files.readAllLines(Paths.get("src/main/resources/nums.txt"));
		return data;
	}

	public static String[][] sortArray(List<String> data){
		int numOfCols = data.size() <= 8 ? 2 : 3;
		int numOfRows = numOfCols == 2 ? 4 : 9;
		String[][] array = new String[numOfRows][numOfCols];
		int indx = 0;
		if(numOfCols == 2) {
			for (int row = 0; row < numOfRows; row++) {
				if (row >= 3) {
					array[row][0] = data.get(indx);
					indx++;
					for (int r2 = 0; r2 < numOfRows; r2++) {
						if (indx == data.size()) {
							break;
						}
						array[r2][1] = data.get(indx);
						indx++;
					}
				} else {
					array[row][0] = data.get(indx);
					indx++;
				}
			}
			System.out.println(data);
		}else{
			//column 1
			for (int r1 = 0; r1 < numOfRows; r1++) {
				if (r1 >= 8) {
					array[r1][0] = data.get(indx);
					indx++;
					//column 2
					for (int r2 = 0; r2 < numOfRows; r2++) {
						if (r2 >= 8) {
							array[r2][1] = data.get(indx);
							indx++;
							//column 3
							for (int r3 = 0; r3 < numOfRows; r3++) {
								if (indx == data.size()) {
									break;
								}if(r3 >= 8){
									array[r3][2] = data.get(indx);
									indx++;
								}else {
									array[r3][2] = data.get(indx);
									indx++;
								}
							}
						}else {
							array[r2][1] = data.get(indx);
							indx++;
						}
					}
				} else {
					array[r1][0] = data.get(indx);
					indx++;
				}
			}
			System.out.println(data);
		}
		return array;
	}
}
