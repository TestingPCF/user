/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.constant;

import org.springframework.beans.factory.annotation.Value;

/**
 * com.hcl.cloud.user.constant. abhishek_sin
 */
public class UserConstant {
    /**
     * AUTH_TOKEN.
     */
    public final static String AUTHTOKEN = "accessToken";
    /**
     * ADMIN_ROLE.
     */
    public final static String ADMINROLE = "admin";
    /**
     * USER_ROLE.
     */
    public final static String USERROLE = "user";
    /**
     * MESSAGE.
     */
    @Value("${user.create.successmsg}")
    public final static String MESSAGE = null/* "USER CREATED SUCCESSFULLY !!!"*/;
    /**
     * UPDATE_MESSAGE.
     */
    @Value("${user.update.successmsg}")
    public final static String UPDATE_MESSAGE = null/*"USER UPDATED SUCCESSFULLY !!!"*/;
    /**
     * UPDATE_MESSAGE.
     */
    @Value("${user.delete.successmsg}")
    public final static String DELETE_MESSAGE = null;/*"USER DELETE SUCCESSFULLY !!!"*/;
    /**
     * UPDATE_MESSAGE.
     */
    @Value("${user.notfound.msg}")
    public final static String UPDATE_MESSAGE_ERROR = null/*"USER DOES NOT EXIST !!!"*/;
    /**
     * ERROR_MESSAGE.
     */
    @Value("${user.already.msg}")
    public final static String ERROR_MESSAGE = null/*"USER ALREADY EXIST WITH SAME EMAILID  !!!"*/;

    UserConstant() { }
}
