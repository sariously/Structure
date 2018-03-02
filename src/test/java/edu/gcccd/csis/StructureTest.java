package edu.gcccd.csis;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.time.*;

/**
 * Tests for a system that can track employee information for two organizations.
 * The Employee information you must (at least) track, is as follows:
 * Name, Job Title, Organization they work for, Birthday
 *
 * As for the Organization that the Employee works for, you must also (at the very least) track this information:
 * Organization Name, Number of Employees
 *
 * The system must be able to properly compare any two employees against each other to determine,
 * if they are the same Person. This means that if you compared two People,
 * with the same Name, Birthday, and Organization, the system should think that they are equal to one another.
 * If any of these properties are different, then the two People are not the same Person.
 * The same rules apply to comparing Organizations to one another.
 * Organizations with the same Organization name are to be thought of as equal,
 * different names means different organizations.
 */
public class StructureTest {



    @Test
    public void employeeComplete() {
        Organization c1 = new Organization("Google", 500);
        Birthday b1 = new Birthday(LocalDate.of(1983, 11, 1));
        Employee e1 = new Employee("Sara Kazemi", "Programmer", c1, b1);
        //
        // check that an employee's attribute are complete and make sense.
        // assertTrue( employee is alive and company complies with child labor laws ...;
        //...
        assertTrue(e1.getBirthday().checkYear());


        // This employee hasn't been born yet! Should return false
        Birthday b2 = new Birthday(LocalDate.of(2018, 11, 1));
        Employee e2 = new Employee("Sara Kazemi", "Programmer", c1, b2);
        assertFalse(e2.getBirthday().checkYear());

        // This employee probably is no longer alive
        Birthday b3 = new Birthday(LocalDate.of(1901, 11, 1));
        Employee e3 = new Employee("Sara Kazemi", "Programmer", c1, b3);
        assertFalse(e3.getBirthday().checkYear());
    }
    /**
     * Check Employee Equality
     */
    @Test
    public void employeeEq() {
        Employee e1 = null;
        Employee e2 = null;
        Organization c1 = new Organization("Google", 500);
        Organization c2 = new Organization("Microsoft", 1000);
        Birthday b1 = new Birthday(LocalDate.of(1983, 11, 1));



        // Create employee e1,
        e1 = new Employee("Sara Kazemi", "Programmer", c1, b1);
        // Create another employee e2 that matches the specific criteria for equality
        e2 = new Employee("Sara Kazemi", "Programmer", c1, b1);
        assertTrue(e1.equals(e2));

        // modify employee e2 (eg. by making her/him join the other company
        e2 = new Employee("Sara Kazemi", "Programmer", c2, b1);
        assertNotEquals(e1, e2);

    }

    /**
     * Check Company Equality
     */
    @Test
    public void companyEq() {
        // Create company c1,
        Organization c1 = new Organization("Google", 100);

        // Create company employee c2 that matches the specific criteria for equality
        Organization c2 = new Organization("Google", 100);
        assertTrue(c1.equals(c2));


        // modify company c2, i.e. change its name or create another company with a different name ..
        c2.setOrgName("Microsoft");
        c2.setEmployeeCount(200);

        assertNotEquals(c1, c2);

    }

    @Test
    public void companyComplete() {
        // check that a companies' attribute are complete and make sense.
        Organization c1 = new Organization("Google", 100);
        assertTrue((c1.getOrgName() !=null) && c1.getEmployeeCount() > 0 );

    }
}