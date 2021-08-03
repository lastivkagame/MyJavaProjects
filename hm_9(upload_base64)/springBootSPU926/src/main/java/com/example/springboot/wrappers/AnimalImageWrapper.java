package com.example.springboot.wrappers;

public class AnimalImageWrapper {
    private int animalId;
    private String contentType;
    private String base64;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "AnimalImageWrapper{" +
                "animalId=" + animalId +
                ", contentType='" + contentType + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}
