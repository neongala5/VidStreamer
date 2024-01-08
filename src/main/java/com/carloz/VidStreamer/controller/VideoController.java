package com.carloz.VidStreamer.controller;

import com.carloz.VidStreamer.entity.Video;
import com.carloz.VidStreamer.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// im using port 8083 for some reason. putting a comment here just in case i forget.
// delete once this is a useless comment

@RestController
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping("/video")
    public Video saveVideo(@RequestBody Video video) {
        return videoRepository.save(video);
    }

    // im using port 8083 for some reason. putting a comment here just in case i forget.
    @GetMapping("/video/{id}")
    public Video getVideo(@PathVariable("id") String videoId) {
        return videoRepository.getVideoById(videoId);
    }

    @DeleteMapping("/video/{id}")
    public String deleteVideo(@PathVariable("id") String videoId) {
        return videoRepository.delete(videoId);
    }

    @PutMapping("/video/{id}")
    public String updateVideo(@PathVariable("id") String videoId, @RequestBody Video video) {
        return videoRepository.update(videoId, video);
    }
}
