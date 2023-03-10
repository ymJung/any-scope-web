package com.metalbird.anyscopeweb;

import com.simiacryptus.text.gpt2.GPT2Model;
import com.simiacryptus.text.gpt2.GPT2Util;
import com.simiacryptus.text.gpt2.TextGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class AnyScopeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnyScopeWebApplication.class, args);
	}

	@Bean
	public TextGenerator textGenerator() {
		TextGenerator textGenerator = GPT2Util.get345M();
		textGenerator.getModel();// model
//		model.read(new File("gpt-2-117M.hdf5"));

		return textGenerator;
	}
}
