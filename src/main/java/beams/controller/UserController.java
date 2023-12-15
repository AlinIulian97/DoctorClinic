package beams.controller;

import beams.model.consult.ConsultRequest;
import beams.model.consult.ConsultResponse;
import beams.model.consult.ConsultUpdateDate;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import beams.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;


    @PostMapping("/create")
    public UserResponse createConsult(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

}
