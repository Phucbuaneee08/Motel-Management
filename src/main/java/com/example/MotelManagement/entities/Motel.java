package com.example.MotelManagement.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "motel")
@Entity
public class Motel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int motelWater;
    private int motelElec;
    private int isExpired;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date startCountDate;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date endCountDate;

}
