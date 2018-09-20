package com.in28minutes.restfulservices.restapi.controller.user;


import com.in28minutes.restfulservices.restapi.controller.user.exception.UserResourceNotFoundException;
import com.in28minutes.restfulservices.restapi.model.user.User;
import com.in28minutes.restfulservices.restapi.persistence.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController
{
    @Autowired
    @Qualifier("userDaoImpl")
    UserDaoImpl userDaoImpl;


    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> getAllUsers()
    {
        if (userDaoImpl.getAllUsers() == null)
        {
            throw new UserResourceNotFoundException("User resource not found.");
        }
        return userDaoImpl.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public Resource<User> getUserById(@PathVariable Long id)
    {
        if (userDaoImpl.getUserById(id) == null)
        {
            throw new UserResourceNotFoundException("User resource not found.");
        }

        User user = userDaoImpl.getUserById(id);

        //HATEOAS
        Resource<User>        resource = new Resource<>(user);
        ControllerLinkBuilder linkTo   = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user)
    {
        User addedUser = userDaoImpl.addUser(user);
        URI  location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
