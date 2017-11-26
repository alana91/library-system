package com.library.library.service.collectionStrategy.updateStrategy;

import com.library.library.DAO.AudioDAOImpl;
import com.library.library.DTO.AudioDTO;
import com.library.library.model.Audio;
import com.library.library.service.converter.AudioToDTO;
import com.library.library.service.converter.DTOToAudio;

public class UpdateAudio implements UpdateStrategy{
    private AudioToDTO audioToDTO = AudioToDTO.getInstance();
    private AudioDAOImpl audioDAO = AudioDAOImpl.getInstance();
    private DTOToAudio dtoToAudio = DTOToAudio.getInstance();

    @Override
    public Object updateItem(Object object, String id){
        AudioDTO audioDTO = (AudioDTO) object;
        Audio audio = dtoToAudio.convert(audioDTO);

        return audioToDTO.convert(audioDAO.updateAudio(audio, id));
    }
}
