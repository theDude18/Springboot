package com.boot.productrestapi.healthchecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator {

	public Health health(){
		boolean error=false;
		
		if(error) {
			return Health.down().withDetail("Error Key", 123).build();
		}
		
		return Health.up().build();
	}
}
