package com.ahut.cones.entity;

import lombok.Data;

@Data
public class Gps {

  private long targetId;
  private String ipv6Host;
  private double longitue;
  private double latitue;
  private java.sql.Date reportTime;

}
