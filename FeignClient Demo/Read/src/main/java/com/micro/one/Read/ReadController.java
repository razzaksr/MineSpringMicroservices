package com.micro.one.Read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reading")
public class ReadController {
    @Autowired
    CardReadRepository cardRepository;
    @GetMapping("/all")
    public List<CreditCard> viewAll(){
        return cardRepository.viewCustomers();
    }
}
