package bookshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author antonTkachenko
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/filter", "/order/{bookId}/new", "/order/saveOrder").permitAll()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and()
            .formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=Wrong password or login!")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.defaultSuccessUrl("/admin/panel", false)
				.permitAll()
				.and()
            .logout()
            	.logoutUrl("/logout")
            	.invalidateHttpSession(true)
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.addFilterBefore(new CharacterEncodingFilter("UTF-8", true), CsrfFilter.class);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
