package ru.engineeroid.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation implements IdOwner {
    @Id
    @GeneratedValue()
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @CreationTimestamp
    private Timestamp creationDate;

    @ManyToMany
    private List<User> participants;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private Timestamp begin;
    private Timestamp end;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addParticipant(User u) {
        this.participants.add(u);
    }
}
