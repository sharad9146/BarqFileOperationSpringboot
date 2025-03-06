package com.example.BarqFileOperation.DTO;

import java.io.Serializable;

public class FileData implements Serializable {
    private String name;
    private String content;
    private boolean persist;

    // Default constructor
    public FileData() {}

    // Constructor
    public FileData(String name, String content, boolean persist) {
        this.name = name;
        this.content = content;
        this.persist = persist;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public boolean isPersist() { return persist; }
    public void setPersist(boolean persist) { this.persist = persist; }
}
