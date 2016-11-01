/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.security.service;

import com.spring.framework.security.dto.PortalUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

/**
 * @author rachit
 */
public class PortalUserService extends JdbcDaoImpl {

    private final String fieldSequence = "username,password,enabled,salt,organsiation,organisationType,"
            + "organisationId,userType,bankName,bankImageUrl,userId";
    
    private final String userByUsernameQuery = "select " + fieldSequence + " from users where username = ?";

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(userByUsernameQuery,
                new String[]{username}, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                String salt = rs.getString(4);
                String organisation = rs.getString(5);
                String organisationType = rs.getString(6);
                String organisationId = rs.getString(7);
                String userType = rs.getString(8);
                String bankName = rs.getString(9);
                String bankImageUrl = rs.getString(10);
                Integer userId = rs.getInt(11);
                return new PortalUser(username, password, enabled, salt,organisation,
                        organisationType,organisationId,userType,bankName,bankImageUrl,userId);
            }

        });
    }
    
    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {   
              PortalUser pu= (PortalUser) userFromUserQuery;
              return new PortalUser(pu.getUsername(),pu.getPassword(),pu.getEnabled(),pu.getSalt(),
                      pu.getOrganisation(),pu.getOrganisationType(),pu.getOrganisationId(),
                      pu.getUserType(),pu.getBankName(),pu.getBankImageUrl(),pu.getUserId(),combinedAuthorities);
    }
    
    

}
