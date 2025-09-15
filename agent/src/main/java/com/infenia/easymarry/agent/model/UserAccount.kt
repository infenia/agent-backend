package com.infenia.easymarry.agent.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime

@Table("iuser.user_account")
data class UserAccount(

    @Id
    @Column("user_id")
    val userId: Long? = null,

    @Column("idp_user_id")
    val idpUserId: String,

    @Column("first_name")
    val firstName: String,

    @Column("middle_name")
    val middleName: String? = null,

    @Column("last_name")
    val lastName: String,

    @Column("mobile")
    val mobile: String,

    @Column("mobile_verified")
    val mobileVerified: Boolean = false,

    @Column("email")
    val email: String? = null,

    @Column("email_verified")
    val emailVerified: Boolean = false,

    @Column("whatsapp")
    val whatsapp: String? = null,

    @Column("whatsapp_verified")
    val whatsappVerified: Boolean = false,

    @Column("aadhar_verified")
    val aadharVerified: Boolean = false,

    @Column("agent_verified")
    val agentVerified: Boolean = false,

    @Column("is_active")
    val isActive: Boolean = true,

    @Column("is_subscription_active")
    val isSubscriptionActive: Boolean = false,

    @Column("created_by")
    val createdBy: String,

    @Column("created_at")
    val createdAt: OffsetDateTime? = null,

    @Column("updated_by")
    val updatedBy: String,

    @Column("updated_at")
    val updatedAt: OffsetDateTime? = null,

    @Column("version")
    val version: Long
)
