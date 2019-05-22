   
/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hcl.cloud.user.constant.UserConstantTest;
import com.hcl.cloud.user.dto.AddressDTO;
import com.hcl.cloud.user.dto.UserDTO;
import com.hcl.cloud.user.entity.Address;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.impl.UserServiceImpl;
import junit.framework.Assert;

/**
 * com.user.usermodule.service Dinesh Sharma
 */
@PrepareForTest({ UserServiceImpl.class, User.class, Address.class, AddressDTO.class, UserDTO.class})
public class UserServiceImplTest {

	/**
	 * USER Mock
	 */
	@Mock
	private User userMock;
	/**
	 * userRepository
	 */
	@Mock
	private UserRepository userRepositoryMock;
	/**
	 * ModelMapper
	 */
	@Mock
	private ModelMapper modelMapperMock;
	/**
	 * ResponseEntity<String> response
	 */
	@Mock
	private ResponseEntity<String> responseMock;

	/**
	 * Mock Object for {@link UserServiceImpl}
	 */
	@InjectMocks
	private UserServiceImpl userServiceImplMock;

	/**
	 * This Method is called before the test is executed.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelMapperMock = new ModelMapper();
		this.userServiceImplMock = Mockito.spy(new UserServiceImpl());
		MockitoAnnotations.initMocks(this);
	}

	
	/**
	 * @method saveUserdetailsSuccessTest
	 * Test case for saving User
	 */

	@Test
	public void saveUserdetailsSuccessTest() {
	UserServiceImpl userServiceImpl = new UserServiceImpl();
		
	UserDTO userDTO1 = new UserDTO();
	userDTO1.setEmail("abc@gail.com");
	userDTO1.setActive(1);
	userDTO1.setEnabled(true);
	userDTO1.setFirstName("ABC");
	userDTO1.setLastName("B");
	userDTO1.setExpired(false);
	userDTO1.setRole("A");
	userDTO1.setPassword("abc");
	AddressDTO addressDTO = new AddressDTO();
	addressDTO.setAddress("asfg");
	addressDTO.setCity("delhi");
	addressDTO.setAddressType("billing");
	addressDTO.setId(1);
	addressDTO.setPincode(121);
	addressDTO.setCountry("India");
	addressDTO.setState("Har");
	List<AddressDTO> userAddress = new ArrayList<AddressDTO>();
	userAddress.add(addressDTO);
	userDTO1.setUserAddress(userAddress);
	User user = new User();
	user.setEmail("abc@gmail.com");
	 
	UserRepository userRepository = Mockito.mock(UserRepository.class);
	userServiceImpl.setUserRepository(userRepository);
	Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
	User returnUser = userServiceImpl.saveUser(userDTO1 );
	Assert.assertEquals(returnUser.getEmail(), user.getEmail());
	}

	/**
	 * @method updateUserdetailsTest
	 * Test case for updating User
	 */

	@Test
	public void updateUserdetailsTest() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("abc@gail.com");
		userDTO.setActive(1);
		userDTO.setEnabled(true);
		userDTO.setFirstName("ABC");
		userDTO.setLastName("B");
		userDTO.setExpired(false);
		userDTO.setRole("A");
		userDTO.setPassword("abc");
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress("asfg");
		addressDTO.setCity("delhi");
		addressDTO.setId(1);
		addressDTO.setPincode(121);
		addressDTO.setCountry("India");
		addressDTO.setState("Har");
		addressDTO.setAddressType("billing");
		List<AddressDTO> userAddress = new ArrayList<AddressDTO>();
		userAddress.add(addressDTO);
		userDTO.setUserAddress(userAddress);
		 User user = new User();
		 user.setEmail("abc@gmail.com");
	
		UserRepository userRepository = Mockito.mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		Mockito.when(userRepository.findByEmail(Mockito.any(String.class))).thenReturn(user);
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User returnUser = userServiceImpl.updateUser(userDTO);
		Assert.assertEquals(returnUser.getEmail(), user.getEmail());
	}

	/**
	 * @method deleteUserdetailsTest
	 * Test case for deleting User
	 */
	@Test
	public void deleteUserdetailsTest() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user = new User();
		user.setEmail("abc@gmail.com");
		UserRepository userRepository = Mockito.mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		Mockito.when(userRepository.findByEmail(UserConstantTest.USERNAME)).thenReturn(user);
		userServiceImpl.deleteUser(UserConstantTest.USERNAME);
	}



	/**
	 *	@method findUserRoleByID
	 *	Test case for reterving list of user
	 *	by role User
	 */
	@Test(expected=NullPointerException.class)
	public void findUserRoleByIDTest() {
		BCryptPasswordEncoder encrit=new BCryptPasswordEncoder(12);
		String pwd=encrit.encode(UserConstantTest.PASSWORD);
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setFirstName(UserConstantTest.FIRSTNAME);
		user.setLastName(UserConstantTest.LASTNAME);
		user.setPassword(UserConstantTest.PASSWORD);
		user.setPhoneNumber(UserConstantTest.PHONENUMBAR);
		user.setUserName(UserConstantTest.USERNAME);
		user.setEmail(UserConstantTest.EMAIL);
		userList.add(user);
		userServiceImplMock.findUserRoleByID(UserConstantTest.AUTHTOKEN);
	}
}