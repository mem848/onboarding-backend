package com.example.onboarding;

import com.example.onboarding.model.LaborPrice;
import com.example.onboarding.model.LaborParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class OnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnboardingApplication.class, args);

	}
	@PostMapping(value = "/Onboarding")
	//creates postMapping operation, expecting a plain text
	public LaborPrice Onboarding(@RequestBody LaborParams params)
	{
		System.out.println("hi fred");
		System.out.println(params.getLength());
		LaborPrice myCalc = new LaborPrice(5, 123);
		return myCalc;

	}
}
