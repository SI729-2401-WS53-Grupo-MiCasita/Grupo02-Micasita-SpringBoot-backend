package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;
<<<<<<< HEAD

=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> d4edeca1fed28563b53cf9b8a9dcf65e15a4e0cb
import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.UserRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.User;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

<<<<<<< HEAD
=======
    @Autowired
>>>>>>> d4edeca1fed28563b53cf9b8a9dcf65e15a4e0cb
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setDni(userDetails.getDni());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPhone(userDetails.getPhone());
            user.setAddress(userDetails.getAddress());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}