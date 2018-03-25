package ca.courseplanner.models;

import java.util.ArrayList;

/**
 * Created by leom on 23/03/18.
 */
public class DumpModel {
    private String subject;
    private String catalogNumber;
    private ArrayList<CourseOffering> listOfCourseOffering;

    public DumpModel(CsvModel csvModel) {
        this.subject = csvModel.getSubject();
        this.catalogNumber = csvModel.getCatalogNumber();
//        CourseOffering courseOffering = new CourseOffering(csvModel);
//        listOfCourseOffering.add(courseOffering);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public ArrayList<CourseOffering> getListOfCourseOffering() {
        return listOfCourseOffering;
    }

    public void setListOfCourseOffering(ArrayList<CourseOffering> listOfCourseOffering) {
        this.listOfCourseOffering = listOfCourseOffering;
    }

    public boolean containCourseOffering(CourseOffering courseOffering){
        ArrayList<CourseOffering> listOfCourseOffering = getListOfCourseOffering();
        for (CourseOffering currentOffering : listOfCourseOffering){
            if (currentOffering.getSemester() == courseOffering.getSemester() && currentOffering.getLocation().equals(courseOffering.getLocation())){
                return true;
            }
        }
        return false;
    }
}

