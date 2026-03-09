package fi.haagahelia.bookstore.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.bookstore.domain.AppUser;
import fi.haagahelia.bookstore.domain.AppUserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppUserRepository repository;

    // Constructor Injection
    public UserDetailServiceImpl(AppUserRepository appUserRepository) {
        this.repository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = repository.findByUsername(username);

        if (curruser == null) {
            throw new UsernameNotFoundException("User and password wrong");
        }

        return new org.springframework.security.core.userdetails.User(
                curruser.getUsername(),
                curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
    }
}