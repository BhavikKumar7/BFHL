package com.example.bajaj_test.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "is_success", "official_email" })
public class HealthResponse {

    private boolean is_success;
    private String official_email;

    public HealthResponse(boolean success, String email){
        this.is_success = success;
        this.official_email = email;
    }

    public boolean isIs_success() { return is_success; }
    public String getOfficial_email() { return official_email; }
}


