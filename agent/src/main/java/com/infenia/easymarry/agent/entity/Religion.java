package com.infenia.easymarry.agent.entity;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table(name = "iuser.religion")
public record Religion(
        @Id
        @Column("user_id")
        Long userid,

        String religion,
        String caste,
        @Column("sub_caste")
        String subcaste,

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
        long version
) {}
