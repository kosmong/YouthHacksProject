package Tests;

import exceptions.ExperienceAlreadyRecordedException;
import exceptions.ExperienceNotRecordedException;
import model.Description;
import model.Experiences;
import model.HardSkillTags;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExperiencesTest {
    private Experiences experiences;



    @Before
    public void startUp() {
        experiences = new Experiences();
    }

    @Test
    public void testPutOneExperienceOfEachType() {
        assertTrue(experiences.allEmpty());

        String job = "job";
        Description jobDescription = new Description(job);
        jobDescription.addHardSkill(HardSkillTags.WORKEXPERIENCE);

        String volunteer = "volunteer";
        Description volunteerDescription = new Description(volunteer);
        volunteerDescription.addHardSkill(HardSkillTags.VOLUNTEEREXPERIENCE);

        String extracurricular = "extracurricular";
        Description extracurricularDescription = new Description(extracurricular);
        extracurricularDescription.addHardSkill(HardSkillTags.EXTRACURRICULARS);

        try {
            experiences.addWorkExperience(job);
            experiences.addVolunteerExperience(volunteer);
            experiences.addExtracurricular(extracurricular);
        } catch (ExperienceAlreadyRecordedException e) {
            fail("no exception expected");
        }

        try {
             Description jobResult = experiences.findWorkExperience(job);
             Description volunteerResult = experiences.findVolunteerExperience(volunteer);
             Description extracurricularResult = experiences.findExtracurricular(extracurricular);

             assertEquals(jobDescription, jobResult);
             assertEquals(volunteerDescription, volunteerResult);
             assertEquals(extracurricularDescription, extracurricularResult);
        } catch (ExperienceNotRecordedException e) {
            fail("exception not expected");
        }

        try {
            experiences.findWorkExperience("bb");
            fail("exception expected");
        } catch (ExperienceNotRecordedException e) {
        }
    }
}
