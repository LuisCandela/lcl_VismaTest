package com.lcl.visma.work.model;

/**
 * class to adapt data from services to view
 */
public class InfoAdapter {

    private String id;
    private String name;

    public InfoAdapter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
