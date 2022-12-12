package com.demo;

import com.demo.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        context.registerShutdownHook();
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        /*employeeService.listEmployee()
                .forEach(System.out::println);*/

        System.out.println("FindBy Email::");
        System.out.println(employeeService.findEmployeeByEmail("john@gmail.com"));
        System.out.println();
        System.out.println("FindBy FirstName and LastName::");
        System.out.println(employeeService.findEmployeeByFirstAndLastName("Thaw","Thaw"));
        System.out.println();
        System.out.println("Max Salary Employee::");
        System.out.println(employeeService.maxSalary());
        System.out.println();
        System.out.println("find Employees with salary greater than 1000");
        employeeService.findEmployeeBySalaryGreaterThan(1000)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Employees with John or greater than salary 1000");
        employeeService.findEmployeeFirstNameAndSalary("John", 1000)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Group By Employee.......");
        print(employeeService.groupByEmployee());
    }

    private static void print(Iterable iterable){
        for (Object object: iterable){
            Object[] objects = (Object[]) object;
            System.out.println(
                    String.format("%s have in %s persons.", objects[0], objects[1])
            );
        }
    }
}
