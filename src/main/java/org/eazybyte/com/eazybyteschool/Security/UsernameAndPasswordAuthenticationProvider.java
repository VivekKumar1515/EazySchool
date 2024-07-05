package org.eazybyte.com.eazybyteschool.Security;

import org.eazybyte.com.eazybyteschool.Model.Person;
import org.eazybyte.com.eazybyteschool.Model.Roles;
import org.eazybyte.com.eazybyteschool.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UsernameAndPasswordAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        Person person = personRepository.findByEmail(email);
        if(person != null && person.getPersonId() > 0 && passwordEncoder.matches(password, person.getPwd())) {
            return new UsernamePasswordAuthenticationToken(email, null, getGrantedAuthorities(person.getRole()));
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
