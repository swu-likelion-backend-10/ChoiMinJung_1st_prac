package com.likelionswu.backend_1hw.post.service;

import com.likelionswu.backend_1hw.post.dto.InfoDto;
import com.likelionswu.backend_1hw.post.repository.InfoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository){
        this.infoRepository = infoRepository;
    }

    @Transactional
    public Long savePost(InfoDto infoDto){
        return infoRepository.save(infoDto.toEntity()).getId();
    }
}
