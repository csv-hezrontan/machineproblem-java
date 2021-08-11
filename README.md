# Machine Problem for Java


## System Under Test
http://magenicautomation.azurewebsites.net/

- Target Browser: Chrome
- Create Automation Suite using Page Model Object
- Technology: Java, Selenium WebDriver, JUnit
- Base Solution is provided

### Machine Software Requirements
- Visual Studio Community or Visual Studio Code / IntelliJ


### Automate the following test cases

#### Test Case # 1
1. Navigate to Department Page
   http://magenicautomation.azurewebsites.net/Departments
2. Verify if the following employee to be added is in the list
3. Magenic Manila Recruitment – [random number between 1 - 999]
4. If the department exists, Delete the target department
5. Click “Create New”
6. Enter Department Details used in Step 2
7. Click “Create”
8. Verify that the page redirects to /departments
9. Verify that the newly created department is in the list
10. Delete the created department
11. Verify that the newly created department is NOT in the list

#### Test Case # 2
1. Navigate to Employees Page
2. http://magenicautomation.azurewebsites.net/Employees
   NOTE: Verify if the following employee to be added is in the list
- First name: John
- Last name: Doe
3. If the employee exists, Delete the target employee
4. Click “Create New”
5. Enter Employee Details
- First name: John
- Last name: Doe
- Address: [Any Value]
- State: Select a random value from the dropdown
- City: [Any Value]
- Department: Quality Engineering
6. Click “Create”
7. Verify that the page redirects to /employees
8. Verify that the newly created employee is in the list
9. Delete the created employee
10. Verify that the newly created employee is NOT in the list