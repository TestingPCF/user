/**
 * Copyright (c) HCL PCF TEAM ,2019.
 */
package com.hcl.cloud.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * com.hcl.cloud.user.DTO. abhishek_sin
 */
@JsonIgnoreProperties("id")
public class UserDTO {
    /**
     * id.
     */
    private long id;
    /**
     * userName.
     */
    private String userName;
    /**
     * email.
     */
    private String email;
    /**
     * first_name.
     */
    private String firstName;
    /**
     * last_name.
     */
    private String lastName;
    /**
     * user_address.
     */
    private List<AddressDTO> userAddress;
    /**
     * password.
     */
    private String password;
    /**
     * role.
     */
    private String role;
    /**
     * phone_number.
     */
    private long phoneNumber;
    /**
     * active.
     */
    private Integer active = 1;
    /**
     * isLoacked.
     */
    private boolean isLoacked = false;
    /**
     * isExpired.
     */
    private boolean isExpired = false;
    /**
     * isEnabled.
     */
    private boolean isEnabled = true;
    
    private boolean active_user=true;

    public boolean isActive_user() {
		return active_user;
	}

	public void setActive_user(boolean active_user) {
		this.active_user = active_user;
	}

    /**
     *
     * @return the role.
     */
    public final String getRole() {
        return role;
    }

    /**
     *
     * @param role
     *            the role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return the id.
     */
    public final long getId() {
        return id;
    }

    /**
     *
     * @param id
     *            the id to set.
     */
    public final void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return the active.
     */
    public final Integer getActive() {
        return active;
    }

    /**
     *
     * @param active
     *            the active to set.
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     *
     * @return the isLoacked.
     */
    public final boolean isLoacked() {
        return isLoacked;
    }

    /**
     *
     * @param isLoacked
     *            the isLoacked to set.
     */
    public void setLoacked(boolean isLoacked) {
        this.isLoacked = isLoacked;
    }

    /**
     *
     * @return the isExpired.
     */
    public final boolean isExpired() {
        return isExpired;
    }

    /**
     *
     * @param isExpired
     *            the isExpired to set.
     */
    public void setExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    /**
     *
     * @return the isEnabled.
     */
    public final boolean isEnabled() {
        return isEnabled;
    }

    /**
     *
     * @param isEnabled
     *            the isEnabled to set.
     */
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Default constructor .
     */
    public UserDTO() {
    }

    /**
     * @return the email.
     */
    public final String getEmail() {
        return email;
    }

    /**
     *
     * @return the userName.
     */
    public final String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     *            the userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param email
     *            the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password.
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return the firstName.
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     *            the firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return the lastName.
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     *            the lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return the userAddress.
     */
    public final List<AddressDTO> getUserAddress() {
        return userAddress;
    }

    /**
     *
     * @param userAddress
     *            the userAddress to set.
     */
    public void setUserAddress(List<AddressDTO> userAddress) {
        this.userAddress = userAddress;
    }

    /**
     *
     * @return the phoneNumber.
     */
    public final long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     *            the phoneNumber to set.
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
