package com.ontotext.forum.entity;

import jakarta.persistence.Column;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public abstract class TimestampedEntity {
  @CreationTimestamp
  @Column(name = "create_date", updatable = false)
  private Date createDate;
  @UpdateTimestamp
  @Column(name = "modify_date")
  private Date modifyDate;
}
