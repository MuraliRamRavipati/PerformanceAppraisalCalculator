package com.wipro.performance.main;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.entity.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by MU391764 on 18-Apr-18.
 */
public class MainClass {
    public static void main(String[] args) throws ParseException{
        EmployeeBean employeeBean = new EmployeeBean();
        Scanner scanner= new Scanner(System.in);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Enter ADID");
        employeeBean.setADID(scanner.next());
        System.out.println("Enter Employee Name");
        scanner.nextLine();
        employeeBean.setEmpName(scanner.nextLine());
        System.out.println("Enter Business Unit");
        employeeBean.setBusinessUnit(scanner.next());
        System.out.println("Enter Date of Joining in this format dd-mm-yyyy");
        String cindate = scanner.next();
        Date doj = dateFormatter.parse(cindate);
        employeeBean.setDateOfJoining(doj);
        System.out.println("Enter Current Salary");
        employeeBean.setCurrentSalary(scanner.nextFloat());
        System.out.println("Enter Total Attendance");
        employeeBean.setTotalAttendance(scanner.nextFloat());
        System.out.println("Enter Manager Rating");
        employeeBean.setManagerRating(scanner.nextFloat());

        String result= Service.getAppraisalDetails(employeeBean);
        System.out.println(result);
    }
}
