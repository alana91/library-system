package com.library.library.service.collectionStrategy.updateStrategy;

import com.library.library.DAO.VideoDAOImpl;
import com.library.library.DTO.VideoDTO;
import com.library.library.model.Video;
import com.library.library.service.converter.DTOToVideo;
import com.library.library.service.converter.VideoToDTO;

public class UpdateVideo implements UpdateStrategy {
    private VideoToDTO videoToDTO = VideoToDTO.getInstance();
    private VideoDAOImpl videoDAO = VideoDAOImpl.getInstance();
    private DTOToVideo dtoToVideo = DTOToVideo.getInstance();

    @Override
    public Object updateItem(Object object, String id){
        VideoDTO videoDTO = (VideoDTO) object;
        Video video = dtoToVideo.convert(videoDTO);

        return videoToDTO.convert(videoDAO.updateVideo(video, id));
    }
}
