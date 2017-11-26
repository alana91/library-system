package com.library.library.DAO;

import com.library.library.model.Audio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class AudioDAOImpl implements AudioDAO{
    
    private Helper helper = Helper.getInstance();
    private List<Audio> audios = helper.createAudioList();

    private static AudioDAOImpl instance = null;

    public static AudioDAOImpl getInstance() {
        if(instance == null) {
            instance = new AudioDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Audio> getAll(){
        return audios;
    }

    @Override
    public Audio getAudio(String id){
        Audio selectedAudio = null;
        for(Audio audio : audios){
            if(audio.getId().equals(id)){
                selectedAudio = audio;
                break;
            }
        }
        return selectedAudio;
    }

    @Override
    public Audio addAudio(Audio audio){
        audios.add(audio);
        return audio;
    }

    @Override
    public Audio updateAudio(Audio audio, String id){
        Audio selectedAudio = getAudio(id);
        selectedAudio.setArea(audio.getArea());
        selectedAudio.setAuthor(audio.getAuthor());
        selectedAudio.setCountry(audio.getCountry());
        selectedAudio.setDate(audio.getDate());
        selectedAudio.setRecordCompany(audio.getRecordCompany());
        selectedAudio.setTitle(audio.getTitle());
        selectedAudio.setBorrowed(audio.getBorrowed());
        return selectedAudio;
    }
}
