package it.dsibilio.rsocketdemo.features.domain;


import lombok.*;

import org.geojson.Feature;
import org.springframework.data.annotation.Id;
import java.time.OffsetDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TravelTime extends Feature {

    @Id
    private Integer pkey;

    public Integer getPkey() {
        return pkey;
    }
    public void setPkey(Integer pkey) {
        this.pkey = pkey;
    }

    public String getId() {
        return getProperty("Id");
    }

    public void setId(String id) {
        setProperty("Id", id);
    }

    public String getName() {
        return getProperty("name");
    }
    public void setName(String name) {
        setProperty("name", name);
    }

    public OffsetDateTime getPubDate() {
        return OffsetDateTime.parse(getProperty("pubDate"));
    }
    public void setPubDate(OffsetDateTime pubDate) {
        setProperty("pubDate", pubDate.toString());
    }
    public OffsetDateTime getRetrievedFromThirdParty() {
        return OffsetDateTime.parse(getProperty("getRetrievedFromThirdParty"));
    }
    public void setRetrievedFromThirdParty(OffsetDateTime retrievedFromThirdParty) {
        setProperty("retrievedFromThirdParty", retrievedFromThirdParty.toString());
    }
    public String getType() {
        return getProperty("name");
    }
    public void setType(String type) {
        setProperty("type", type);
    }
    public int getLength() {
        return getProperty("name");
    }
    public void setLength(int length) {
        setProperty("length", length);
    }
    public int getTravelTime() {
        return getProperty("travelTime");
    }
    public void setTravelTime(int travelTime) {
        setProperty("travelTime", travelTime);
    }
    public int getVelocity() {
        return getProperty("velocity");
    }
    public void setVelocity(int velocity) {
        setProperty("velocity", velocity);
    }
}
