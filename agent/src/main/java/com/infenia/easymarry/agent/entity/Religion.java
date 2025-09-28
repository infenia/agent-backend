package com.infenia.easymarry.agent.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;


@Table(name = "iuser.religion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Religion {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("user_id")
    private Long userid;

    private String religion;
    private String caste;
    @Column("sub_caste")
    private String subcaste;


    @CreatedBy
    @Column("created_by")
    private String CreatedBy;
    @LastModifiedBy
    @Column("updated_by")
    private String UpdatedBy;
    @CreatedDate
    @Column("created_at")
    private Instant CreatedAt;
    @LastModifiedDate
    @Column("updated_at")
    private Instant UpdatedAt;

    @Version
    private long version;
}