/**
 * Copyright (c) HCL PCF TEAM ,2019
 *//*
package com.hcl.cloud.user.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hcl.cloud.user.DTO.AddressDTO;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.constant.UserConstantTest;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.impl.UserServiceImpl;

*//**
 * com.user.usermodule.service abhishek_sin
 *//*
@PrepareForTest(UserServiceImpl.class)
@RunWith(PowerMockRunner.class)
public class UserServiceImplTest {

	*//**
	 * USERDTO Mock
	 *//*
	@Mock
	private UserDTO userDTOMock;
	*//**
	 * USER Mock
	 *//*
	@Mock
	private User userMock;
	*//**
	 * userRepository
	 *//*
	@Mock
	private UserRepository userRepositoryMock;
	*//**
	 * ModelMapper
	 *//*
	@Mock
	private ModelMapper modelMapperMock;
	*//**
	 * Address
	 *//*
	@Mock
	private AddressDTO addressDTOMock;
	*//**
	 * Mock Object for {@link UserServiceImpl}
	 *//*
	@InjectMocks
	private UserServiceImpl userServiceImplMock;

	*//**
	 * This Method is called before the test is executed.
	 * 
	 * @throws Exception
	 *//*
	@Before
	public void setUp() throws Exception {
		modelMapperMock = new ModelMapper();
		this.userServiceImplMock = Mockito.spy(new UserServiceImpl());
		MockitoAnnotations.initMocks(this);
	}
	*//**
	 * saveUserdetailsTest
	 *//*
	@Test
	public void saveUserdetailsSuccessTest() {
		Mockito.when(addressDTOMock.getAddress()).thenReturn(UserConstantTest.ADDRESS);
		Mockito.when(addressDTOMock.getCity()).thenReturn(UserConstantTest.CITY);
		Mockito.when(addressDTOMock.getCountry()).thenReturn(UserConstantTest.COUNTRY);
		Mockito.when(addressDTOMock.getPincode()).thenReturn(UserConstantTest.PINCODE);
		Mockito.when(addressDTOMock.getState()).thenReturn(UserConstantTest.STATE);
		Mockito.when(addressDTOMock.getAddressType()).thenReturn(UserConstantTest.BILLING);
		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setAddress(UserConstantTest.ADDRESS);
		addressDTO.setCity(UserConstantTest.CITY);
		addressDTO.setCountry(UserConstantTest.COUNTRY);
		addressDTO.setPincode(UserConstantTest.PINCODE);
		addressDTO.setState(UserConstantTest.STATE);
		addressDTO.setAddressType(UserConstantTest.BILLING);
		UserDTO userDTO = new UserDTO();
		List<AddressDTO> addDTOList = new ArrayList<>();
		addDTOList.add(addressDTO);
		userDTO.setFirst_name(UserConstantTest.FIRST_NAME);
		userDTO.setLast_name(UserConstantTest.LAST_NAME);
		userDTO.setPassword(UserConstantTest.PASSWORD);
		userDTO.setPhone_number(UserConstantTest.PHONE_NUMBAR);
		userDTO.setUserName(UserConstantTest.USER_NAME);
		userDTO.setEmail(UserConstantTest.EMAIL);
		//userDTO.setActive_user(true);
		userDTO.setUser_address(addDTOList);
		Mockito.when(userDTOMock.getUserName()).thenReturn(UserConstantTest.USER_NAME);
		Mockito.when(userDTOMock.getEmail()).thenReturn(UserConstantTest.EMAIL);
		Mockito.when(userDTOMock.getUser_address()).thenReturn(addDTOList);
		Mockito.when(userDTOMock.getFirst_name()).thenReturn(UserConstantTest.FIRST_NAME);
		Mockito.when(userDTOMock.getLast_name()).thenReturn(UserConstantTest.LAST_NAME);
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(modelMapperMock.map(userMock, UserDTO.class)).thenReturn(userDTOMock);
		Mockito.when(userDTOMock.getUser_address()).thenReturn(addDTOList);
		userServiceImplMock.saveUser(userDTO);
	}
	*//**
	 * saveUserdetailsFailTest
	 *//*
	@Test
	public void saveUserdetailsFailTest() {
		Mockito.when(addressDTOMock.getAddress()).thenReturn(UserConstantTest.ADDRESS);
		Mockito.when(addressDTOMock.getCity()).thenReturn(UserConstantTest.CITY);
		Mockito.when(addressDTOMock.getCountry()).thenReturn(UserConstantTest.COUNTRY);
		Mockito.when(addressDTOMock.getPincode()).thenReturn(UserConstantTest.PINCODE);
		Mockito.when(addressDTOMock.getState()).thenReturn(UserConstantTest.STATE);
		Mockito.when(addressDTOMock.getAddressType()).thenReturn(UserConstantTest.BILLING);
		AddressDTO addressDTO=new AddressDTO();
		UserDTO userDTO = new UserDTO();
		List<AddressDTO> addDTOList = new ArrayList<>();
		addDTOList.add(addressDTO);
		userDTO.setUser_address(addDTOList);
		Mockito.when(userDTOMock.getEmail()).thenReturn(UserConstantTest.EMAIL);
		Mockito.when(userDTOMock.getUser_address()).thenReturn(addDTOList);
		Mockito.when(userDTOMock.getFirst_name()).thenReturn(UserConstantTest.FIRST_NAME);
		Mockito.when(userDTOMock.getLast_name()).thenReturn(UserConstantTest.LAST_NAME);
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(modelMapperMock.map(userMock, UserDTO.class)).thenReturn(userDTOMock);
		Mockito.when(userDTOMock.getUser_address()).thenReturn(addDTOList);
		userServiceImplMock.saveUser(userDTO);
	}


	*//**
	 * updateUserdetailsTest
	 *//*
	@Test
	public void updateUserdetailsTest() {
		List<AddressDTO> addDTOList = new ArrayList<>();
		addDTOList.add(addressDTOMock);
		UserDTO userDTO = new UserDTO();
		userDTO.setFirst_name(UserConstantTest.FIRST_NAME);
		userDTO.setLast_name(UserConstantTest.LAST_NAME);
		userDTO.setPassword(UserConstantTest.PASSWORD);
		userDTO.setPhone_number(UserConstantTest.PHONE_NUMBAR);
		userDTO.setUserName(UserConstantTest.USER_NAME);
		userDTO.setEmail(UserConstantTest.EMAIL);
		Mockito.when(addressDTOMock.getAddress()).thenReturn(UserConstantTest.ADDRESS);
		Mockito.when(addressDTOMock.getCity()).thenReturn(UserConstantTest.CITY);
		Mockito.when(addressDTOMock.getCountry()).thenReturn(UserConstantTest.COUNTRY);
		Mockito.when(addressDTOMock.getPincode()).thenReturn(UserConstantTest.PINCODE);
		Mockito.when(addressDTOMock.getState()).thenReturn(UserConstantTest.STATE);
		Mockito.when(userDTOMock.getUserName()).thenReturn(UserConstantTest.USER_NAME);
		Mockito.when(userDTOMock.getEmail()).thenReturn(UserConstantTest.EMAIL);
		Mockito.when(userDTOMock.getUser_address()).thenReturn(addDTOList);
		Mockito.when(userDTOMock.getFirst_name()).thenReturn(UserConstantTest.FIRST_NAME);
		Mockito.when(userDTOMock.getLast_name()).thenReturn(UserConstantTest.LAST_NAME);
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(modelMapperMock.map(userMock, UserDTO.class)).thenReturn(userDTOMock);
		userServiceImplMock.updateUser(userDTO);
	}

	*//**
	 * deleteUserdetailsTest
	 *//*
	@Test
	public void deleteUserdetailsTest() {
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(userRepositoryMock.findByUserName(UserConstantTest.USER_NAME)).thenReturn(userMock);
		userServiceImplMock.deleteUser(UserConstantTest.USER_NAME);
	}
	
	*//**
	 * deleteUserdetailsFailTest
	 *//*
	@Test
	public void deleteUserdetailsFailTest() {
		userServiceImplMock.deleteUser(UserConstantTest.USER_NAME);
	}
	
	*//**
	 * findUserRoleByID
	 *//*
	@Test
	public void findUserRoleByIDTest() {
		List<User> userList = new ArrayList<>();
		 User user=new User();
		 user.setFirst_name(UserConstantTest.FIRST_NAME);
		 user.setLast_name(UserConstantTest.LAST_NAME);
		 user.setPassword(UserConstantTest.PASSWORD);
		 user.setPhone_number(UserConstantTest.PHONE_NUMBAR);
		 user.setUserName(UserConstantTest.USER_NAME);
		 user.setEmail(UserConstantTest.EMAIL);
		 userList.add(user);
		Mockito.when(userRepositoryMock.findByUserName(UserConstantTest.USER_ID)).thenReturn(user);
		Mockito.when(userRepositoryMock.findAll()).thenReturn(userList);
		Mockito.when(userRepositoryMock.findUserRoleById(UserConstantTest.USER_ID)).thenReturn(UserConstantTest.USER_ID);
		userServiceImplMock.findUserRoleByID(UserConstantTest.AUTH_TOKEN);
	}
}
*/