package com.ll.s3examtospring250419.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final S3Client s3Client;

    @GetMapping
    public String main() {
        return "hi";
    }

    @GetMapping("/buckets")
    public List<String> buckets() {
        return s3Client.listBuckets().buckets()
                .stream()
                .map(Bucket::name)
                .toList();
    }

}
