package com.carloz.VidStreamer.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.carloz.VidStreamer.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VideoRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Video save(Video video) {
        dynamoDBMapper.save(video);
        return video;
    }

    public Video getVideoById(String videoId) {
        return dynamoDBMapper.load(Video.class, videoId);
    }

    public String delete(String videoId) {
        Video video = dynamoDBMapper.load(Video.class, videoId);
        dynamoDBMapper.delete(video);
        return "Video Deleted!";
    }

    public String update(String videoId, Video video) {
        dynamoDBMapper.save(video,
                new DynamoDBSaveExpression()
        .withExpectedEntry("videoId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(videoId)
                )));
        return videoId;
    }
}
