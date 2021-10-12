package com.asd.opdracht3.WeatherEvent.Domain.model.weatherEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherEvent {
    private String name;
    private Date updatedAt;
    private WeatherEventId weatherEventId;
    private UserId userId;
    private PictureData pictureData;
    private CreateDate createDate;
    private LocationData locationData;
    private List<EventAttribute> eventAttributes;

    public WeatherEvent(String name, WeatherEventId weatherEventId, UserId userId, PictureData pictureData, LocationData locationData, List<EventAttribute> eventAttributes) {
        this.name = name;
        this.weatherEventId = weatherEventId;
        this.userId = userId;
        this.pictureData = pictureData;
        this.createDate = new CreateDate();
        this.locationData = locationData;
        this.eventAttributes = eventAttributes;
        this.locationData.isLocationValid();
    }

    public WeatherEventId getWeatherEventId() {
        return weatherEventId;
    }

    public void updatePictureData(String pictureBase64, String description){
        this.pictureData.replacePictureData(pictureBase64, description);
        this.updateUpdatedAt();
    }

    private void updateUpdatedAt() {
        this.updatedAt = new Date();
    }

    public void addEventAttribute(EventAttribute eventAttribute){
        this.eventAttributes.add(eventAttribute);
    }

    public PictureData getPictureData() {
        return pictureData;
    }

    public List<EventAttribute> getEventAttributes() {
        return eventAttributes;
    }
}
