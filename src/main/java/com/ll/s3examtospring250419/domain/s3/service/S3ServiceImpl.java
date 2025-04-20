package com.ll.s3examtospring250419.domain.s3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;

import java.util.List;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final S3Client s3Client;

    @Override
    public List<String> getBucketNames() {
        return s3Client.listBuckets().buckets()
                .stream()
                .map(Bucket::name)
                .toList();
    }
}
