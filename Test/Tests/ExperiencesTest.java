package Tests;

import exceptions.ExperienceAlreadyRecordedException;
import exceptions.ExperienceNotRecordedException;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ExperiencesTest {
    private Experiences experiences;
    private static final String JOB = "job";
    private static final String VOLUNTEER = "volunteer";
    private static final String EXTRACURRICULAR = "extracurricular";
    private static final String CAT = "cat";
    private static final String PENGUIN = "penguin";

    @Before
    public void startUp() {
        experiences = new Experiences();
    }

    @Test
    public void testPutOneExperienceOfEachType() {
        assertTrue(experiences.allEmpty());

        Description jobDescription = new Description(JOB + ", " + CAT);
        jobDescription.addHardSkill(HardSkillTags.WORKEXPERIENCE);

        Description volunteerDescription = new Description(VOLUNTEER + ", " + CAT);
        volunteerDescription.addHardSkill(HardSkillTags.VOLUNTEEREXPERIENCE);

        Description extracurricularDescription = new Description(EXTRACURRICULAR + ", " + CAT);
        extracurricularDescription.addHardSkill(HardSkillTags.EXTRACURRICULARS);

        try {
            experiences.addWorkExperience(JOB, CAT);
            experiences.addVolunteerExperience(VOLUNTEER, CAT);
            experiences.addExtracurricular(EXTRACURRICULAR, CAT);
        } catch (ExperienceAlreadyRecordedException e) {
            fail("no exception expected");
        }

        try {
             WorkExperience jobResult = experiences.findWorkExperience(JOB, CAT);
             VolunteerExperience volunteerResult = experiences.findVolunteerExperience(VOLUNTEER, CAT);
             Extracurricular extracurricularResult = experiences.findExtracurricular(EXTRACURRICULAR, CAT);

             assertEquals(jobDescription, jobResult.getDescription());
             assertEquals(volunteerDescription, volunteerResult.getDescription());
             assertEquals(extracurricularDescription, extracurricularResult.getDescription());
        } catch (ExperienceNotRecordedException e) {
            fail("exception not expected");
        }

        try {
            experiences.findWorkExperience("bb", CAT);
            fail("exception expected");
        } catch (ExperienceNotRecordedException e) {
        }
    }

    @Test
    public void testFindMultipleExperiences() {
        WorkExperience workExperienceResult1 = new WorkExperience(JOB, CAT);
        VolunteerExperience volunteerExperienceResult1 = new VolunteerExperience(VOLUNTEER, CAT);
        Extracurricular extracurricularResult1 = new Extracurricular(EXTRACURRICULAR, CAT);

        WorkExperience workExperienceResult2 = new WorkExperience(JOB, PENGUIN);
        VolunteerExperience volunteerExperienceResult2 = new VolunteerExperience(VOLUNTEER, PENGUIN);
        Extracurricular extracurricularResult2 = new Extracurricular(EXTRACURRICULAR, PENGUIN);

        Set<WorkExperience> workExperienceSet = new HashSet<>();
        workExperienceSet.add(workExperienceResult1);
        workExperienceSet.add(workExperienceResult2);

        Set<VolunteerExperience> volunteerExperienceSet = new HashSet<>();
        volunteerExperienceSet.add(volunteerExperienceResult1);
        volunteerExperienceSet.add(volunteerExperienceResult2);

        Set<Extracurricular> extracurricularSet = new HashSet<>();
        extracurricularSet.add(extracurricularResult1);
        extracurricularSet.add(extracurricularResult2);

        try {
            experiences.addWorkExperience(JOB, CAT);
            experiences.addVolunteerExperience(VOLUNTEER, CAT);
            experiences.addExtracurricular(EXTRACURRICULAR, CAT);

            experiences.addWorkExperience(JOB, PENGUIN);
            experiences.addVolunteerExperience(VOLUNTEER, PENGUIN);
            experiences.addExtracurricular(EXTRACURRICULAR, PENGUIN);
        } catch (ExperienceAlreadyRecordedException e) {
            fail("exception not expected");
        }

        try {
            assertEquals(experiences.findWorkExperiences(JOB), workExperienceSet);
            assertEquals(experiences.findVolunteerExperiences(VOLUNTEER), volunteerExperienceSet);
            assertEquals(experiences.findExtracurriculars(EXTRACURRICULAR), extracurricularSet);
        } catch (ExperienceNotRecordedException e) {
            fail("exception not expected");
        }

        try {
            experiences.addExtracurricular(EXTRACURRICULAR, PENGUIN);
            fail("exception expected");
        } catch (ExperienceAlreadyRecordedException e) {
        }
    }
}
