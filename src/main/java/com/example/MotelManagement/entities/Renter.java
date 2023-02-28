package com.example.MotelManagement.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Data
@Table(name = "renter")
@Entity
@NoArgsConstructor
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String renterName;
    private String job;
    private String identification;
    private String phoneNumber;
    private String residence;
    private int isHeader;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    public String getRoomName(){
        return this.room.getName();
    }


}
