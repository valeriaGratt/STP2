package org.donstu.domain;

import java.util.Date;
import java.util.List;

public class Competition {
    private String name;
    private String place;
    private Date date;
    private List<Human> competitors;

    public Competition(String name, String place, Date date, List<Human> competitors) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.competitors = competitors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Human> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Human> competitors) {
        this.competitors = competitors;
    }
}
