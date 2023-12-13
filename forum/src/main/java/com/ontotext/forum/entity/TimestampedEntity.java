package com.ontotext.forum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Defines an entity which has a creation and modification date.
 */
public abstract class TimestampedEntity {
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Date createDate;
    @UpdateTimestamp
    @Column(name = "modify_date")
    private Date modifyDate;
}
