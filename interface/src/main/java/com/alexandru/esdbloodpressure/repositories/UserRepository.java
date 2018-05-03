package com.alexandru.esdbloodpressure.repositories;

import com.alexandru.esdbloodpressure.models.User;
import java.util.List;
import javax.ejb.Singleton;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Singleton
@Repository
@Transactional
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().get(User.class, username);
    }

    public User findByEmail(String email) {
        return null;
    }

    public String save(User user) {
        return (String) sessionFactory.getCurrentSession().save(user);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
