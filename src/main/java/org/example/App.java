package org.example;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class App {
    public static void main(String... args) {
        GitHub github = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        github.contributors("OpenFeign", "feign")
                .parallelStream()
                .forEach(contributor -> System.out.println(contributor.login + "::" + contributor.contributions));
    }
}