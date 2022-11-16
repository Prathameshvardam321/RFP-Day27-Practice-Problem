package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollIOService {

    public final static String FILE_NAME = "employee.txt";
    public void writeData(List<EmployeePayroll> employeePayrolls) {
        StringBuffer stringBuffer = new StringBuffer();
        employeePayrolls.stream().forEach(employee -> {
            String employeeString = employee.toString().concat("\n");
            stringBuffer.append(employeeString);
        });
        try {
            Files.write(Paths.get(FILE_NAME), stringBuffer.toString().getBytes());
        }catch (IOException e){
           e.printStackTrace();
        }
    }
    public void printData(){
        try {
        Files.lines(new File(FILE_NAME).toPath()).forEach(System.out::println);
    }catch (IOException e){
            e.printStackTrace();
        }
}
}
