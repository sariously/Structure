package edu.gcccd.csis;

public class Organization {

    // private instance variables
    private String orgName;
    private int employeeCount;

    public Organization(String orgName, int employee)
    {
        this.orgName = orgName;
        this.employeeCount = employee;
    }

    public String getOrgName()
    {
        return this.orgName;
    }

    public int getEmployeeCount()
    {
        return this.employeeCount;
    }

    public void setOrgName(String org)
    {
        this.orgName = org;
    }

    public void setEmployeeCount(int e)
    {
        this.employeeCount = e;
    }

    @Override
    /*
     * To be considered equal, organization must have same name and number of employees
     */
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof Organization) {
            Organization org = (Organization) o;
            return this.orgName.equals(org.getOrgName()) &&
                    this.employeeCount == org.employeeCount;
        }
        return false;

    }
}

