package com.hrmanagement.service;

import com.hrmanagement.domain.user.User;
import com.hrmanagement.domain.user.UserInfoForm;
import com.hrmanagement.exception.DataNotFoundException;
import com.hrmanagement.exception.ExceptionClass;
import com.hrmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private User findById(Integer id, HttpStatus httpStatus, String message){
        User user = userRepository.findById(id).orElseThrow(()-> new DataNotFoundException(
                ExceptionClass.USER, httpStatus, message
        ));
        if (user.getDeletedDate()!=null) throw new DataNotFoundException(
                ExceptionClass.USER, HttpStatus.NOT_FOUND, "deleted"
        );
        return user;
    }
    public User create(UserInfoForm form){
        return userRepository.save(User.of(form));
    }

    public User select(Integer id){
        return findById(id, HttpStatus.NOT_FOUND, "user not found");
    }

    public User update(Integer id, UserInfoForm form){
        User user = findById(id, HttpStatus.BAD_REQUEST, "wrong user id");
        user.update(form);
        return user;
    }
    public User delete(Integer id){
        User user = findById(id, HttpStatus.BAD_REQUEST, "wrong user id");
        user.delete();
        return user;
    }

    public boolean deepDelete(Integer id){
        userRepository.deleteById(id);
        return userRepository.findById(id).isEmpty();
    }
}
