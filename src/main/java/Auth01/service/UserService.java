package Auth01.service;

import Auth01.domain.Role;
import Auth01.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleNAme);
    User getUser(String username);
    List<User>getUsers();

}
