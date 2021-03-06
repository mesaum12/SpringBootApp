package net.javaguides.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired 
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.getUserByUserName(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("Could not find user!!");
		}
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
		
		return customUserDetails;
	
	}

}
