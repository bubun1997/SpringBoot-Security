package com.soumya.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import com.soumya.entity.Laptop;
import com.soumya.entity.Student;
import com.soumya.exception.ResourceNotFoundException;

@Service
public class StudentService {
	
	
	private static final List<Student> STUDENT_LIST;
	
	static {
		
		  STUDENT_LIST = new ArrayList<Student>(
				           List.of(
				  
				        Student.
				        builder().
				        studentId(1001L).
				        studentName("Soumyajit").
				        email(
				        		 Arrays.asList(
				        				      "soumyajit4banerjee@gmail.com",
				        				      "bubun41997@gmail.com"
				        				 
				        				 )
				        		).
				        laptops(
				        		   List.of(
				        				      Laptop.
				        				      builder(). 
				        				      laptopId(1001L). 
				        				      laptopBrand("Dell"). 
				        				      laptopPrice(45000.00).
				        				      build(),
				        				      
				        				      Laptop.
				        				      builder(). 
				        				      laptopId(1002L). 
				        				      laptopBrand("Lenovo"). 
				        				      laptopPrice(42000.00).
				        				      build()
				        				      
				        				      
				        			     )
				        		
				        		).build(),
				        Student.
				        builder().
				        studentId(1002L).
				        studentName("Mohan").
				        email(
				        		   Arrays.asList(
				        				   
				        				       "mohan_verma@gmail.com",
				        				       "verma1999@gmail.com",
				        				       "kaisu_dev@rediffmail.com"

				        				   )
				        		   
				        		).
				        laptops(
				        		   List.of(
				        				      Laptop.
				        				      builder(). 
				        				      laptopId(1003L). 
				        				      laptopBrand("Asus"). 
				        				      laptopPrice(47000.00).
				        				      build(),
				        				      
				        				      Laptop.
				        				      builder(). 
				        				      laptopId(1004L). 
				        				      laptopBrand("Mac"). 
				        				      laptopPrice(60000.00).
				        				      build(),
				        				      
				        				      Laptop.
				        				      builder(). 
				        				      laptopId(1005L). 
				        				      laptopBrand("Hp"). 
				        				      laptopPrice(35000.00).
				        				      build()
				        				      
				        				      
				        				      
				        			     )
				        		
				        		).build()
				        
				        
				  )
				);
		
	}

	
	public List<Student> getAllStudents(){
		
		return STUDENT_LIST;
	}
	
	public Student getStudentById(Long id) {
		
		return STUDENT_LIST.
				stream().
				filter(
						student -> student.getStudentId().equals(id)
						
						).findAny().orElseThrow(
								
								    () -> ResourceNotFoundException.
								    		builder().
								    		message("Student not found with id : "+id).build()

								);
	}


    public Student addStudent(Student student) {
    	
    	STUDENT_LIST.add(student);
    	return student;
    }
}
