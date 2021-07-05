package ru.engineeroid.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room implements IdOwner {
    @Id
    @GeneratedValue()
    private int id;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
