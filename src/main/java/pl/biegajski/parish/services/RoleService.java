package pl.biegajski.parish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biegajski.parish.model.Role;
import pl.biegajski.parish.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findRoleById(Long id){
        return roleRepository.findById(id);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
