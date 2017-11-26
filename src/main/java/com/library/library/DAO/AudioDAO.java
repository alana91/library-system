package com.library.library.DAO;

import com.library.library.model.Audio;

import java.util.List;

public interface AudioDAO {

    List<Audio> getAll();

    Audio getAudio(String id);

    Audio addAudio(Audio item);

    Audio updateAudio(Audio item, String id);
}
