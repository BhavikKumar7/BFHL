package com.example.bajaj_test.controller;

import com.example.bajaj_test.model.*;
import com.example.bajaj_test.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class BfhlController {

    private final MathService mathService;
    private final AiService aiService;

    @Value("${official.email}")
    private String email;

    public BfhlController(MathService m, AiService a){
        this.mathService=m;
        this.aiService=a;
    }

    @GetMapping("/health")
    public HealthResponse health(){
        return new HealthResponse(true,email);
    }

    @PostMapping("/bfhl")
    public ApiResponse bfhl(@RequestBody BfhlRequest req) throws Exception {

        int keys = (req.fibonacci!=null?1:0)
                +(req.prime!=null?1:0)
                +(req.lcm!=null?1:0)
                +(req.hcf!=null?1:0)
                +(req.AI!=null?1:0);

        if(keys!=1)
            throw new IllegalArgumentException("Exactly one key required");

        Object result;

        if(req.fibonacci!=null)
            result = mathService.fibonacci(req.fibonacci);

        else if(req.prime!=null)
            result = mathService.primes(req.prime);

        else if(req.lcm!=null)
            result = mathService.lcm(req.lcm);

        else if(req.hcf!=null)
            result = mathService.hcf(req.hcf);

        else
            result = aiService.askAI(req.AI);

        return new ApiResponse(true,email,result);
    }
}
