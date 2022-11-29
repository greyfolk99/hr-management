package com.hrmanagement.controller.api;

import com.hrmanagement.domain.user.UserInfoForm;
import com.hrmanagement.repository.CustomRepository;
import com.hrmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final CustomRepository customRepository;

    @PostMapping("/")
    public ResponseEntity<?> postOne(@RequestBody UserInfoForm userInfoForm){
        return ResponseEntity.ok(userService.create(userInfoForm));
    }
    @GetMapping("/")
    public ResponseEntity<?> getOne(@RequestParam Integer userId){
        return ResponseEntity.ok(userService.select(userId));
    }
    @PatchMapping("/")
    public ResponseEntity<?> patchOne(@RequestParam Integer userId, @RequestBody UserInfoForm userInfoForm){
        return ResponseEntity.ok(userService.update(userId, userInfoForm));
    }
    @DeleteMapping("/")
    public ResponseEntity<?> deleteOne(@RequestParam Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getALl(@RequestParam String keyword){
        return ResponseEntity.ok(customRepository.searchAll(keyword));
    }
}


