package com.asd.opdracht3.Identity.Application;

import com.asd.opdracht3.Identity.Domain.model.role.Role;
import com.asd.opdracht3.Identity.Domain.model.role.RoleId;
import com.asd.opdracht3.Identity.Domain.model.user.User;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.RoleRepositoryImpl;
import com.asd.opdracht3.Identity.Port.adapter.persistence.repository.UserRepositoryImpl;
import com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent.UserId;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    private final UserRepositoryImpl userRepository;
    private final RoleRepositoryImpl roleRepository;

    public UserApplicationService(UserRepositoryImpl userRepository, RoleRepositoryImpl roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public boolean canSubmitEvent(UserId userId){
        User user = userRepository.getById(userId);
        Role role = roleRepository.getById(user.getRoleId());
        return role.getUserPermissions().CanSubmitEvent();
    }

    public boolean canEditEvent(UserId userId){
        User user = userRepository.getById(userId);
        Role role = roleRepository.getById(user.getRoleId());
        return role.getUserPermissions().CanEditEvent();
    }

    public void updateUserRole(UserId activeUserId, UserId targetUserid, RoleId targetRoleId){
        User activeUser = userRepository.getById(activeUserId);
        if (activeUser.canAssignRoles(activeUser.getRoleId(), roleRepository)) {
            User targetUser = userRepository.getById(targetUserid);
            Role targetRole = roleRepository.getById(targetRoleId);
            targetUser.setRoleId(targetRole.getRoleId());
            userRepository.store(targetUser);
        }
        else {
            throw new RuntimeException();
        }
    }
}
