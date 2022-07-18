package com.example.hrproject.modals;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StatusDTO {
    Status status;

    public StatusDTO(Status status) {
        this.status = status;
    }
    public String getStatus() {
        String jsonString = "{\"title\": \"" + status.label+ "\",\"description\": \"" + status.description+ "\"}";
        return jsonString;
    }
}
