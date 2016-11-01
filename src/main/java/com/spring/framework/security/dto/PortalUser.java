/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.framework.security.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * @author rachit
 */
public class PortalUser extends User {

    private Integer userId;

    private String salt;

    private String organisation;

    private String organisationType;

    private String organisationId;

    private String userType;

    private String bankName;

    private String bankImageUrl;

    private Boolean enabled;

    public PortalUser(String username, String passowrd, Boolean enabled, String salt,
            String organisation, String organisationType, String organisationId, String userType,
            String bankName, String bankImageUrl, Integer userId) {
        super(username, passowrd, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
        this.userId = userId;
        this.salt = salt;
        this.organisation = organisation;
        this.organisationType = organisationType;
        this.organisationId = organisationId;
        this.userType = userType;
        this.bankName = bankName;
        this.bankImageUrl = bankImageUrl;
    }
    
    public PortalUser(String username, String passowrd, Boolean enabled, String salt,
            String organisation, String organisationType, String organisationId, String userType,
            String bankName, String bankImageUrl, Integer userId,Collection<? extends GrantedAuthority> authorities) {
        super(username, passowrd, enabled, true, true, true, authorities);
        this.userId = userId;
        this.salt = salt;
        this.organisation = organisation;
        this.organisationType = organisationType;
        this.organisationId = organisationId;
        this.userType = userType;
        this.bankName = bankName;
        this.bankImageUrl = bankImageUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(String organisationType) {
        this.organisationType = organisationType;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankImageUrl() {
        return bankImageUrl;
    }

    public void setBankImageUrl(String bankImageUrl) {
        this.bankImageUrl = bankImageUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    

}
