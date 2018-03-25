package ca.courseplanner.controllers;

import ca.courseplanner.models.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@RestController
public class ModelDumpController {
    private ArrayList<Course> listOfCourse = new ArrayList<>();
    private final String CSV_PATH = "data/course_data_2016.csv";
    private static final char SEPARATOR = ',';
    private static final char QUOTE = '"';
    private static final char END_LINE = '\n';
    private static final char CARRIAGE_RETURN = '\r';

    @GetMapping("/dump-model")
    public ArrayList<Course> getDumpModel(){
        parseCSVFile();
        return listOfCourse;
    }

    private void parseCSVFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(CSV_PATH));
            while (scanner.hasNext()) {
                ArrayList<String> line = parseLine(scanner.nextLine());
                Course course = new Course(line);
                listOfCourse.add(course);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> parseLine(String csvLine) {
        ArrayList<String> result = new ArrayList<>();
        if (csvLine.isEmpty()) {
            return result;
        }
        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        char[] convert = csvLine.toCharArray();
        for (char currentChar : convert) {
            if (!inQuotes) {
                if (currentChar == SEPARATOR) {
                    result.add(curVal.toString());
                    curVal = new StringBuffer();
                } else if (currentChar == QUOTE){
                    inQuotes = true;
                } else if (currentChar == CARRIAGE_RETURN) {
                    continue;
                } else if (currentChar == END_LINE) {
                    break;
                } else {
                    curVal.append(currentChar);
                }
            } else {
                if (currentChar == QUOTE) {
                    inQuotes = false;
                } else {
                    curVal.append(currentChar);
                }
            }
        }
        result.add(curVal.toString());
        return result;
    }
}
