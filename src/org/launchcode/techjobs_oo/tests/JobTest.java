package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job jobOne;
    Job jobTwo;
    Job jobFullConstructor;
    Job jobDifferentIdOne;
    Job jobDifferentIdTwo;

    @Before
    public void createJobObjects() {
        jobOne = new Job();
        jobTwo = new Job();
        jobFullConstructor =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobDifferentIdOne =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobDifferentIdTwo =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    //Test the empty constructor
    @Test
    public void  testSettingJobId() {
        assertFalse(jobOne.getId() == jobTwo.getId());
    }

    // test the full constructor
    @Test
    public void  testJobConstructorSetsAllFields() {
        //checks the class type of each field in job
    assertTrue(jobFullConstructor.getEmployer() instanceof Employer);
    assertTrue(jobFullConstructor.getLocation() instanceof Location);
    assertTrue(jobFullConstructor.getPositionType() instanceof PositionType);
    assertTrue(jobFullConstructor.getCoreCompetency() instanceof CoreCompetency);

        // checks values
    assertTrue(jobFullConstructor.getEmployer().getValue().equals("ACME"));
    assertTrue(jobFullConstructor.getLocation().getValue().equals("Desert"));
    assertTrue(jobFullConstructor.getPositionType().getValue().equals("Quality control"));
    assertTrue(jobFullConstructor.getCoreCompetency().getValue().equals("Persistence"));

    }
    // ensures objects are not considered equal if ID's are different
    @Test
    public void testJobsForEquality(){
    assertFalse(jobDifferentIdOne.equals(jobDifferentIdTwo));
    }
}
