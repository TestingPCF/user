/**
 * Copyright (c) HCL PCF TEAM ,2019.
 */
package com.hcl.cloud.user.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.cloud.user.constant.UserResponseEntity;
import com.hcl.cloud.user.dto.UserDTO;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.service.UserService;

/**
 * @author Dinesh Sharma and abhishek_sin
 *
 */
@RefreshScope
@RestController
public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * DECLARATION OF VARIABLE.
     */

    @Autowired
    public UserService userService;

    @Value("${user.create.successmsg}")
    private String MESSAGE;

    @Value("${user.update.successmsg}")
    private String UPDATE_MESSAGE;

    @Value("${user.delete.successmsg}")
    private String DELETE_MESSAGE;

    @Value("${user.notfound.msg}")
    private String UPDATE_MESSAGE_ERROR;

    /**
     *
     * saveUserDetails is use for user registration
     *
     * @param user
     *            for save user details in DB.
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<UserResponseEntity> saveUserDetails(@RequestBody UserDTO user) {

        if (logger.isInfoEnabled()) {
            logger.info("User Request is received for Registration: ");
        }
        userService.saveUser(user);
        return new ResponseEntity<UserResponseEntity>(new UserResponseEntity(HttpStatus.CREATED.value(), MESSAGE),
                HttpStatus.CREATED);
    } /* END HERE */

    /**
     * updateUserDetails method are updating user details.
     *
     * @param user
     *            for updateUserDetails method are updating user details.
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<UserResponseEntity> updateUserDetails(@RequestBody UserDTO user) {
        if (logger.isInfoEnabled()) {
            logger.info("User Request is received for User Update :::::: " + user.getEmail());
        }
        ResponseEntity<UserResponseEntity> response = null;
        try {
            User userUpdate = userService.updateUser(user);
            if (userUpdate != null) {
                logger.debug("User detail updated succesfully for : " + userUpdate.getEmail());
                response = new ResponseEntity<>(new UserResponseEntity(HttpStatus.OK.value(), UPDATE_MESSAGE),
                        HttpStatus.OK);
            } else {
                logger.error("UPDATE_MESSAGE_ERROR");
                response = new ResponseEntity<>(
                        new UserResponseEntity(HttpStatus.NOT_FOUND.value(), UPDATE_MESSAGE_ERROR),
                        HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("Error occured while updating user details. " + ex.getCause());
        }
        return response;
    } /* END HERE */

    /**
     * getAllUserDetails method are fetching all user details.
     *
     * @param user
     *            for get all user details.
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUserDetails(
            @RequestHeader(value = "accessToken", required = true) String accessToken) {

        final List<UserDTO> userDetails = userService.findUserRoleByID(accessToken);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    } /* END HERE */

    /**
     * deleteUserDetailsByID method are soft deleting user details Change the user.
     * active flag are false after delete operation.
     *
     * @param userID
     *            delete user details by ID.
     * @return
     */
    @RequestMapping(value = "/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<UserResponseEntity> deleteUserDetailsByID(@PathVariable("userid") String userid,
            @RequestHeader(value = "accessToken", required = true) String accessToken) {
        String message = null;
        ResponseEntity<UserResponseEntity> response = null;
        if (logger.isInfoEnabled()) {
            logger.info("User Request is received for User Update :::::: " + userid);
        }
        try {
            message = userService.deleteUser(userid);

            if (message != null) {

                logger.debug("User deleted succesfully for : " + userid);
                response = new ResponseEntity<>(new UserResponseEntity(HttpStatus.OK.value(), DELETE_MESSAGE),
                        HttpStatus.OK);
            } else {

                response = new ResponseEntity<>(
                        new UserResponseEntity(HttpStatus.NOT_FOUND.value(), UPDATE_MESSAGE_ERROR),
                        HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error("Error occured while deleting user details. " + ex.getCause());
        }
        return response;
    } /* END HERE */

}
