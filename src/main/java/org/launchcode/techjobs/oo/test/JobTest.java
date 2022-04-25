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
  private Job testJobFour;


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

}
