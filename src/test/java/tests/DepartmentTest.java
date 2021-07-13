package tests;
import models.Department;
import org.junit.*;
import webpages.Department.CreateDepartmentPage;
import webpages.Department.DeleteDepartmentPage;
import webpages.Department.DepartmentsPage;

public class DepartmentTest extends BaseTest {

    @Test
    public void testDepartmentEndToEnd(){
        DeleteDepartmentPage deleteDepartmentPage;
        CreateDepartmentPage createDepartment;

        // 1. Navigate to Department Page
        DepartmentsPage departments = new DepartmentsPage(driver);

        // 2. Verify if the following department to be added is in the list
        //      Magenic Manila Recruitment – [random number between 1 - 999]
        Department department = new Department("Magenic Manila Recruitment - " + (1 + (int) (Math.random() * ((999 - 1) + 1))));

        // 3. If the department exists, Delete the target department
        while(departments.checkIfDepartmentExists(department)) {
            departments.deleteDepartment(department);
            deleteDepartmentPage = new DeleteDepartmentPage(driver);
            deleteDepartmentPage.delete();
        }

        Assert.assertFalse(departments.checkIfDepartmentExists(department));

        // 4. Click “Create New”
        departments.clickOnCreateNewDepartmentLink();
        createDepartment = new CreateDepartmentPage(driver);
        // 5. Enter Department Details used in Step 2
        // 6. Click “Create”
        createDepartment.create(department);

        // 7. Verify that the page redirects to /departments
        Assert.assertTrue(departments.isPageOpened());
        // 8. Verify that the newly created department is in the list
        Assert.assertTrue(departments.checkIfDepartmentExists(department));

        // 9. Delete the created department
        departments.deleteDepartment(department);
        deleteDepartmentPage = new DeleteDepartmentPage(driver);
        deleteDepartmentPage.delete();

        // 10. Verify that the newly created department is NOT in the list
        Assert.assertFalse(departments.checkIfDepartmentExists(department));
    }
}
