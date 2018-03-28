package ca.courseplanner.models;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by leom on 23/03/18.
 */
public class Course {
    private long courseId;
    private String courseNumber;
    private ArrayList<CourseOffering> listOfCourseOffering;

    public Course(CsvModel csvModel) {
        this.courseNumber = csvModel.getCatalogNumber();
        this.listOfCourseOffering = new ArrayList<>();
    }


    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
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

    public static Comparator<Course> CourseNumberComparator = new Comparator<Course>() {
        @Override
        public int compare(Course course1, Course course2) {
            return course1.getCourseNumber().compareTo(course2.getCourseNumber());
        }
    };

}

