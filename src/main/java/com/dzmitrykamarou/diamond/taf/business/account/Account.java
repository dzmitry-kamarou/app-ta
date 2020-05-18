package com.dzmitrykamarou.diamond.taf.business.account;

import com.dzmitrykamarou.diamond.taf.util.TimeUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Calendar;

public class Account {

  private Long id;
  private String userName;
  private String firstName;
  private String lastName;
  @JsonDeserialize(using = TimeUtil.class)
  private Calendar createdAt;
  @JsonDeserialize(using = TimeUtil.class)
  private Calendar updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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
