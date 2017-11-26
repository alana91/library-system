package com.library.library.service;

import com.library.library.DAO.*;
import com.library.library.DTO.*;
import com.library.library.service.collectionStrategy.addStrategy.*;
import com.library.library.service.collectionStrategy.updateStrategy.*;
import com.library.library.service.converter.AudioToDTO;
import com.library.library.service.converter.BookToDTO;
import com.library.library.service.converter.PeriodicalToDTO;
import com.library.library.service.converter.VideoToDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service("CollectionService")
public final class CollectionService{

    private static CollectionService instance = null;
    private AudioDAOImpl audioDAO = AudioDAOImpl.getInstance();
    private BookDAOImpl bookDAO = BookDAOImpl.getInstance();
    private PeriodicalDAOImpl periodicalDAO = PeriodicalDAOImpl.getInstance();
    private VideoDAOImpl videoDAO = VideoDAOImpl.getInstance();

    public static CollectionService getInstance() {
        if(instance == null) {
            instance = new CollectionService();
        }
        return instance;
    }

    public List<ItemDTO> getAll(){
        List<ItemDTO> items = new LinkedList<>();
        List<AudioDTO> audios = audioDAO.getAll()
                .stream().map(audio -> AudioToDTO.getInstance()
                        .convert(audio))
                .collect(Collectors.toList());

        List<BookDTO> books = bookDAO.getAll()
                .stream().map(book -> BookToDTO.getInstance()
                        .convert(book))
                .collect(Collectors.toList());

        List<PeriodicalDTO> periodicals = periodicalDAO.getAll()
                .stream().map(periodical -> PeriodicalToDTO.getInstance()
                        .convert(periodical))
                .collect(Collectors.toList());

        List<VideoDTO> videos = videoDAO.getAll()
                .stream().map(video -> VideoToDTO.getInstance().convert(video))
                .collect(Collectors.toList());

        items.addAll(audios);
        items.addAll(books);
        items.addAll(periodicals);
        items.addAll(videos);

        return items;
    }

    public ItemDTO getItem(String id){
        return (ItemDTO) getAll().stream()
                .filter( item -> item.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    public ItemDTO addItem(ItemDTO itemDTO){
        AddContext addContext;
        if(itemDTO instanceof BookDTO){
            addContext = new AddContext(new AddBook());
            return (ItemDTO) addContext.executeStrategy(itemDTO);
        } else if (itemDTO instanceof AudioDTO){
            addContext = new AddContext(new AddAudio());
            return (ItemDTO) addContext.executeStrategy(itemDTO);
        } else if (itemDTO instanceof PeriodicalDTO){
            addContext = new AddContext(new AddPeriodical());
            return (ItemDTO) addContext.executeStrategy(itemDTO);
        } else if (itemDTO instanceof VideoDTO){
            addContext = new AddContext(new AddVideo());
            return (ItemDTO) addContext.executeStrategy(itemDTO);
        }
        return null;
    }

    public ItemDTO updateItem(ItemDTO itemDTO, String id){
        UpdateContext updateContext;
        if(itemDTO instanceof BookDTO){
            updateContext = new UpdateContext(new UpdateBook());
            return (ItemDTO) updateContext.executeStrategy(itemDTO, id);
        } else if (itemDTO instanceof AudioDTO){
            updateContext = new UpdateContext(new UpdateAudio());
            return (ItemDTO) updateContext.executeStrategy(itemDTO, id);
        } else if (itemDTO instanceof PeriodicalDTO){
            updateContext = new UpdateContext(new UpdatePeriodical());
            return (ItemDTO) updateContext.executeStrategy(itemDTO, id);
        } else if (itemDTO instanceof VideoDTO){
            updateContext = new UpdateContext(new UpdateVideo());
            return (ItemDTO) updateContext.executeStrategy(itemDTO, id);
        }
        return null;
    }
}