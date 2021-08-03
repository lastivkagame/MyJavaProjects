package com.example.springboot.configure.security;


//import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.example.springboot.entities.Role;
import com.example.springboot.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomUserDetails fromUserEntityToCustomUserDetails(User userEntity) {
        CustomUserDetails c = new CustomUserDetails();
        c.login = userEntity.getUsername();
        c.password = userEntity.getPassword();

        List<String> names =
                userEntity.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toList());

        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();

        for (String item :
                names) {
            list.add(new SimpleGrantedAuthority(item));
        }
        
        c.grantedAuthorities = list; //Collections.singletonList(list);
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}