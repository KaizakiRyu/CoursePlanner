package ca.courseplanner.controllers;

import ca.courseplanner.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ModelDumpController {
    private ArrayList<Course> listOfCourse = new ArrayList<>();

    @GetMapping("/dump-model")
    public ArrayList<Course> getDumpModel(){
        CsvProcessor csvProcessor = new CsvProcessor();
        CourseModelConverter courseModelConverter = new CourseModelConverter();
        ArrayList<CsvModel> listOfCsvModel = csvProcessor.startProcessor();
        return listOfCourse;
    }

}
