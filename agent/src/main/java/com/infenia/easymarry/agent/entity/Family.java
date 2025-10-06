package com.infenia.easymarry.agent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.time.Instant;
import java.util.Map;

@Table(name = "iuser.family")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family {

    @Id
    @Column("user_id")
    private Long userid;


    @Column("family_details")
    private FamilyDetails familyDetails;

    @CreatedBy
    @Column("created_by")
    private String createdBy;
    @LastModifiedBy
    @Column("updated_by")
    private String updatedBy;
    @CreatedDate
    @Column("created_at")
    private Instant createdAt;
    @LastModifiedDate
    @Column("updated_at")
    private Instant updatedAt;

    @Version
    private long version;

    @Column("family_type")
    private String familyType;

    @Column("family_class")
    private String familyClass;
    @Column("family_values")
    private String familyValues;



}
