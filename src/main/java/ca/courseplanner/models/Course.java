package ca.courseplanner.models;

import java.util.ArrayList;
import java.util.Comparator;


public class Course {
    private String semester;
    private String subject;
    private String catalogNumber;
    private String location;
    private String enrolmentCapacity;
    private String enrolmentTotal;
    private String instructors;
    private String componentCode;
    private final int SEMESTER_INDEX = 0;
    private final int SUBJECT_INDEX = 1;
    private final int CATALOG_NUMBER_INDEX = 2;
    private final int LOCATION_INDEX = 3;
    private final int ENROLMENT_CAPACIITY_INDEX = 4;
    private final int ENROLMENT_TOTAL_INDEX = 5;
    private final int INSTRUCTORS_INDEX = 6;
    private final int COMPONENT_CODE_INDEX = 7;

    public Course() {
    }

    public Course(ArrayList<String> currentLine) {
        this.semester = currentLine.get(SEMESTER_INDEX);
        this.subject = currentLine.get(SUBJECT_INDEX);
        this.catalogNumber = currentLine.get(CATALOG_NUMBER_INDEX);
        this.location = currentLine.get(LOCATION_INDEX);
        this.enrolmentCapacity = currentLine.get(ENROLMENT_CAPACIITY_INDEX);
        this.enrolmentTotal = currentLine.get(ENROLMENT_TOTAL_INDEX);
        this.instructors = currentLine.get(INSTRUCTORS_INDEX);
        this.componentCode = currentLine.get(COMPONENT_CODE_INDEX);
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEnrolmentCapacity() {
        return enrolmentCapacity;
    }

    public void setEnrolmentCapacity(String enrolmentCapacity) {
        this.enrolmentCapacity = enrolmentCapacity;
    }

    public String getEnrolmentTotal() {
        return enrolmentTotal;
    }

    public void setEnrolmentTotal(String enrolmentTotal) {
        this.enrolmentTotal = enrolmentTotal;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public static Comparator<Course> SubjectCatalogNumberSemesterLocationComparator = new Comparator<Course>() {
        @Override
        public int compare(Course course1, Course course2) {
            int subjectCompare = course1.subject.compareTo(course2.subject);
            if (subjectCompare == 0) {
                int catalogCompare = course1.catalogNumber.compareTo(course2.catalogNumber);
                if (catalogCompare == 0) {
                    int semesterCompare = course1.semester.compareTo(course2.semester);
                    if (semesterCompare == 0) {
                        return course1.location.compareTo(course2.location);
                    } else {
                        return semesterCompare;
                    }
                } else {
                    return catalogCompare;
                }
            } else {
                return subjectCompare;
            }
        }
    };

//    public static Comparator<Course> SemesterComparator = new Comparator<Course>() {
//        @Override
//        public int compare(Course course1, Course course2) {
//            return course1.semester - course2.semester;
//        }
//    };
}
