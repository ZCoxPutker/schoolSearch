package app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SchoolControllerTest {

    @InjectMocks
    private SchoolController SchoolControllerFixture;

    @Mock
    SchoolRepository schoolRepositoryMock;


    School schoolStub = new School("","testSchool");

    @Test
    public void happyFlowAvailableConsultant() throws Exception {
        when(schoolRepositoryMock.findByCity("")).thenReturn(schoolStub);

        School school1 = SchoolControllerFixture.school("");
        System.out.println(school1);

        verify(schoolRepositoryMock).findByCity("");
        assertEquals(school1.name,"testSchool");
    }
}