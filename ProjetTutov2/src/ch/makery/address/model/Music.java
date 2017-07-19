package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

/**
 * Created by torgu on 14/06/2017.
 */
public class Music {

    private StringProperty name;
    private StringProperty description;
    private StringProperty duration;
    private StringProperty singer;
    private IntegerProperty views;
    private StringProperty type;
    private StringProperty url;
    private StringProperty sort;
    private StringProperty country;
    private StringProperty date;

    public Music(String name, String description, String duration, String singer, int views, String url, String sort, String country, String date) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.duration = new SimpleStringProperty(duration);
        this.singer = new SimpleStringProperty(singer);
        this.views = new SimpleIntegerProperty(views);
        this.url = new SimpleStringProperty(url);
        this.sort = new SimpleStringProperty(sort);
        this.country = new SimpleStringProperty(country);
        this.date = new SimpleStringProperty(date);
    }

    public Music() {
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.duration = new SimpleStringProperty();
        this.singer = new SimpleStringProperty();
        this.views = new SimpleIntegerProperty();
        this.type = new SimpleStringProperty();
        this.url = new SimpleStringProperty();
        this.sort = new SimpleStringProperty();
        this.country = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
    }


    public StringProperty getNameProperty() {
        return name;
    }

    public String getName() { return name.get();}

    public void setName(String name) {this.name.set(name);}

    public StringProperty getDescriptionProperty() {
        return description;
    }

    public String getDescription() { return description.get();}

    public void setDescription(String description) {this.description.set(description);}

    public StringProperty getDurationProperty() {
        return duration;
    }

    public String getDuration() { return duration.get();}

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public StringProperty getSingerProperty() {
        return singer;
    }

    public String getSinger() { return singer.get();}

    public void setSinger(String singer) {
        this.singer.set(singer);
    }

    public IntegerProperty getViewsProperty() {
        return views;
    }

    public int getViews() { return views.get();}

    public void setViews(int views) {
        this.views.set(views);
    }

    public StringProperty getTypeProperty() {
        return type;
    }

    public StringProperty getUrlProperty() { return url; }

    public String getUrl() { return url.get();}

    public void setUrl(String url) {
        this.url.set(url);
    }

    public StringProperty getSortProperty() {
        return sort;
    }

    public String getSort() { return sort.get(); }

    public void setSort(String sort) {this.sort.set(sort);}

    public StringProperty getCountryProperty() {
        return country;
    }

    public String getCountry() { return country.get(); }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public void setDate(Date date) { this.date.set(date.toString());}

    public StringProperty getDateProperty() { return date;}

    public String getDate() { return date.get();}
}
