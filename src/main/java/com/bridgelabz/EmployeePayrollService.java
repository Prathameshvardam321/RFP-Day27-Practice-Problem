package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeePayrollService {
    public enum IOService{CONSOLE_IO,FILE_IO,DATABASE_IO};
    private List<EmployeePayroll> employeePayrollList ;

    public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }
    public EmployeePayrollService(){

    }
    private void readEmployeePayRollData(Scanner consoleInputReader){
        System.out.println("Enter Employee id : ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name : ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayroll(id,name,salary));
    }
    private void writeEmployeePayRollData(){
        System.out.println("\nWriting employee payroll Roaster to console \n"+employeePayrollList);

    }
    public static void main(String[] args) {
        ArrayList<EmployeePayroll> arrayList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(arrayList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayRollData(consoleInputReader);
        employeePayrollService.readEmployeePayRollData(consoleInputReader);
        employeePayrollService.writeEmployeePayRollData();
    }
}
