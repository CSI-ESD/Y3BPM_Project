package com.alexandru.esdbloodpressure.services;

import com.alexandru.esdbloodpressure.exceptions.EmailAlreadyExistsException;
import com.alexandru.esdbloodpressure.exceptions.UserAlreadyExistsException;
import com.alexandru.esdbloodpressure.models.Authority;
import com.alexandru.esdbloodpressure.models.User;
import com.alexandru.esdbloodpressure.models.UserDto;
import com.alexandru.esdbloodpressure.repositories.AuthorityRepository;
import com.alexandru.esdbloodpressure.repositories.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerNewUserAccount(UserDto userDto) throws UserAlreadyExistsException, EmailAlreadyExistsException {
        if (userExists(userDto)) {
            throw new UserAlreadyExistsException("An account with the same username already exists: " + userDto.getUsername());
        }
        if (emailExist(userDto.getEmail())) {
            throw new EmailAlreadyExistsException("There is an account with that email adress: " + userDto.getEmail());
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encryptedPassword);
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEnabled(true);
        //Set<Authority> authorities = new HashSet<>();
        //authorities.add(authorityRepository.findByName("ROLE_USER"));
        //user.setAuthorities(authorities);
        user.setAuthorities(new HashSet<>(Arrays.asList(new Authority("ROLE_USER", user))));
        //user.setAuthorities(new HashSet<>(Arrays.asList(authorityRepository.findByName("ROLE_USER"))));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        //userRepository.save(user);
    }

    public boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean userExists(UserDto user) {
        return userRepository.findByUsername(user.getUsername()) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserBuilder builder = null;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] authorities = user.getAuthorities()
                    .stream().map(a -> a.getName()).toArray(String[]::new);

            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

}
