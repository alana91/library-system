package com.library.library.service.converter;

import com.library.library.DTO.VideoDTO;
import com.library.library.model.Video;

import java.util.LinkedList;

public final class DTOToVideo {
    private static DTOToVideo instance = null;

    private DTOToVideo(){}

    public static DTOToVideo getInstance() {
        if(instance == null) {
            instance = new DTOToVideo();
        }
        return instance;
    }

    public Video convert(VideoDTO videoDTO){
        Video video = new Video();
        video.setArea(videoDTO.getArea());
        video.setAuthor(videoDTO.getAuthor());
        video.setCountry(videoDTO.getCountry());
        video.setDate(videoDTO.getDate());
        video.setId(videoDTO.getId());
        video.setBorrowed(videoDTO.getIsBorrowed());
        video.setTitle(videoDTO.getTitle());
        video.setLoansIds(new LinkedList<>());
        return video;
    }
}
