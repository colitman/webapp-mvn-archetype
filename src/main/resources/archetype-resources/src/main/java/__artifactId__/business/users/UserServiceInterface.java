#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.${artifactId}.business.users;

import org.springframework.security.core.userdetails.UserDetailsService;
import ${package}.${artifactId}.business.DefaultServiceInterface;
import ${package}.${artifactId}.business.ResourceNotFoundException;
import ${package}.${artifactId}.domain.users.User;

import java.util.List;

/**
 * @author dmytro.romenskyi - Jun 30, 2016
 *
 */
public interface UserServiceInterface extends DefaultServiceInterface, UserDetailsService {

	/**
	 * Checks whether the user with provided username exists
	 *
	 * @param username username to check
	 * @return true is user with provided username exists; false otherwise
	 */
	boolean exists(String username);

	/**
	 * Checks whether the user with provided key exists
	 *
	 * @param key key to check
	 * @return true is user with provided key exists; false otherwise
	 */
	boolean exists(Long key);

	/**
	 * Gets user by key
	 *
	 * @param key key to search
	 *
	 * @return User with provided ID
	 *
	 * @throws ResourceNotFoundException if user with provided ID does not exist
	 */
	User get(Long key) throws ResourceNotFoundException;

	/**
	 * Gets all users
	 *
	 * @return a list of all users or empty list if there are no user entries
	 */
	List<User> list();
	

}