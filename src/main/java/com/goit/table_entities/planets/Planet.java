package com.goit.table_entities.planets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planet")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
}
