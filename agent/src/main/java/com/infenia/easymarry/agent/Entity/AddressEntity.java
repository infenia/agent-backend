package com.infenia.easymarry.agent.Entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("iuser.address")
public class AddressEntity {

    @Id
    @Column("user_id")
    private Long userId;

    @Column("address_details")
    private String addressDetails; // jsonb stored as string

    @Column("created_by")
    private String createdBy;

    @Column("created_at")
    private OffsetDateTime createdAt;

    @Column("updated_by")
    private String updatedBy;

    @Column("updated_at")
    private OffsetDateTime updatedAt;

    @Column("version")
    private Long version;
}
