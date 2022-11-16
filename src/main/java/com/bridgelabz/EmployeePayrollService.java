package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.bridgelabz.EmployeePayrollService.IOService.CONSOLE_IO;
import static com.bridgelabz.EmployeePayrollService.IOService.FILE_IO;


public class EmployeePayrollService {

    public enum IOService{CONSOLE_IO,FILE_IO,DATABASE_IO};
    private List<EmployeePayroll> employeePayrollList ;

    public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }
    public EmployeePayrollService(){

    }
    public void readEmployeePayRollData(Scanner consoleInputReader){
        System.out.println("Enter Employee id : ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name : ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayroll(id,name,salary));
    }
    public void writeEmployeePayrollData(IOService ioService) {
        if(ioService.equals(CONSOLE_IO)){
            System.out.println("Writing Employee Payroll Data to Console\n " + employeePayrollList );
        } else if (ioService.equals(IOService.FILE_IO)) {
            new EmployeePayrollIOService().writeData(employeePayrollList);
        }
    }
    public static void main(String[] args) {
        ArrayList<EmployeePayroll> arrayList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(arrayList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayRollData(consoleInputReader);
        employeePayrollService.readEmployeePayRollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
    }
}
