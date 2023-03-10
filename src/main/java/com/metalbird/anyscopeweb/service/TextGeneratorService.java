package com.metalbird.anyscopeweb.service;

import com.simiacryptus.text.gpt2.TextGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TextGeneratorService {
    private final TextGenerator textGenerator;

    public String generateMessage(String msg) {
        return textGenerator.generateText(msg.length(), msg);
    }
}
