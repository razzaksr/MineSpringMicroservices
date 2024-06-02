package com.micro.two.Modify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modify")
public class ModifyController {
    @Autowired
    CardModifyRepository cardRepository;
    @PostMapping("/new")
    public CreditCard create(@RequestBody CreditCard card){
        return cardRepository.approve(card);
    }
    @DeleteMapping("/block")
    public String block(@RequestParam("cardNumber") long cardNumber,@RequestParam("pinNumber") int pinNumber){
        return cardRepository.blockCard(cardNumber,pinNumber);
    }
}
