package com.alexandru.esdbloodpressure.services;

import com.alexandru.esdbloodpressure.exceptions.EmailAlreadyExistsException;
import com.alexandru.esdbloodpressure.exceptions.UserAlreadyExistsException;
import com.alexandru.esdbloodpressure.models.User;
import com.alexandru.esdbloodpressure.models.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
public interface UserService extends UserDetailsService {

    public String registerNewUserAccount(UserDto userDto) throws UserAlreadyExistsException, EmailAlreadyExistsException;

    public void deleteUser(User user);

    public User findUserByUsername(String username);

    public User findUserByEmail(String email);

    public void changeUserPassword(User user, String password);

    public boolean emailExist(String email);

    public boolean userExists(UserDto user);

}
