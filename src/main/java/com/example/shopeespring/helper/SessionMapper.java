package com.example.shopeespring.helper;

import com.example.shopeespring.model.Session;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionMapper implements RowMapper<Session> {
    @Override
    public Session mapRow(ResultSet resultSet, int i) throws SQLException{
        Session session = new Session();
        session.setUserId(resultSet.getString("userId"));
        session.setToken(resultSet.getString("token"));
        return session;
    }
}
