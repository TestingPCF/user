/**
 *
 */
package com.hcl.cloud.user.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hcl.cloud.user.constant.UserConstantTest;
import com.hcl.cloud.user.dto.UserDTO;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.service.UserService;

/**
 * @author abhishek_sin
 *
 */
@PrepareForTest(UserController.class)
@RunWith(value = PowerMockRunner.class)
public class UserControllerTest {

	@Mock
	private UserDTO userDTOMock;
	/**
	 * List<UserDTO> userDetails
	 */
	@Mock
	private List<UserDTO> userDetailsMock;

	/**
	 * User
	 */
	@Mock
	private User userMock;
	/**
	 * userService
	 */
	@Mock
	private UserService userServiceMock;
	/**
	 * Mock Object for {@link UserController}
	 */
	@InjectMocks
	private UserController userControllerMock;

	/**
	 * This Method is called before the test is executed.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.userControllerMock = Mockito.spy(new UserController());
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void saveUserDetailsTest() {
		Mockito.when(userServiceMock.saveUser(userDTOMock)).thenReturn(userMock);
		//userControllerMock.saveUserDetails(userDTOMock, UserConstantTest.AUTHTOKEN);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void getAllUserDetailsTest() {
		Mockito.when(userServiceMock.findUserRoleByID(UserConstantTest.AUTHTOKEN)).thenReturn(userDetailsMock);
		userControllerMock.getAllUserDetails(UserConstantTest.AUTHTOKEN);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void deleteUserDetailsByIDTest() {
		Mockito.when(userServiceMock.deleteUser(UserConstantTest.USERID)).thenReturn(null);
		userControllerMock.deleteUserDetailsByID(UserConstantTest.USERID, UserConstantTest.AUTHTOKEN);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void updateUserDetailsTest() {
		Mockito.when(userServiceMock.findUserRoleByID(UserConstantTest.AUTHTOKEN)).thenReturn(userDetailsMock);
		userControllerMock.updateUserDetails(userDTOMock/*, UserConstantTest.AUTHTOKEN*/);
	}
}
