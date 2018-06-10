package ru.inbox.savinov_vu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersImportServiceMockBeanTest {

    @MockBean
    private UsersImporter usersImporter;

    @Autowired
    private UsersImportService usersImportService;


    @Test
    public void should_retry_3times_when_UserImportServiceCommunicationFailure_occured() {
        given(usersImporter.importUsers()).willThrow(new RuntimeException("simple exception"));
        UsersImportResponse usersImportResponse = usersImportService.importUsers();
        assertThat(usersImportResponse.getRetryCount()).isEqualTo(3);
        assertThat(usersImportResponse.getStatus()).isEqualTo("FAILURE");
    }
}
