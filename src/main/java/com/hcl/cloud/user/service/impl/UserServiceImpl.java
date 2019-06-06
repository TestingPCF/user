/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.cloud.user.constant.TokenResponse;
import com.hcl.cloud.user.constant.UserConstant;
import com.hcl.cloud.user.dto.AddressDTO;
import com.hcl.cloud.user.dto.UserDTO;
import com.hcl.cloud.user.entity.Address;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.exception.UserAlreadyExistException;
import com.hcl.cloud.user.exception.UserNotFoundException;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.UserService;;

/**
 * @author Dinesh Sharma
 *
 */
@Service
@RefreshScope
public class UserServiceImpl implements UserService {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    
    @Value("${user.uaa.endpoint}")
    private String url;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    ModelMapper mapper = null;

    /**
     *
     * @param user
     *            for save.
     * @return tag for user.
     */
    @Override
    @Transactional
    public User saveUser(UserDTO userDTO) throws UserAlreadyExistException{
        User user = new User();
        if (userDTO != null) {
            try {
                user = translateDTO(userDTO, user);
                user = userRepository.save(user);
                if (user != null) {
                    LOG.debug("User Registration successfully completed for  " + userDTO.getEmail());
                }
            } catch (DataIntegrityViolationException ex) {
                LOG.error("Error Occured while Registering user. " + ex.getCause());
                throw new DataIntegrityViolationException("USER ALREADY EXIST");
            }
        }
        return user;
    } /* END HERE */

    /**
     *
     * @param userDTO
     *            for update user.
     * @throws UserNotFoundException 
     * @throws NotFoundException
     */
    @Override
    @Transactional
    public User updateUser(UserDTO userDTO) throws UserNotFoundException {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user != null) {
        	
            LOG.debug("INSIDE updateUser METHOD: " + userDTO.getEmail());
            
            translateDTO(userDTO, user);
            user = userRepository.save(user);
            
            LOG.debug("User updated successfully for >>>>>>: " + userDTO.getEmail());
            
        } else {
        	 LOG.debug("User does not  successfully for >>>>>>: " + userDTO.getEmail());
        	throw new UserNotFoundException("USER NOT FOUND");
        }
        return user;
    } /* END HERE */

    /**
     *
     * translateDTO to user object
     *
     * @param userDTO
     *            for translateDTO.
     * @param user
     *            for User.
     * @return tag for user.
     */
    public User translateDTO(UserDTO userDTO, User user) {
        LOG.debug("Enter translateDTO method: " + userDTO);
        final UUID uuid = UUID.randomUUID();
        user.setUserName(uuid.toString());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEnabled(userDTO.isEnabled());
        user.setActive(userDTO.getActive());
        user.setExpired(userDTO.isExpired());
        user.setLoacked(userDTO.isLoacked());
        user.setRole(userDTO.getRole());
        final Set<Address> set = translateAddressDTO(userDTO.getUserAddress(), user);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUserAddress(set);
        return user;
    } /* END HERE */

    /**
     *
     * Translate list of user to list of UserDTO
     *
     * @param userDTO
     *            for translateDTO.
     * @param user
     *            for List.
     * @return for user DTO.
     */
    public List<UserDTO> translateUserDetails(List<User> users) {
        LOG.debug("Enter translateDTO method: " + users);
        final UserDTO dto = new UserDTO();
        final List<UserDTO> userDTOs = new ArrayList<>();
        for (final User user : users) {
            dto.setUserName(user.getUserName());
            dto.setEmail(user.getEmail());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setPhoneNumber(user.getPhoneNumber());
            dto.setUserAddress(translateAddress(user.getUserAddress()));
            dto.setActive_user(user.isActive_user());
            dto.setPassword(user.getPassword());
            userDTOs.add(dto);
        }
        return userDTOs;
    } /* END HERE */

    /**
     *
     * translate Address DTO
     *
     * @param addressDto
     *            translate Address DTO.
     * @return tag for address.
     */
    public Set<Address> translateAddressDTO(List<AddressDTO> addressDto, User user) {
        final Set<Address> addressSet = new HashSet<>();
        LOG.debug("Enter translateAddressDTO method and addressDto: " + addressDto);
        for (final AddressDTO addr : addressDto) {
            final Address address = new Address();
            address.setAddressDescription(addr.getAddress());
            address.setAddressType(addr.getAddressType());
            address.setCity(addr.getCity());
            address.setPincode(addr.getPincode());
            address.setCountry(addr.getCountry());
            address.setState(addr.getState());
            address.setUserAddress(user);
            addressSet.add(address);
        }

        return addressSet;
    } /* END HERE */

    /**
     *
     * translate Address DTO
     *
     * @param addressDto
     *            translate Address.
     * @return tag for addressDTO.
     */
    public List<AddressDTO> translateAddress(Set<Address> address) {
        final List<AddressDTO> addressList = new ArrayList<>();
        final AddressDTO addressDto = new AddressDTO();
        LOG.debug("Enter translateAddressDTO method and addressDto: " + addressDto);
        for (final Address addr : address) {
            addressDto.setAddress(addr.getAddressDescription());
            addressDto.setAddressType(addr.getAddressType());
            addressDto.setCity(addr.getCity());
            addressDto.setPincode(addr.getPincode());
            addressDto.setCountry(addr.getCountry());
            addressDto.setState(addr.getState());
            addressList.add(addressDto);
        }
        return addressList;
    } /* END HERE */

    /**
     *
     * @param userId
     *            for Delete user.
     */
    @Override
    @Transactional
    public String deleteUser(String emailId) throws UserNotFoundException{
        LOG.info("Inside deleteUser method for : " + emailId);
        final User user = userRepository.findByEmail(emailId);
        if (user != null) {
        	
            userRepository.delete(user);
            LOG.debug("User deleted successfully for ::: " + emailId);
            
        } else {
            LOG.debug("User not found for ::: " + emailId);
            throw new UserNotFoundException("USER NOT FOUND");
        }
        return UserConstant.USER_DELETED;
    } /* END HERE */

    /**
     *
     * @param userId
     *            for find user role by id.
     * @return tag for user DTO.
     */
    @Override
    @Transactional
    public List<UserDTO> findUserRoleByID(String accessToken) {
        User user = null;
        List<User> userList = new ArrayList<>();
        List<UserDTO> dtos = null;
        LOG.info("Request received for  accessToken:::::::: " + accessToken);

        final String emailID = getUserIDFromAccessToken(accessToken);
        final String userRole = userRepository.findUserRoleById(emailID);
        if (UserConstant.ADMINROLE.equalsIgnoreCase(userRole)) {
            userList = userRepository.findAll();
            dtos = translateUserDetailsForOrder(userList);
        } else if (UserConstant.USERROLE.equalsIgnoreCase(userRole)) {
            user = findUserDetailsByID(emailID);
            userList.add(user);
            dtos = translateUserDetailsForOrder(userList);
        }
        return dtos;
    } /* END HERE */

    /**
     *
     * translateDTO
     *
     * @param userDTO
     *            for translateDTO.
     * @param user
     *            for List.
     * @return for user DTO.
     */
    public List<UserDTO> translateUserDetailsForOrder(List<User> users) {
        LOG.debug("Enter translateDTO method: " + users);
        final UserDTO dto = new UserDTO();
        final List<UserDTO> userDTOs = new ArrayList<>();
        for (final User user : users) {
            dto.setUserName(user.getUserName());
            dto.setEmail(user.getEmail());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setPhoneNumber(user.getPhoneNumber());
            dto.setUserAddress(translateAddress(user.getUserAddress()));
            dto.setActive_user(user.isActive_user());
            userDTOs.add(dto);
        }
        return userDTOs;
    }

    /**
     * getUserIDFromAccessToken
     */
    public String getUserIDFromAccessToken(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        TokenResponse userid = null;
        try {
            LOG.info("Requesting user detail from UAA for :::::::: " + accessToken);
            LOG.info("Using the url of UAA =>>>>>>>> " + url);
            URI uri = new URI(url);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            requestHeaders.add("accessToken", accessToken);
            HttpEntity<String> entity = new HttpEntity<String>(requestHeaders);
            response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            LOG.info("Response received from UAA ::: " + response.getBody());

            userid = new ObjectMapper().readValue(response.getBody(), TokenResponse.class);
        } catch (Exception e) {
            LOG.error("Exception occure on calling of UAA ::: " + e.getCause());
        }
        return userid.getUserId();

    }

    /**
     *
     * findUserDetailsByID
     *
     * @param userID
     * @return
     */
    @Override
    public User findUserDetailsByID(String emailId) {
        return userRepository.findByEmail(emailId);
    }

}
