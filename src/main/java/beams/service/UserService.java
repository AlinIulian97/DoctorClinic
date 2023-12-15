package beams.service;

import beams.entity.Doctor;
import beams.entity.User;
import beams.mapper.UserMapper;
import beams.model.doctor.DoctorRequest;
import beams.model.doctor.DoctorResponse;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import beams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private  final UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest) {
        User userToSave = userMapper.map(userRequest);
        userRepository.save(userToSave);
        return userMapper.map(userToSave);
    }
}
