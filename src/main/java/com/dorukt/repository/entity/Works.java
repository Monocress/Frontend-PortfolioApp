package com.dorukt.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "works_tbl")
public class Works {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String excerpt;
    String description;
    String coverImage;
    @Builder.Default
    Boolean isFeatured = false;

    @ElementCollection
    List<String> tags;
}
