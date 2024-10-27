package org.example.springjdbc_demo.controllers;

import org.example.springjdbc_demo.dto.UserDto;
import org.example.springjdbc_demo.mappers.entity_mapper.impl.UserMapper;
import org.example.springjdbc_demo.models.ApiResponse;
import org.example.springjdbc_demo.models.UserModel;
import org.example.springjdbc_demo.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/user/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getUser(@RequestParam(required = false) Long id) {
        if (id != null) {
            UserDto user = userService.getById(id);
            return user != null
                    ? ResponseEntity.ok(user)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("User not found", null, HttpStatus.NOT_FOUND));
        } else {
            List<UserDto> users = userService.getAll();
            return users != null && !users.isEmpty()
                    ? ResponseEntity.ok(users)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No users fetched", null, HttpStatus.NOT_FOUND));
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        int result = userService.save(userModel);
        return result == 1
                ? ResponseEntity.ok(new ApiResponse<>("User created successfully", result, HttpStatus.OK))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>("Failed to create user", result, HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestBody UserModel userModel) {
        int result = userService.save(userModel);
        return result == 2
                ? ResponseEntity.ok(new ApiResponse<>("User updated successfully", result, HttpStatus.OK))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>("Failed to update user", result, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        int result = userService.delete(id);
        return result > 0
                ? ResponseEntity.ok(new ApiResponse<>("User deleted successfully", result, HttpStatus.OK))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>("Failed to delete user", result, HttpStatus.NOT_FOUND));
    }
}
