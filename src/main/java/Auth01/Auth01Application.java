package Auth01;

import Auth01.domain.Role;
import Auth01.domain.User;
import Auth01.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Auth01Application {

	public static void main(String[] args) {
		SpringApplication.run(Auth01Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder() ;
	}


	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_Admin"));

			userService.saveUser(new User(null,"jhon trv","jhon","1234","med.abou.ouf55@gmail.com",new ArrayList<>()));
			userService.saveUser(new User(null,"med trv","med55","1234","med.abou.ouf34@gmail.com",new ArrayList<>()));
			userService.saveUser(new User(null,"will trv","med1235","1234","med.abou.ouf@gmail.com",new ArrayList<>()));
			userService.saveUser(new User(null,"med med","ADMINa","1234","med.ab@gmail.com",new ArrayList<>()));

			userService.addRoleToUser("jhon","ROLE_USER");
			userService.addRoleToUser("med55","ROLE_Admin");
			userService.addRoleToUser("med55","ROLE_USER");


		};
	}
}
