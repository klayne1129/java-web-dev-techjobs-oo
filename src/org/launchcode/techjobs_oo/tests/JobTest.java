package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job jobOne;
    Job jobTwo;
    Job job3;
    Job jobFullConstructor;
    Job jobDifferentIdOne;
    Job jobDifferentIdTwo;
    Job emptyJob;
    String jobString;

    @Before
    public void createJobObjects() {
        jobOne = new Job();
        jobTwo = new Job();
        jobFullConstructor =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobDifferentIdOne =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobDifferentIdTwo =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        emptyJob = new Job("p", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        job3 = new Job(" ", new Employer(" "), new Location(" "), new PositionType(" "), new CoreCompetency(" "));
    }
    //Test the empty constructor
    @Test
    public void  testSettingJobId() {
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    // test the full constructor
    @Test
    public void  testJobConstructorSetsAllFields() {
        //checks the class type of each field in job
        assertNotNull(jobFullConstructor.getEmployer());
        assertNotNull(jobFullConstructor.getLocation());
        assertNotNull(jobFullConstructor.getPositionType());
        assertNotNull(jobFullConstructor.getCoreCompetency());

        // checks values
        assertEquals("ACME", jobFullConstructor.getEmployer().getValue());
        assertEquals("Desert", jobFullConstructor.getLocation().getValue());
        assertEquals("Quality control", jobFullConstructor.getPositionType().getValue());
        assertEquals("Persistence", jobFullConstructor.getCoreCompetency().getValue());

    }
    // ensures objects are not considered equal if ID's are different
    @Test
    public void testJobsForEquality(){
        assertNotEquals(jobDifferentIdOne, jobDifferentIdTwo);
    }


    // ensure the first and last characters in the string are new lines.
    @Test
    public void customToStringMethodOne() {
        String expected = "\n";
        jobString = jobFullConstructor.toString();
        int firstIndexString = 0;
        int lastIndexString = jobString.length() - 1;

        assertEquals(jobString.indexOf(expected), firstIndexString);
        assertEquals(jobString.lastIndexOf(expected), lastIndexString);
    }
      // Each field contains a label and followed by the stored. Each on a new line.
      @Test
      public void customToStringMethodTwo() {
        String jobString = jobFullConstructor.toString();
        String output = "\n"+
                "ID: " + jobFullConstructor.getId()+"\n"+
                "Name: "+ jobFullConstructor.getName()+ "\n"+
                "Employer: "+jobFullConstructor.getEmployer()+"\n"+
                "Location: "+jobFullConstructor.getLocation()+"\n"+
                "Position Type: "+jobFullConstructor.getPositionType()+"\n"+
                "Core Competency: "+jobFullConstructor.getCoreCompetency()+"\n";

          assertEquals(jobString, output);
      }
      



    // checks to see that a job with only an ID returns a descriptive string.
    @Test
    public void EmptyJobReturnsString() {
String job =jobOne.toString();
        String output = "\n" +"OOPS! This job, ID: " + jobOne.getId() + " does not seem to exist."+"\n";
        assertEquals(job,output);
    }
}
