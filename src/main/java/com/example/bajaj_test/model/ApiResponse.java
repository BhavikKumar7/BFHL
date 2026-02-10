package com.example.bajaj_test.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "is_success", "official_email", "data" })
public class ApiResponse {

    private boolean is_success;
    private String official_email;
    private Object data;

    public ApiResponse(boolean success, String email, Object data) {
        this.is_success = success;
        this.official_email = email;
        this.data = data;
    }

    public boolean isIs_success() { return is_success; }
    public String getOfficial_email() { return official_email; }
    public Object getData() { return data; }
}
