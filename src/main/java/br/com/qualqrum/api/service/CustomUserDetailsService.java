package br.com.qualqrum.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.qualqrum.api.dao.AppUserRepository;
import br.com.qualqrum.api.model.AppUser;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private AppUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<AppUser> user = userRepository.findByEmail(email);
    if (user.isPresent()) {
      AppUser appuser = user.get();
      return User.withUsername(appuser.getEmail()).password(appuser.getPassword()).authorities("USER").build();
    }
    throw new UsernameNotFoundException(String.format("Email [%s] not found", email));
  }
}