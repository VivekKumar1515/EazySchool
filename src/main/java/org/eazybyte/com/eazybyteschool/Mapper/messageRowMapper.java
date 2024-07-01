package org.eazybyte.com.eazybyteschool.Mapper;

import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class messageRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setContactId(rs.getInt("contact_id"));
        contact.setName(rs.getString("name"));
        contact.setMobileNum(rs.getString("mobile_num"));
        contact.setSubject(rs.getString("subject"));
        contact.setEmail(rs.getString("email"));
        contact.setMessage(rs.getString("message"));
        contact.setStatus(rs.getString("status"));
        contact.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        contact.setCreatedBy(rs.getString("created_by"));

        return contact;
    }
}
