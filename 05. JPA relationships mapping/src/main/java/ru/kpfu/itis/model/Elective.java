package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Elective {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @CollectionTable(name = "elective_dates")
    @ElementCollection
    @JoinColumn(name = "date")
    private List<Date> dates;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
