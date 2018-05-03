package com.alexandru.esdbloodpressure.repositories;

import com.alexandru.esdbloodpressure.models.Authority;
import javax.ejb.Singleton;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Singleton
@Repository
public class AuthorityRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Authority findByName(String authority) {
        return (Authority) sessionFactory.getCurrentSession().get(Authority.class, authority);
    }
}
