package com.micro.two.Modify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardModifyImplementation implements CardModifyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    ReadClient readClient;

    @Override
    public CreditCard approve(CreditCard creditCard) {
        jdbcTemplate.update("insert into mybank_creditcard values(?,?,?,?,?,?,?,?,?)",
                new Object[]{
                        creditCard.getCardNumber(),
                        creditCard.getCardCvv(),
                        creditCard.getCardExpiry(),
                        creditCard.getCardPin(),
                        creditCard.getCardLimit(),
                        creditCard.getCardUsage(),
                        creditCard.getCardAvailable(),
                        creditCard.isCardStatus(),
                        creditCard.getCardHolder()
                });
        return creditCard;
    }

    @Override
    public String blockCard(long cardNumber, int pinNumber) {
        List<CreditCard> all = readClient.getCardsOfAll();
        all=all.stream().filter(card->
            card.getCardNumber() != cardNumber && card.getCardPin() != pinNumber).
                collect(Collectors.toList());
        System.out.println(all);
//        jdbcTemplate.update("delete from mybank_creditcard where creditcard_number=? and creditcard_pin=?",
//                new Object[]{
//                        cardNumber,pinNumber
//                });
        return cardNumber+" has blocked permanently";
    }

    @Override
    public CreditCard swipe(CreditCard creditCard, int purchase) {
        if(purchase+creditCard.getCardUsage()<= creditCard.getCardLimit()*0.800){
            jdbcTemplate.update("update mybank_creditcard set creditcard_available=?, creditcard_usage=? where creditcard_number=?",
                    new Object[]{
                            creditCard.getCardAvailable()-purchase,
                            creditCard.getCardUsage()+purchase,
                            creditCard.getCardNumber()
                    });
            return creditCard;
        }
        else{
            throw new IllegalArgumentException("No sufficient available balance");
        }
    }
}
