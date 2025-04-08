package org.example;

class Motivation {
    private int id;
    private String motivation;
    private String source;

    public Motivation(int id, String motivation, String source) {
        this.id = id;
        this.motivation = motivation;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}




