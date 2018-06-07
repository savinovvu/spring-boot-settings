package ru.inbox.savinov_vu.jdbcTemplate;


import org.springframework.jdbc.core.RowMapper;
import ru.inbox.savinov_vu.utils.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;



public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.id = rs.getInt("id");
        user.name = rs.getString("name");
        user.email = rs.getString("email");
        return user;
    }
}
