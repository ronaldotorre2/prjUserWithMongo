package br.com.ronaldo.api;

import br.com.ronaldo.api.request.UserRequestDTO;
import br.com.ronaldo.api.response.UserResponseDTO;
import br.com.ronaldo.business.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired private final UserService userService;
    
    @PostMapping()
    public ResponseEntity<UserResponseDTO> CreateUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.saveUsers(userRequestDTO));
    }

    @GetMapping()
    public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam ("email") String email) {
        return ResponseEntity.ok(userService.searchUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam ("email") String email) {
        userService.deleteUser(email);
        return ResponseEntity.accepted().build();
    }
}