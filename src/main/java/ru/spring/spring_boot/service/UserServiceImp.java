package ru.spring.spring_boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.spring_boot.models.User;
import ru.spring.spring_boot.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImp(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public List<User> findAll(){
      return userRepository.findAll();
   }

   public User findOne(long id){
      Optional<User> foundCar = userRepository.findById(id);
      return foundCar.orElse(null);
   }
   @Transactional
   public void save(User user){
      userRepository.save(user);
   }

   @Transactional
   public void update(long id, User updatedUser){
      userRepository.save(updatedUser);
   }

   @Transactional
   public void delete(long id){
      userRepository.deleteById(id);
   }

}
