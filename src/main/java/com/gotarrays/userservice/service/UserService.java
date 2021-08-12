package com.gotarrays.userservice.service;

import com.gotarrays.userservice.domain.Role;
import com.gotarrays.userservice.domain.User;
import java.util.List;

public interface UserService {
  User saveUser(User user);
  Role saveRole(Role role);
  void addRoleToUser(String username, String roleName);
  User getUser(String username);
  List<User> getUsers();
}
