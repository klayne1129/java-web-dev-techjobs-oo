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

        assertTrue(jobString.indexOf(expected) == firstIndexString);
        assertTrue(jobString.lastIndexOf(expected) == lastIndexString);
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
      
      //If a field is an empty string, the JobField Constructor should add, “Data not available” after the label.
    @Test
    public void JobFieldConstructorUpdatesValue() {
        Job job3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
         //employer
        String job3Employer = job3.getEmployer().getValue();
        String output = "not available";
        assertEquals(job3Employer,output);
        //name
        String job3Name =job3.getName();
        assertEquals(job3Name,output);
        //location
        String job3Location =job3.getLocation().getValue();
        assertEquals(job3Location,output);
        //PositionType
        String job3PositionType = job3.getPositionType().getValue();
        assertEquals(job3PositionType,output);
        //CoreCompetency
        String job3CoreCompetency =job3.getCoreCompetency().getValue();
        assertEquals(job3CoreCompetency,output);

    }

    // checks to see that a job with only an ID returns a descriptive string.
    @Test
    public void EmptyJobReturnsString() {
String job =jobOne.toString();
        String output = "\n" +"OOPS! This job, ID: " + jobOne.getId() + " does not seem to exist."+"\n";
        assertEquals(job,output);
    }
}
