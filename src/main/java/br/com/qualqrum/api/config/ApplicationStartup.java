package br.com.qualqrum.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.qualqrum.api.repository.UserRepository;

@Component
public class ApplicationStartup implements ApplicationRunner {
// implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserRepository userRepository;

  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
  // @Override
  // public void onApplicationEvent(final ApplicationReadyEvent event) {

  //   // here your code ...
  //   System.out.println("print:: " + event);

  //   System.out.println(userRepository.findAll());

  //   return;
  // }

  @Override
  public void run(ApplicationArguments args) {
    System.out.println("usersss:: " + userRepository.findAll().size());
  }
}