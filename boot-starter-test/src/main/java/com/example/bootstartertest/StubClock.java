package com.example.bootstartertest;

import java.time.*;

public class StubClock extends Clock {

  private Clock clock;

  public StubClock() {
    clock = Clock.systemUTC();
  }

  public StubClock(Instant instant) {
    clock = Clock.fixed(instant, ZoneOffset.UTC);
  }

  public void reset() {
    clock = Clock.systemUTC();
  }

  public void moveForward(Duration duration) {
    set(Instant.now(clock).plus(duration));
  }

  public void set(Instant instant) {
    clock = Clock.fixed(instant, ZoneOffset.UTC);
  }

  @Override
  public ZoneId getZone() {
    return clock.getZone();
  }

  @Override
  public Clock withZone(ZoneId zone) {
    return clock.withZone(zone);
  }

  @Override
  public Instant instant() {
    return clock.instant();
  }
}
