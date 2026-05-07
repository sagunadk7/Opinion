package org.sagun.opinion.controller.thoughtcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/thought")
public class CreateThought {

    @PostMapping
    public void createThoughts(){

    }
}
