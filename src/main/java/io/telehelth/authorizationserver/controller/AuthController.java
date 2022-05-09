package io.telehelth.authorizationserver.controller;

import io.telehelth.authorizationserver.entity.DocRoles;
import io.telehelth.authorizationserver.entity.Roles;
import io.telehelth.authorizationserver.entity.User;
import io.telehelth.authorizationserver.model.Dummy;
import io.telehelth.authorizationserver.model.UserModel;
import io.telehelth.authorizationserver.service.AuthService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("api/oauth/signup")
    public ResponseEntity<Void> createUser(@Valid @ModelAttribute UserModel userModel) throws IOException {
        authService.createUser(userModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/test",consumes = "multipart/form-data",method = RequestMethod.POST)
    public ResponseEntity<String> test(@Valid @ModelAttribute Dummy date){
        System.out.println(date.getDate().toString());
        return ResponseEntity.ok("Worked");
    }

}
