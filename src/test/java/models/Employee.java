package models;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String department;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setID(int id) { this.id = id; }

    public void setAddress(String address) { this.address = address; }

    public void setState(String state) { this.state = state; }

    public void setCity(String city) { this.city = city; }

    public void setDepartment(String department) { this.department = department; }

    public int getID() { return this.id; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() { return this.address; }

    public String getState() { return this.state; }

    public String getCity() { return this.city; }

    public String getDepartment() { return this.department; }
}
