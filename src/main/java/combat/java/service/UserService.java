package combat.java.service;

import combat.java.entity.User;
import combat.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public Optional<User> listUser(Integer id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.findById(id);
        userRepository.deleteById(id);
    }

    public void update (Integer id, User userUpdated) {
        userRepository.
                findById(id)
                .map(user -> {
                    userUpdated.setId(user.getId());
                    userUpdated.setCreatedAt(user.getCreatedAt());
                    return userRepository.save(userUpdated);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não atualizado!"));
    }
}
