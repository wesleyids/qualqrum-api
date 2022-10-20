package br.com.qualqrum.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.qualqrum.api.model.User;
import br.com.qualqrum.api.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);
    if (user.isPresent()) {
      User appuser = user.get();
      return User.withUsername(appuser.getUsername()).password(appuser.getPassword()).authorities("USER").build();
    }
    throw new UsernameNotFoundException(String.format("Username [%s] not found", username));
  }
}