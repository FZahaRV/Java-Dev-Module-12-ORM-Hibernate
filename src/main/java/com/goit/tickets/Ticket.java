package com.goit.tickets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "from_planet_id")
    private String fromPlanetId;
    @Column(name = "to_planet_id")
    private String toPlanetId;
}
