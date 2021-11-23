package com.codecool.backend.buckets;

public enum BucketName {
    PRODUCT_IMAGE("petprojectstorage");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
