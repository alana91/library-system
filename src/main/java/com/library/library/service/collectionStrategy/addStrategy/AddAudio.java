package com.library.library.service.collectionStrategy.addStrategy;

import com.library.library.DAO.AudioDAOImpl;
import com.library.library.DTO.AudioDTO;
import com.library.library.model.Audio;
import com.library.library.service.converter.AudioToDTO;
import com.library.library.service.converter.DTOToAudio;
import org.springframework.beans.factory.annotation.Autowired;

public class AddAudio implements AddStrategy {

    private DTOToAudio dtoToAudio = DTOToAudio.getInstance();
    private AudioToDTO audioToDTO = AudioToDTO.getInstance();
    private AudioDAOImpl audioDAO = AudioDAOImpl.getInstance();

    @Override
    public Object addItem(Object object) {
        Audio audio = dtoToAudio.convert((AudioDTO)object);
        return audioToDTO.convert(audioDAO.addAudio(audio));
    }
}
