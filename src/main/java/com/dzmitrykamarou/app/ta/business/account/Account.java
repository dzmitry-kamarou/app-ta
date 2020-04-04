package com.dzmitrykamarou.app.ta.business.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Calendar;

public class Account {

  private Long id;
  private String firstName;
  private String lastName;
  @JsonIgnore
  private Calendar createdAt;
  @JsonIgnore
  private Calendar updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Calendar getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Calendar createdAt) {
    this.createdAt = createdAt;
  }

  public Calendar getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Calendar updatedAt) {
    this.updatedAt = updatedAt;
  }
}
