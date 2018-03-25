package ca.courseplanner.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leom on 23/03/18.
 */
public class CsvProcessor {
    private ArrayList<CsvModel> listOfCourse = new ArrayList<>();
    private final String CSV_PATH = "data/course_data_2018.csv";
    private static final char SEPARATOR = ',';
    private static final char QUOTE = '"';
    private static final char END_LINE = '\n';
    private static final char CARRIAGE_RETURN = '\r';

    public CsvProcessor() {
    }

    public ArrayList<CsvModel> startProcessor(){
        parseCSVFile();
        printCourse();
        return listOfCourse;
    }

    private void parseCSVFile(){
        try {
            Scanner scanner = new Scanner(new File(CSV_PATH));
            while (scanner.hasNext()) {
                ArrayList<String> csvLine = parseLine(scanner.nextLine());
                CsvModel csvCourseFormat = new CsvModel(csvLine);
                listOfCourse.add(csvCourseFormat);
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
                } else if (currentChar == CARRIAGE_RETURN) {
                    continue;
                } else {
                    curVal.append(currentChar);
                }
            }
        }
        result.add(curVal.toString());
        return result;
    }

    private void printCourse(){
        for (CsvModel currentCourse : listOfCourse){
            System.out.println(currentCourse.getSemester() + " " + currentCourse.getSubject() + " " + currentCourse.getCatalogNumber() + " "
                    + currentCourse.getLocation() + " " + currentCourse.getEnrolmentCapacity() + " " + currentCourse.getEnrolmentTotal() + " "
                    + currentCourse.getInstructors() + " " + currentCourse.getComponentCode());
        }
    }
}

