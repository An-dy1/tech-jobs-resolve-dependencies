package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

  private Job jobOneNoFields;
  private Job jobTwoNoFields;
  private Job jobThreeWithFields;
  private Job jobFourWithFields;


  @Before
  public void createTestJobObjects() {
    jobOneNoFields = new Job();
    jobTwoNoFields = new Job();
    jobThreeWithFields = new Job(
        "Product tester",
        new Employer("ACME"),
        new Location("Desert"),
        new PositionType("Quality control"),
        new CoreCompetency("Persistence")
    );
    jobFourWithFields = new Job(
        "Product tester",
        new Employer("ACME"),
        new Location("Desert"),
        new PositionType("Quality control"),
        new CoreCompetency("Persistence")
    );
  }

  @Test
  public void testSettingJobId() {

    assertFalse(jobOneNoFields.getId() == jobTwoNoFields.getId());
//    assertTrue(testJobTwo.getId() - testJobOne.getId() == 1);
    assertEquals(1, jobTwoNoFields.getId() - jobOneNoFields.getId());

  }

  @Test
  public void testJobConstructorSetsAllFields() {
    assertEquals(jobThreeWithFields.getName(), "Product tester");
    assertEquals(jobThreeWithFields.getEmployer().getValue(), "ACME");
    assertEquals(jobThreeWithFields.getPositionType().getValue(), "Quality control");
    assertEquals(jobThreeWithFields.getCoreCompetency().getValue(), "Persistence");
    assertTrue(jobThreeWithFields instanceof Job);
  }

  @Test
  public void testJobsForEquality() {
    assertFalse(jobThreeWithFields == jobFourWithFields);
  }

  @Test
  public void testJobToStringBeginsWithSpacesAndEnds() {
    String jobThreeToString = jobThreeWithFields.toString();

    char firstChar = jobThreeToString.charAt(0);
    char lastChar = jobThreeToString.toString().charAt(jobThreeToString.length() - 1);
  }

  @Test
  public void testJobToStringMethod() {
    String output = String.format("\nID: %d\n" +
            "Name: %s\n" +
            "Employer: %s\n" +
            "Location: %s\n" +
            "Position Type: %s\n" +
            "Core Competency: %s\n",jobThreeWithFields.getId(), jobThreeWithFields.getName(), jobThreeWithFields.getEmployer(), jobThreeWithFields.getLocation(),
        jobThreeWithFields.getPositionType(), jobThreeWithFields.getCoreCompetency());

    assertEquals(output, jobThreeWithFields.toString());
  }

  @Test
  public void testJobToStringWithMissing() {
    jobThreeWithFields.getEmployer().setValue("");
    jobThreeWithFields.getPositionType().setValue("");

    String output = String.format("\nID: %d\n" +
            "Name: %s\n" +
            "Employer: Data not available\n" +
            "Location: %s\n" +
            "Position Type: Data not available\n" +
            "Core Competency: %s\n",jobThreeWithFields.getId(), jobThreeWithFields.getName(), jobThreeWithFields.getLocation(),
        jobThreeWithFields.getCoreCompetency());

    assertEquals(output, jobThreeWithFields.toString());
  }

  @Test
  public void testJobToStringWithOnlyId() {

    String expectedOutput = "OOPS! This job does not seem to exist.";
    assertEquals(expectedOutput, jobOneNoFields.toString());

  }



}
