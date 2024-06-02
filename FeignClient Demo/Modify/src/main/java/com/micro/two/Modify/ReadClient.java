package com.micro.two.Modify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8084",value = "Read-Client")
public interface ReadClient {
    @GetMapping("/reading/all")
    List<CreditCard> getCardsOfAll();
}
