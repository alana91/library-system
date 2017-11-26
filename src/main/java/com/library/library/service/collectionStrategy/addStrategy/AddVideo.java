package com.library.library.service.collectionStrategy.addStrategy;

import com.library.library.DAO.VideoDAOImpl;
import com.library.library.DTO.VideoDTO;
import com.library.library.model.Video;
import com.library.library.service.converter.DTOToVideo;
import com.library.library.service.converter.VideoToDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AddVideo implements AddStrategy {

    private DTOToVideo dtoToVideo = DTOToVideo.getInstance();
    private VideoToDTO videoToDTO = VideoToDTO.getInstance();
    private VideoDAOImpl videoDAO = VideoDAOImpl.getInstance();

    @Override
    public Object addItem(Object object) {
        Video video = dtoToVideo.convert((VideoDTO)object);
        return videoToDTO.convert(videoDAO.addVideo(video));
    }
}
