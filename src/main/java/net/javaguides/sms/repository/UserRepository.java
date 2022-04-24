package net.javaguides.sms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.sms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
	@Query("select u from User u where u.email=:email")
	public User getUserByUserName(@Param("email") String email);
	
}
