package tests;

import models.Employee;
import org.junit.*;

import webpages.Employee.EmployeesPage;

public class EmployeeTest extends BaseTest {

    @Test
    public void verifyEmployeeCRUDFunctionality() {
        EmployeesPage employeesPage = new EmployeesPage(driver);

        // 1. Navigate to Employees Page
        employeesPage.navigate();

        // 2. Verify if the following employee to be added is in the list
        //      First name: John
        //      Last name: Doe
        Employee employeeDetails = new Employee("John", "Doe");

        // 3. If the employee exists, Delete the target employee
        while (employeesPage.doesEmployeeExist(employeeDetails)) {
            employeeDetails.setID(employeesPage.getEmployeeIDFromTableRow(employeeDetails));

            employeesPage.deleteEmployee(employeeDetails);
        }

        Assert.assertFalse(
                "Employee " + employeeDetails.getFirstName() + " " + employeeDetails.getLastName() + " still exists!",
                employeesPage.doesEmployeeExist(employeeDetails));

        employeeDetails = new Employee("John", "Doe");
        employeeDetails.setAddress("384 Lady Bug Drive");
        employeeDetails.setCity("Colorado Springs");
        employeeDetails.setDepartment("Quality Engineering");

        // 4. Click “Create New”
        // 5. Enter Employee Details
        //      First name: John
        //      Last name: Doe
        //      Address: [Any Value]
        //      State: Select a random value from the dropdown
        //      City: [Any Value]
        //      Department: Quality Engineering
        // 6. Click “Create”
        Employee createdEmployeeDetails = employeesPage.createEmployee(employeeDetails);

        // 7. Verify that the page redirects to /employees
        Assert.assertTrue("The page was not redirected to /employees!", employeesPage.isPageActive());
        // 8. Verify that the newly created employee is in the list
        Assert.assertTrue("The Employee was not created!", employeesPage.doesEmployeeExist(createdEmployeeDetails));

        createdEmployeeDetails.setID(employeesPage.getEmployeeIDFromTableRow(createdEmployeeDetails));

        // 9. Delete the created employee
        employeesPage.deleteEmployee(createdEmployeeDetails);

        // 10.Verify that the newly created employee is NOT in the list
        Assert.assertFalse(
                "Employee " + createdEmployeeDetails.getFirstName() + " " + createdEmployeeDetails.getLastName() + " still exists!",
                employeesPage.doesEmployeeExist(createdEmployeeDetails));
    }
}
