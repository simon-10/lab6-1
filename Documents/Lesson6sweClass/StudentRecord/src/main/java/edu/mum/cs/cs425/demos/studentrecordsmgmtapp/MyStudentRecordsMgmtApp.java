package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class MyStudentRecordsMgmtApp 
{
    public static void main( String[] args )
    {
    	Student s1=new Student(110001,"Dave",LocalDate.of(1951,11,18));
    	Student s2=new Student(110002,"Anna",LocalDate.of(1990,07,12));
    	Student s3=new Student(110003,"Erica",LocalDate.of(1974,01,31));
    	Student s4=new Student(110004,"Carlos",LocalDate.of(2009,8,22));
    	Student s5=new Student(110005,"Bob",LocalDate.of(1990,05,03));

    	Student[] students= {s1,s2,s3,s4,s5};
    	
    	System.out.println("All Students: Ascending order of Names");
    	System.out.println();
    	printListOfStudents(students);
    	
    	
    	List<Student> sts=getListOfPlatinumAlumniStudents(students);
    	System.out.println("===================================");
    	System.out.println();
    	
    	System.out.println("PlatinumAlumni Students: Descending order of Date of Admission");
    	System.out.println();
    	sts.forEach(st->System.out.println(st));
    	
    	
    }
    
    public static void printListOfStudents(Student[] students) {
    	List<Student>studentsList=Arrays.asList(students);
    	
    	List<Student> st=studentsList.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
    	st.forEach(s->System.out.println(s));
    	   	
    }
    
    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students){
    	List<Student>studentsList=Arrays.asList(students);
    	
    	List<Student> st=studentsList.stream()
    			.filter(f->  ChronoUnit.YEARS.between(f.getDateOfAdmission(),LocalDate.now())>=30)
    			.sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).collect(Collectors.toList());
    		
    	return st;
    }
}
