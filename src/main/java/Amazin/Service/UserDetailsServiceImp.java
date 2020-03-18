package Amazin.Service;

import Amazin.entity.User;
import Amazin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();


        /**This must check for what roles are associated to the specified users
         * 
        for(Role role : user.getRole()){
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
         */

    return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), grantedAuthorities);
    }
}
