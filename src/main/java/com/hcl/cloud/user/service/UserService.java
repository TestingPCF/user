/**
 *
 */
package com.hcl.cloud.user.service;

import java.util.List;

import com.hcl.cloud.user.dto.UserDTO;
import com.hcl.cloud.user.entity.User;

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
    User saveUser(UserDTO user);

    /**
     *
     * updateUser.
     *
     * @param userDTO
     *            for update
     * @return tag.
     */
    User updateUser(UserDTO userDTO);

    /**
     *
     * deleteUser.
     *
     * @param userId
     *            for delete.
     * @return tag.
     */
    String deleteUser(String userId);

    /**
     * findUserRoleByID.
     *
     * @param accessToken
     *            for find user role by id
     * @return tag.
     */
    List<UserDTO> findUserRoleByID(String accessToken);
}
