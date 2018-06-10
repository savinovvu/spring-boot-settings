package ru.inbox.savinov_vu.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class UsersImportService {

    private Logger logger = LoggerFactory.getLogger(UsersImportService.class.getName());

    private UsersImporter usersImporter;


    @Autowired
    public UsersImportService(UsersImporter usersImporter) {
        this.usersImporter = usersImporter;
    }


    public UsersImportResponse importUsers() {
        int retryCount = 0;
        int maxRetryCount = 3;
        for (int i = 0; i < maxRetryCount; i++) {
            try {
                List<User> importUsers = usersImporter.importUsers();
                logger.info("Import Users: " + importUsers);
                break;
            } catch (RuntimeException e) {
                retryCount++;
                logger.error("Error: " + e.getMessage());
            }
        }
        if (retryCount >= maxRetryCount)
            return new UsersImportResponse(retryCount, "FAILURE");
        else
            return new UsersImportResponse(0, "SUCCESS");
    }
}
