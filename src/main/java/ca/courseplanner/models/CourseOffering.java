package ca.courseplanner.models;

import ca.courseplanner.models.CourseSection;
import ca.courseplanner.models.CsvModel;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by leom on 23/03/18.
 */
public class CourseOffering {
    private int semester;
    private String location;
    private ArrayList<String> listOfInstructor;
    private ArrayList<CourseSection> listOfCourseSection;

    public CourseOffering(CsvModel csvModel) {
        this.semester = Integer.parseInt(csvModel.getSemester());
        this.location = csvModel.getLocation();
//        StringTokenizer stringTokenizer = new StringTokenizer(csvModel.getInstructors());
//        while (stringTokenizer.hasMoreTokens()){
//            this.listOfInstructor.add(stringTokenizer.nextToken());
//        }
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getListOfInstructor() {
        return listOfInstructor;
    }

    public void setListOfInstructor(ArrayList<String> listOfInstructor) {
        this.listOfInstructor = listOfInstructor;
    }

    public ArrayList<CourseSection> getListOfCourseSection() {
        return listOfCourseSection;
    }

    public void setListOfCourseSection(ArrayList<CourseSection> listOfCourseSection) {
        this.listOfCourseSection = listOfCourseSection;
    }
}
