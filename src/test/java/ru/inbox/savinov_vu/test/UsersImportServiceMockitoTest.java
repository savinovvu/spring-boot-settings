package ru.inbox.savinov_vu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;



@RunWith(MockitoJUnitRunner.class)
public class UsersImportServiceMockitoTest {

    @Mock
    private UsersImporter usersImporter;

    @InjectMocks
    private UsersImportService usersImportService;

    @Test
    public void should_retry_3times_when_UserImportServiceCommunicationFailure_occured(){
        given(usersImporter.importUsers()).willThrow(new RuntimeException("simple exception"));
        UsersImportResponse usersImportResponse = usersImportService.importUsers();
        assertThat(usersImportResponse.getRetryCount()).isEqualTo(3);
        assertThat(usersImportResponse.getStatus()).isEqualTo("FAILURE");
    }
}