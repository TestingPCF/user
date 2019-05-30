/**
 *
 */
package com.hcl.cloud.user.service;

import java.util.List;

import com.hcl.cloud.user.dto.UserDTO;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.exception.UserAlreadyExistException;
import com.hcl.cloud.user.exception.UserNotFoundException;

/**
 * @author abhishek_sin
 *
 */
public interface UserService {

    /**
     *
     * findUserDetailsByID.
     *
     * @param userID
     *            for find.
     * @return tag.
     */
    User findUserDetailsByID(String userID);

    /**
     *
     * saveUser.
     *
     * @param user
     *            for save.
     * @return tag.
     */
    User saveUser(UserDTO user)  throws UserAlreadyExistException;

    /**
     *
     * updateUser.
     *
     * @param userDTO
     *            for update
     * @return tag.
     */
    User updateUser(UserDTO userDTO) throws UserNotFoundException;

    /**
     *
     * deleteUser.
     *
     * @param userId
     *            for delete.
     * @return tag.
     */
    String deleteUser(String userId) throws UserNotFoundException;

    /**
     * findUserRoleByID.
     *
     * @param accessToken
     *            for find user role by id
     * @return tag.
     */
    List<UserDTO> findUserRoleByID(String accessToken);
}
