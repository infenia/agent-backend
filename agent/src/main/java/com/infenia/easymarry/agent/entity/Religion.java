package com.infenia.easymarry.agent.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;


@Table(name = "religions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Religion {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("userid")
    private Long userid;

    private String religion;
    private String caste;
    private String subcaste;

    private String CreatedBy;
    private String UpdatedBy;
    private Instant CreatedAt;
    private Instant UpdatedAt;

    private long version;
}