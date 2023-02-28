package com.example.MotelManagement.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "contract")
@Entity
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date rentalDay;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date term;
    private Boolean status;
    private int deposit;
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


}
