package constants;

import lombok.Getter;

import java.time.Duration;

public enum WaitDuration {
    defaultWait(5),
    shortWait(2),
    noWait(0);

    @Getter
    private Duration duration;

    WaitDuration(long durationInSeconds) { this.duration = Duration.ofSeconds(durationInSeconds); }
}
