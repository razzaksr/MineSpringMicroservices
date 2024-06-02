package com.micro.one.Read;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardReadRepository {
    List<CreditCard> viewCustomers();
}
