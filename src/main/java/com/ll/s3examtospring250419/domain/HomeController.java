package com.ll.s3examtospring250419.domain;

import com.ll.s3examtospring250419.domain.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final S3Service s3Service;

    @Value("${custom.secretWord}")
    private String secretWord;

    @GetMapping
    public String main() {
        return "hi, " + secretWord;
    }

    @GetMapping("/buckets")
    public List<String> buckets() {
        return s3Service.getBucketNames();
    }

}
