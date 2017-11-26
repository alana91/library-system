package com.library.library.DAO;

import com.library.library.model.Video;
import java.util.List;

public interface VideoDAO {

    List<Video> getAll();

    Video getVideo(String id);

    Video addVideo(Video item);

    Video updateVideo(Video item, String id);
}
