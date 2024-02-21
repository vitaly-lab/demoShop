package com.example.demoshop.service;

import com.example.demoshop.domain.Bucket;
import com.example.demoshop.domain.User;
import com.example.demoshop.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);
    void addProducts(Bucket bucket, List<Long> productIds);
    BucketDTO getBucketByUser(String name);
}
