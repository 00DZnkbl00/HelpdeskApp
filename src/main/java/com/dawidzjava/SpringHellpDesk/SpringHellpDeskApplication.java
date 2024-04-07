package com.dawidzjava.SpringHellpDesk;

import com.dawidzjava.SpringHellpDesk.dao.RoleDao;
import com.dawidzjava.SpringHellpDesk.dao.TicketDao;
import com.dawidzjava.SpringHellpDesk.dao.UserDao;
import com.dawidzjava.SpringHellpDesk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class SpringHellpDeskApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringHellpDeskApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(RoleDao roleDao, TicketDao ticketDao) {
		return runner -> {
			roleDao.save(new com.dawidzjava.SpringHellpDesk.entity.Role("ROLE_USER"));
			roleDao.save(new com.dawidzjava.SpringHellpDesk.entity.Role("ROLE_EMPLOYEE"));
			roleDao.save(new com.dawidzjava.SpringHellpDesk.entity.Role("ROLE_ADMIN"));
			Collection<Role> roles=new ArrayList<>();

			Ticket ticket=new Ticket("Drukarka nie działa","trzeszczy a nie drukuje",2);


			roles.add(roleDao.findRoleByName("ROLE_USER"));
			Employee employee = new Employee("123", "Adam", "Malysz", passwordEncoder.encode("123"), true, roles);

			roles.add(roleDao.findRoleByName("ROLE_ADMIN"));
			roles.add(roleDao.findRoleByName("ROLE_EMPLOYEE"));

			Client user=new Client("qwe","Jane","Ahonen", passwordEncoder.encode("qwe"), true,roles);
			ticket.addEmployee(employee);
			ticket.setClient(user);

			ticketDao.save(ticket);



		};
	}

}
