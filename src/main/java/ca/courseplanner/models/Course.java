package ca.courseplanner.models;

import java.util.ArrayList;

/**
 * Created by leom on 23/03/18.
 */
public class Course {
    private String catalogNumber;
    private ArrayList<CourseOffering> listOfCourseOffering;

    public Course(CsvModel csvModel) {
        this.catalogNumber = csvModel.getCatalogNumber();
        this.listOfCourseOffering = new ArrayList<>();
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

    public void addCourseOffering(CourseOffering courseOffering){
        this.listOfCourseOffering.add(courseOffering);
    }

//    public boolean containCourseOffering(CourseOffering courseOffering){
//        ArrayList<CourseOffering> listOfCourseOffering = getListOfCourseOffering();
//        for (CourseOffering currentOffering : listOfCourseOffering){
//            if (currentOffering.getSemester() == courseOffering.getSemester() && currentOffering.getLocation().equals(courseOffering.getLocation())){
//                return true;
//            }
//        }
//        return false;
//    }

    public CourseOffering findCourseOffering(CourseOffering courseOffering){
        ArrayList<CourseOffering> listOfCourseOffering = getListOfCourseOffering();
        for (CourseOffering currentOffering : listOfCourseOffering){
            if (currentOffering.getSemester() == courseOffering.getSemester() && currentOffering.getLocation().equals(courseOffering.getLocation())){
                return currentOffering;
            }
        }
        return null;
    }

}

