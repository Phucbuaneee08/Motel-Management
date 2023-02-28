package com.example.MotelManagement.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private String name;
    private String description;
    private int waterIndex;
    private int elecIndex;
    private int newWaterIndex;
    private int newElecIndex;
    private int waterUnit;
    private int elecUnit;
    private String linkImage;
    private int square;
    private int isRented;
    private int isPaid;
    private int isExpired;
    private int totalPayment;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Renter> renter;
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Payment> payment;

}
