package com.example.hrproject.modals;

public enum Status {
    Saved("Saved","Entity has been saved"),
    Modified("Modified","Entity has been modified"),
    Deleted("Deleted","Entity has been deleted");
    final String label;
    final String description;

    Status(String label, String description) {
        this.label = label;
        this.description = description;
    }
}
