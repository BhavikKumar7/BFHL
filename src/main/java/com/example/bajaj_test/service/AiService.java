package com.example.bajaj_test.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final Client client;

    public AiService(@Value("${gemini.api.key}") String apiKey) {
        this.client = new Client.Builder()
                .apiKey(apiKey)
                .build();
    }

    public String askAI(String question) {

        try {

            String prompt = """
            Reply using exactly ONE word only.
            No punctuation.
            No explanation.
            Question: %s
            """.formatted(question);

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-1.5-flash",
                            prompt,
                            null
                    );

            if(response == null || response.text() == null)
                return "unknown";

            String ans = response.text().trim();

            if(ans.isEmpty())
                return "unknown";

            return ans.split("\\s+")[0];

        } catch (Exception e) {
            return "unknown";
        }
    }
}