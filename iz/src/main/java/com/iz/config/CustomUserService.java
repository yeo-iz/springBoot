package com.iz.config;

import com.iz.pojo.SysRole;
import com.iz.pojo.SysUser;
import com.iz.repository.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/3
 * @remark
 */
public class CustomUserService implements UserDetailsService {

  @Autowired SysUserMapper sysUserMapper;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    SysUser user = sysUserMapper.getUser(userName);
    if (null == user) {
      throw new UsernameNotFoundException("用户名不存在");
    }

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    if (!CollectionUtils.isEmpty(user.getRoles())) {
      for (SysRole role : user.getRoles()) {
        authorities.add(new SimpleGrantedAuthority(role.getName()));
      }
    }

    return new User(
        user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassWord()), authorities);
  }
}
