package com.library.library.service.converter;

import com.library.library.DTO.VideoDTO;
import com.library.library.model.Video;

public final class VideoToDTO {
    private static VideoToDTO instance = null;

    private VideoToDTO(){}

    public static VideoToDTO getInstance() {
        if(instance == null) {
            instance = new VideoToDTO();
        }
        return instance;
    }

    public VideoDTO convert(Video video){
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setArea(video.getArea());
        videoDTO.setAuthor(video.getAuthor());
        videoDTO.setCountry(video.getCountry());
        videoDTO.setDate(video.getDate());
        videoDTO.setId(video.getId());
        videoDTO.setIsBorrowed(video.getBorrowed());
        videoDTO.setTitle(video.getTitle());
        return videoDTO;
    }
}
