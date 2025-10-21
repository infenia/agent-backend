package com.infenia.easymarry.agent.entity;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table(name = "iuser.family")
public record Family(

        @Id
        @Column("user_id")
        Long userid,

        @Column("family_details")
        FamilyDetails familyDetails,

        @CreatedBy
        @Column("created_by")
        String createdBy,

        @LastModifiedBy
        @Column("updated_by")
        String updatedBy,

        @CreatedDate
        @Column("created_at")
        Instant createdAt,

        @LastModifiedDate
        @Column("updated_at")
        Instant updatedAt,

        @Version
        long version,

        @Column("family_type")
        String familyType,

        @Column("family_class")
        String familyClass,

        @Column("family_values")
        String familyValues
) {}
