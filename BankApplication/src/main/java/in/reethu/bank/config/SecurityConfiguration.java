package in.reethu.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	public void configureAuthority(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication().withUser("reethu").password("{noop}govind").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("swetha").password("{noop}govind").roles("MANAGER");
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll()
				.antMatchers("/offers").authenticated()
				.antMatchers("/loanApprove").hasRole("MANAGER")
				.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")
				.anyRequest().authenticated()
				.and().formLogin()
				.and().rememberMe()
				.and().logout()
				.and().exceptionHandling().accessDeniedPage("/denied");
		return http.build();
	}
}
