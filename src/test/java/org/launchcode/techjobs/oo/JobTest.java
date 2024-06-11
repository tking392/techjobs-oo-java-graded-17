package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;
import static java.lang.System.lineSeparator;

public class JobTest {
    //TODO: Create your unit tests here

    @Test //Test the Empty Constructor
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test //Test the Full Constructor
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test //Test the equals Method
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job1.equals(job2), false);
    }


    //Create First Test for toString
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals(job.toString().startsWith(lineSeparator()), true);
        Assert.assertEquals(job.toString().endsWith(lineSeparator()), true);

        // First draft of code before updating the Job class
        // String firstChar = String.valueOf(job.toString().charAt(0));
        // String lastChar = String.valueOf(job.toString().charAt(job.toString().length() - 1));
        // assertEquals(firstChar, lineSeparator());
        // assertEquals(lastChar, lineSeparator());

    }


    //Finish the TDD for toString
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType(
                        "Quality control"), new CoreCompetency("Persistence"));
        String testExpected = lineSeparator() +
                "ID: 4\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                lineSeparator();
        assertEquals(testExpected, job.toString());
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        String testExpected = lineSeparator() +
                "ID: 3\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available" +
                lineSeparator();
        assertEquals(testExpected, job.toString());

    }

}
