package com.in28minutes.restfulservices.restapi.model.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User
{
    private Long   id;

    @Size(min = 2)
    private String name;

    @Past
    private Date   birthDate;

    public User()
    {
    }

    public User(Long id, String name, Date birthDate)
    {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
}
