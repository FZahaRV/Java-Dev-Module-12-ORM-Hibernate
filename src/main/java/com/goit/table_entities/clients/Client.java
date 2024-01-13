package com.goit.table_entities.clients;

import com.goit.table_entities.tickets.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Ticket> ticket;

    @Override
    public String toString() {
        return "Client{id" + id + "},{name" + name + "}";
    }
}