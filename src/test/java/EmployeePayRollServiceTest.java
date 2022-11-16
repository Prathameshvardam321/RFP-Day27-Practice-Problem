import com.bridgelabz.EmployeePayroll;
import com.bridgelabz.EmployeePayrollIOService;
import com.bridgelabz.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeePayRollServiceTest {

    @Test
    public void givenThreeEmployee_WhenWrittenToFile_ShouldMatchEmployeeEntries(){
        EmployeePayroll[] payRollServiceTests = {
                new EmployeePayroll(1,"Arvind",21020),
                new EmployeePayroll(2,"Baja",34222.2),
                new EmployeePayroll(3,"Raja",77389)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(payRollServiceTests
        ));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        long entry = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,entry);
    }
    @Test
    public void method_Should_Return_Entries_On_Reading_From_File(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entry = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,entry);
    }

}
