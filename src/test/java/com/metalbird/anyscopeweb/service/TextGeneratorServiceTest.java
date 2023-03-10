package com.metalbird.anyscopeweb.service;

import com.simiacryptus.text.gpt2.GPT2Util;
import com.simiacryptus.text.gpt2.TextGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TextGeneratorServiceTest {
    @Autowired
    private TextGeneratorService service;

    @Test
    void generateMessage() {
        String res = service.generateMessage("Hello I'm text generator. Who are you? ");
        System.out.println(res);
    }

    @Test
    public void generateUnconditionalText() {
        TextGenerator textGenerator = GPT2Util.get345M().setVerbose(false);
        for (double t = 1.0; t < 3; t *= 1.1) {
            textGenerator.getModel();
            System.out.println("Temperature=" + t);
            System.out.println(textGenerator.generateText(150));
        }
    }
}