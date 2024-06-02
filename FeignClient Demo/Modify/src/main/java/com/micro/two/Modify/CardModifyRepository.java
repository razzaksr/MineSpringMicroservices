package com.micro.two.Modify;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardModifyRepository {
    CreditCard approve(CreditCard creditCard);
    String blockCard(long cardNumber, int pinNumber);
    CreditCard swipe(CreditCard creditCard,int purchase);
}
