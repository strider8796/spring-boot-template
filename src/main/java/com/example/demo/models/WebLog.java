package com.example.demo.models;

import com.example.demo.models.enumeration.WebLogAction;
import com.example.demo.models.enumeration.WebLogLocation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WebLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    private WebsiteUser user;
    private WebLogAction action;
    private WebLogLocation location;
    private Date created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public WebsiteUser getUser() {
//        return user;
//    }
//
//    public void setUser(WebsiteUser user) {
//        this.user = user;
//    }

    public WebLogAction getAction() {
        return action;
    }

    public void setAction(WebLogAction action) {
        this.action = action;
    }

    public WebLogLocation getLocation() {
        return location;
    }

    public void setLocation(WebLogLocation location) {
        this.location = location;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "WebLog{" +
                "id=" + id +
                ", action=" + action +
                ", location=" + location +
                ", created=" + created +
                '}';
    }
}
