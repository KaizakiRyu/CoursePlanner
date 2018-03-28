package ca.courseplanner.models;

import java.util.*;

/**
 * Created by leom on 23/03/18.
 */
public class CourseModelConverter {
    ArrayList<Department> listOfConvertedModel;

    public ArrayList<Department> getListOfConvertedModel() {
        return listOfConvertedModel;
    }

    public CourseModelConverter() {
        this.listOfConvertedModel = new ArrayList<>();
    }

    public void startConversion(ArrayList<CsvModel> listOfCsvModel){
        convertModel(listOfCsvModel);
//        ArrayList<Department> listOfDepartment = getListOfConvertedModel();
        printListOfDepartment();
    }

    private void printListOfDepartment() {
        ArrayList<Department> listOfDepartment = getListOfConvertedModel();
        for (Department currentDepartment:listOfDepartment){

            System.out.println(currentDepartment.getDepartment());
            ArrayList<Course> listOfCourse = currentDepartment.getListOfCourses();
            Collections.sort(listOfCourse, Course.CourseNumberComparator);
            for (Course currentCourse : listOfCourse){
                System.out.println("        " + currentCourse.getCourseNumber());
                System.out.println();
            }
            System.out.println();
        }
    }

    private void convertModel(ArrayList<CsvModel> listOfCsvModel) {
        ArrayList<String> listOfDepartmentName = new ArrayList<>();
        ArrayList<Department> listOfDepartment = new ArrayList<>();
        for (CsvModel currentModel : listOfCsvModel){
            listOfDepartmentName.add(currentModel.getDepartment());
        }

        listOfDepartmentName = removeDuplicateDepartment(listOfDepartmentName);

        for (String currentDepartmentName:listOfDepartmentName){
            Department newModel = new Department(currentDepartmentName);
            listOfDepartment.add(newModel);
        }

        for (CsvModel currentModel:listOfCsvModel){
            for (Department currentDepartment:listOfDepartment){
                // if found department
                if (currentModel.getDepartment().equals(currentDepartment.getDepartment())){
                    addCourseToDepartment(currentModel, currentDepartment);
                }
            }
        }

        listOfConvertedModel.addAll(listOfDepartment);


//        for (Course currentCourse: convertModel){
//            for (CsvModel currentModel : listOfCsvModel){
//                if (currentCourse.getSubject().equals(currentModel.getDepartment()) && currentCourse.getCourseNumber().equals(currentModel.getCourseNumber())) {
//                    CourseOffering courseOffering = new CourseOffering(currentModel);
//                    CourseOffering currentCourseOffering = currentCourse.findCourseOffering(courseOffering);
//                    if (currentCourseOffering != null) {
//                        currentCourseOffering.addInstructor(currentModel.getInstructors());
//                    } else {
//                        currentCourse.addCourseOffering(courseOffering);
//                    }
//                    CourseSection courseSection = new CourseSection(currentModel);
//                    CourseSection currentCourseSection = currentCourseOffering.findCourseSection(courseSection);
//                }
//            }
//        }

//        for (CsvModel currentModel:listOfCsvModel){
//            for (Department currentDepartment:listOfDepartment){
//                // if found department
//                if (currentModel.getDepartment().equals(currentDepartment.getDepartment())){
//                    Course newCourse = new Course(currentModel);
//                    CourseOffering newOffering = new CourseOffering(currentModel);
//                    CourseSection newSection = new CourseSection(currentModel);
//                    Course findCourse = currentDepartment.findCourse(newCourse);
//                    //if that department does not have a course
//                    if (findCourse == null){
//                        //add the course(course code) of the current csv model
//                        newCourse.addCourseOffering(newOffering);
//                        newOffering.addCourseSection(newSection);
//                        newOffering.addInstructor(currentModel.getInstructors());
//                        currentDepartment.addCourse(newCourse);
//                    } else {
//                        CourseOffering findOffering = findCourse.findCourseOffering(newOffering);
//                        //if the course does not have the course offering(semester) of the current csv model
//                        if (findOffering == null){
//                            //add the course offering of the current csv model to the course (course code)
//                            newOffering.addCourseSection(newSection);
//                            newOffering.addInstructor(currentModel.getInstructors());
//                            findCourse.addCourseOffering(newOffering);
//                        } else {
//                            CourseSection findSection = findOffering.findCourseSection(newSection);
//                            //if found the section of the current csv model
//                            if (findSection != null){
//                                //increment enrolment capacity, total, and add instructors for the other section
//                                findSection.addEnrolmentCapacity(Integer.parseInt(currentModel.getEnrolmentCapacity()));
//                                findSection.addEnrolmentTotal(Integer.parseInt(currentModel.getEnrolmentTotal()));
//                                findOffering.addInstructor(currentModel.getInstructors());
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    private void addCourseToDepartment(CsvModel currentModel, Department currentDepartment) {
        Course newCourse = new Course(currentModel);
        CourseOffering newOffering = new CourseOffering(currentModel);
        CourseSection newSection = new CourseSection(currentModel);
        Course findCourse = currentDepartment.findCourse(newCourse);
        //if that department does not have a course
        if (findCourse == null){
            //add the course(course code) of the current csv model
            addCourse(currentModel, currentDepartment, newCourse, newOffering, newSection);
        } else {
            addCourseOfferingToCourse(currentModel, newOffering, newSection, findCourse);
        }
    }

    private void addCourse(CsvModel currentModel, Department currentDepartment, Course newCourse, CourseOffering newOffering, CourseSection newSection) {
        newCourse.addCourseOffering(newOffering);
        newOffering.addCourseSection(newSection);
        newOffering.addInstructor(currentModel.getInstructors());
        currentDepartment.addCourse(newCourse);
    }

    private void addCourseOfferingToCourse(CsvModel currentModel, CourseOffering newOffering, CourseSection newSection, Course findCourse) {
        CourseOffering findOffering = findCourse.findCourseOffering(newOffering);
        //if the course does not have the course offering(semester) of the current csv model
        if (findOffering == null){
            //add the course offering of the current csv model to the course (course code)
            addCourseOffering(currentModel, newOffering, newSection, findCourse);
        } else {
            addCourseSectionToCourseOffering(currentModel, newSection, findOffering);
        }
    }

    private void addCourseSectionToCourseOffering(CsvModel currentModel, CourseSection newSection, CourseOffering findOffering) {
        CourseSection findSection = findOffering.findCourseSection(newSection);
        //if found the section of the current csv model
        if (findSection != null){
            //increment enrolment capacity, total, and add instructors for the other section
            addCourseSection(currentModel, findOffering, findSection);
        }
    }

    private void addCourseSection(CsvModel currentModel, CourseOffering findOffering, CourseSection findSection) {
        findSection.addEnrolmentCapacity(Integer.parseInt(currentModel.getEnrolmentCapacity()));
        findSection.addEnrolmentTotal(Integer.parseInt(currentModel.getEnrolmentTotal()));
        findOffering.addInstructor(currentModel.getInstructors());
    }

    private void addCourseOffering(CsvModel currentModel, CourseOffering newOffering, CourseSection newSection, Course findCourse) {
        newOffering.addCourseSection(newSection);
        newOffering.addInstructor(currentModel.getInstructors());
        findCourse.addCourseOffering(newOffering);
    }


    private ArrayList<String> removeDuplicateDepartment(ArrayList<String> oldModel){
        ArrayList<String> converted = new ArrayList<>();
        Set<String> removedDuplicate = new HashSet<>();
        removedDuplicate.addAll(oldModel);
        converted.clear();
        converted.addAll(removedDuplicate);
        return converted;
    }

//    public boolean findCourse(CsvModel csvModel){
//        ArrayList<Course> listOfCourse = getListOfConvertedModel();
//        for (Course currentModel : listOfCourse){
//            if (currentModel.getSubject().equals(csvModel.getDepartment()) && currentModel.getCourseNumber().equals(csvModel.getDepartment())){
//                return true;
//            }
//        }
//        return false;
//    }
}