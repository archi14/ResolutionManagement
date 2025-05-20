package models;

import java.util.UUID;

public class Customer {
    private String email;
    private String id;

    public Customer(String email) {
        this.email = email;
        this.id = UUID.randomUUID().toString();
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
