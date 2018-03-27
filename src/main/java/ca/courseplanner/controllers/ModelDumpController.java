package ca.courseplanner.controllers;

import ca.courseplanner.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ModelDumpController {
    private ArrayList<Course> listOfCourse = new ArrayList<>();
    private ArrayList<Department> listOfDepartment = new ArrayList<>();

    @GetMapping("/dump-model")
    public ArrayList<Department> getDumpModel(){
        CsvProcessor csvProcessor = new CsvProcessor();
        ArrayList<CsvModel> listOfCsvModel = csvProcessor.startProcessor();
        listOfCsvModel.remove(0);
        CourseModelConverter courseModelConverter = new CourseModelConverter();
        courseModelConverter.startConversion(listOfCsvModel);
        ArrayList<Department> listOfDepartment = courseModelConverter.getListOfConvertedModel();
        this.listOfDepartment.addAll(listOfDepartment);
//        for (Department currentDepartment:listOfDepartment){
//            System.out.println(currentDepartment.getDepartment());
//        }
        return listOfDepartment;
    }
}
