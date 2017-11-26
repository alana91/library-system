package com.library.library.DAO;

import com.library.library.model.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final  class VideoDAOImpl implements VideoDAO {

    private Helper helper = Helper.getInstance();
    private List<Video> videos = helper.createVideoList();

    private static VideoDAOImpl instance = null;

    public static VideoDAOImpl getInstance() {
        if(instance == null) {
            instance = new VideoDAOImpl();
        }
        return instance;
    }
    
    @Override
    public List<Video> getAll(){
        return videos;
    }

    @Override
    public Video getVideo(String id){
        Video selectedVideo = null;
        for(Video video : videos){
            if(video.getId().equals(id)){
                selectedVideo = video;
                break;
            }
        }
        return selectedVideo;
    }

    @Override
    public Video addVideo(Video video){
        videos.add(video);
        return video;
    }

    @Override
    public Video updateVideo(Video video, String id){
        Video selectedVideo = getVideo(id);
        selectedVideo.setArea(video.getArea());
        selectedVideo.setAuthor(video.getAuthor());
        selectedVideo.setCountry(video.getCountry());
        selectedVideo.setDate(video.getDate());
        selectedVideo.setTitle(video.getTitle());
        selectedVideo.setBorrowed(video.getBorrowed());
        return selectedVideo;
    }
}
