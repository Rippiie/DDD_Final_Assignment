package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

public class PictureData {
    private String pictureBase64;
    private String description;

    public PictureData(String pictureBase64, String description) {
        this.pictureBase64 = pictureBase64;
        this.description = description;
    }

    private void setPictureBase64(String pictureBase64) {
        this.pictureBase64 = pictureBase64;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public void replacePictureData(String pictureBase64, String description){
        this.setDescription(description);
        this.setPictureBase64(pictureBase64);
    }

    public String getPictureBase64() {
        return pictureBase64;
    }

    public String getDescription() {
        return description;
    }
}
