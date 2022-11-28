package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryEvent {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private LibraryEventType eventType;

    @ToString.Exclude
    @OneToOne(mappedBy = "libraryEvent", cascade = CascadeType.ALL)
    private Book book;
}
