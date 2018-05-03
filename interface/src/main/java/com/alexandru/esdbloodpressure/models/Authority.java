package com.alexandru.esdbloodpressure.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    @Column(name = "authority")
    String name;

    @JsonBackReference
    @ManyToOne
    @Id
    @JoinColumn(name = "username")
    User user;

    public Authority() {
    }

    public Authority(String name) {
        this.name = name;
    }

    public Authority(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authority{" + "name=" + name + ", user=" + user.getUsername() + '}';
    }

}
