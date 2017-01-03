import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

#set($symbol_pound='#')
        #set($symbol_dollar='$')
        #set($symbol_escape='\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
        package ${package}.${artifactId}.business.users;
        {package}.${artifactId}.business.AbstractService;
        {package}.${artifactId}.domain.users.User;

/**
 * User Service
 */
@Service
public class UserService extends AbstractService implements UserDetailsService {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<User> allUsers = getDAO().getAll(getEntityClass());
            User foundUser = allUsers.stream()
                    .filter(
                            (user) -> user.getUsername().equals(username) && !user.isDeleted()
                    )
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException(username));
            return foundUser;
        } catch (UsernameNotFoundException unfe) {
            throw unfe;
        } catch (Throwable t) {
            throw new RuntimeException("Authentication service failure. Please contact the administrator");
        }
    }
}
