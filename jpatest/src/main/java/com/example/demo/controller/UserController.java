package com.example.demo.controller;


import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.Vo;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping(value = "/api/v1/app/")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(userService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody User user) {

        userService.insert(user);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody User user) {

        userService.update(user);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}