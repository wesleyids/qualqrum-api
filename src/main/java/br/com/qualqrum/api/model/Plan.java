package br.com.qualqrum.api.model;

import java.util.List;

public class Plan {
    
    private int id;
    private String name;
    private String description;
    private List<String> features;
    private int freeTime = 15;
    private double price;
}
