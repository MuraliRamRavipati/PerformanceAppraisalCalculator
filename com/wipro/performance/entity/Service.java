package com.wipro.performance.entity;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.exception.InvalidADIDException;
import com.wipro.performance.exception.InvalidBUException;
import com.wipro.performance.exception.InvalidCurrentSalaryException;
import com.wipro.performance.exception.InvalidDOJException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MU391764 on 18-Apr-18.
 */
public class Service {
    public static String validateData(EmployeeBean ebean) throws ParseException{
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormatter.parse(dateFormatter.format(new Date()));
        if(!ebean.getADID().matches("[a-zA-Z0-9]{6}")){
            return new InvalidADIDException().toString();
        }else if(!ebean.getBusinessUnit().equalsIgnoreCase("JAVA")||ebean.getBusinessUnit().equalsIgnoreCase("Oracle")||ebean.getBusinessUnit().equalsIgnoreCase("BigData")){
            return new InvalidBUException().toString();
        } else if(ebean.getDateOfJoining().compareTo(date)>=0){
            return new InvalidDOJException().toString();
        } else if(ebean.getCurrentSalary()<50000){
            return new InvalidCurrentSalaryException().toString();
        } else if(!(ebean.getTotalAttendance()>=0&&ebean.getTotalAttendance()<=200)){
            return "Invalid Attendance";
        } else if(!(ebean.getManagerRating()>=0&&ebean.getManagerRating()<=5)){
            return "Invalid Rating";
        }
        return "SUCCESS";
    }

    public static String computeAppraisal(EmployeeBean ebean) throws ParseException{
        String msg = validateData(ebean);
        if(msg.equalsIgnoreCase("SUCCESS")){
            int hike=0;
            int rating = Math.round(ebean.getManagerRating());
            if(ebean.getTotalAttendance()>100&&ebean.getTotalAttendance()<151){
                hike=5;
            } else if(ebean.getTotalAttendance()>150&&ebean.getTotalAttendance()<201){
                hike=6;
            }

            switch (rating){
                case 1:hike+=6;
                    break;
                case 2:hike+=7;
                    break;
                case 3:hike+=8;
                    break;
                case 4:hike+=9;
                    break;
                case 5:hike+=10;
                    break;
            }
            float salary = ebean.getCurrentSalary()+ebean.getCurrentSalary()*hike/100;
            return String.valueOf(salary);
        }
        return msg;
    }

    public static String getAppraisalDetails(EmployeeBean ebean) throws ParseException{
        String msg = computeAppraisal(ebean);
        try{
            ebean.setCurrentSalary(Float.parseFloat(msg));
            return ebean.getADID()+":"+msg;
        } catch (NumberFormatException e){
            return ebean.getADID()+":"+msg;
        }
    }
}
