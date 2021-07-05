package ru.engineeroid.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation implements IdOwner {
    @Id
    @GeneratedValue()
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(name = "creation_date")
    @CreationTimestamp
    private Timestamp creationDate;

    @ManyToMany
    private List<User> participants;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "begin_date")
    private Timestamp beginDate;
    @Column(name = "end_date")
    private Timestamp endDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp begin) {
        this.beginDate = begin;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp end) {
        this.endDate = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation that = (Reservation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Reservation{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", creator=" + creator
                + ", creationDate=" + creationDate
                + ", room=" + room
                + ", begin=" + beginDate
                + ", end=" + endDate
                + '}';
    }
}
