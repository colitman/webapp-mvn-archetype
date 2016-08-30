#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.business.users;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${package}.business.ResourceNotFoundException;
import ${package}.business.DefaultService;
import ${package}.data.ObjectNotExistsException;
import ${package}.domain.users.User;

import java.util.List;

/**
 * User Service
 */
@Service
public class UserService extends DefaultService implements UserServiceInterface {

    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!exists(username)) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        }

        User user = null;
        try {
            user = get(getDAO().getKeyByName(User.class, username));
        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        } catch (ObjectNotExistsException e) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        }

        return user;
    }

    @Override
    @Transactional
    public boolean exists(String username) {
        try {
            return exists(User.class, getDAO().getKeyByName(User.class, username));
        } catch (ObjectNotExistsException e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean exists(Long key) {
        return exists(User.class, key);
    }

    @Override
    @Transactional
    public User get(Long key) throws ResourceNotFoundException {
        return get(User.class, key);
    }

    @Override
    @Transactional
    public List<User> list() {
        return list(User.class);
    }
}
