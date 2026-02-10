package com.example.bajaj_test.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MathService {

    public List<Integer> fibonacci(int n) {
        if(n < 0 || n > 45) throw new IllegalArgumentException("Invalid fibonacci range");

        List<Integer> res = new ArrayList<>();
        int a = 0, b = 1;
        for(int i=0;i<n;i++){
            res.add(a);
            int c = a + b;
            a = b;
            b = c;
        }
        return res;
    }

    public List<Integer> primes(List<Integer> nums){
        List<Integer> res = new ArrayList<>();
        for(int n: nums) if(isPrime(n)) res.add(n);
        return res;
    }

    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++) if(n%i==0) return false;
        return true;
    }

    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

    public int hcf(List<Integer> nums){
        int g = nums.get(0);
        for(int i:nums) g=gcd(g,i);
        return g;
    }

    public int lcm(List<Integer> nums){
        int l = nums.get(0);
        for(int i:nums) l=l*i/gcd(l,i);
        return l;
    }
}
