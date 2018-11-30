package com.tecgurus.useraccounts.app.runner;

import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketCreatorRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        log.info("Buckets creation pending...");

    }

}
