package com.in28minutes.restfulservices.restapi.persistence;

import com.in28minutes.restfulservices.restapi.model.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("userDaoImpl")
public class UserDaoImpl implements GenericConfigDaoImpl
{
    private static List<User> userList = new ArrayList<>();

    static
    {
        userList.add(new User(1L, "Abhijeet", new Date(1995, 12, 04)));
        userList.add(new User(2L, "Ankit", new Date(1995, 12, 04)));
        userList.add(new User(3L, "Tikna", new Date(1995, 12, 04)));
    }

    public Integer getNumberOfUsers()
    {
        return userList.size();
    }

    public List<User> getAllUsers()
    {
        return userList;
    }

    public User getUserById(Long id)
    {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public User addUser(User user)
    {
        user.setId((long) userList.size() + 1L);
        return user;
    }
}
