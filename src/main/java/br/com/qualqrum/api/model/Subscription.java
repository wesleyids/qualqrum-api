package br.com.qualqrum.api.model;

import java.util.Date;

import br.com.qualqrum.api.enums.StatusSubscriptionEnum;

public class Subscription {
    private Long id;

    private User user;

    private Plan plan;

    private double price;

    private Date createdAt;

    private StatusSubscriptionEnum status;
}
