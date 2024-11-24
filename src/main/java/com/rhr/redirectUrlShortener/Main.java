package com.rhr.redirectUrlShortener;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final S3Client s3Client = S3Client.builder().build();

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        Object rawPathObject = input.get("rawPath");

        if (!(rawPathObject instanceof String pathParameters)) {
            throw new IllegalArgumentException("Invalid input: 'rawPath' is required and must be a String.");
        }

        String shortUrlCode = pathParameters.replace("/", "");

        if (shortUrlCode.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: 'shortUrlCode' cannot be empty.");
        }

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket("url-shortener-storage-java-lambda-2024")
                .key(shortUrlCode + ".json")
                .build();

        UrlData urlData;

        try (InputStream s3ObjectStream = s3Client.getObject(getObjectRequest)) {
            urlData = objectMapper.readValue(s3ObjectStream, UrlData.class);
        } catch (Exception exception) {
            throw new RuntimeException("Error processing data from S3: " + exception.getMessage(), exception);
        }

        long currentTimeInSeconds = System.currentTimeMillis() / 1000;

        Map<String, Object> response = new HashMap<>();

        if (urlData.getExpirationTime() < currentTimeInSeconds) {
            response.put("statusCode", 410);
            response.put("body", "This URL has expired.");

            return response;
        }

        response.put("statusCode", 302);
        Map<String, String> headers = new HashMap<>();
        headers.put("Location", urlData.getOriginalUrl());
        response.put("headers", headers);

        return response;
    }
}
