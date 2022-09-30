package com.likelionswu.backend_1hw.post.service;

import com.likelionswu.backend_1hw.post.domain.Info;
import com.likelionswu.backend_1hw.post.dto.InfoDto;
import com.likelionswu.backend_1hw.post.repository.InfoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Transactional
    public Long savePost(InfoDto infoDto) {
        return infoRepository.save(infoDto.toEntity()).getId();
    }

    @Transactional
    public List<InfoDto> getInfoList() {
        List<Info> infos = infoRepository.findAll();
        List<InfoDto> infoDtoList = new ArrayList<>();

        for (Info info : infos) {
            InfoDto infoDto = InfoDto.builder()
                    .id(info.getId())
                    .name(info.getName())
                    .age(info.getAge())
                    .major(info.getMajor())
                    .intro(info.getIntro())
                    .createdTime(info.getCreatedTime())
                    .build();

            infoDtoList.add(infoDto);
        }

        return infoDtoList;
    }

    @Transactional
    public InfoDto getPost(Long id) {
        Optional<Info> infoWrapper = infoRepository.findById(id);
        Info info = infoWrapper.get();

        InfoDto infoDto = InfoDto.builder()
                .id(info.getId())
                .name(info.getName())
                .age(info.getAge())
                .major(info.getMajor())
                .intro(info.getIntro())
                .createdTime(info.getCreatedTime())
                .modifiedTime(info.getModifiedTime())
                .build();

        return infoDto;
    }

    @Transactional
    public Long updatePost(Long id, InfoDto infoDto) {
        Info info = infoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 인적사항은 존재하지 않습니다" + id));
        info.update(infoDto);

        return id;
    }

    @Transactional
    public void deletePost(Long id) {
        infoRepository.deleteById(id);
    }

    @Transactional
    public List<InfoDto> searchPosts(String keyword) {
        List<Info> infos = infoRepository.findByNameContaining(keyword);
        List<InfoDto> infoDtoList  = new ArrayList<>();

        if (infos.isEmpty()) return infoDtoList ;

        for (Info info : infos) {
            infoDtoList .add(this.convertEntityToDto(info));
        }

        return infoDtoList;
    }

    private InfoDto convertEntityToDto(Info info) {
        return InfoDto.builder()
                .id(info.getId())
                .name(info.getName())
                .age(info.getAge())
                .major(info.getMajor())
                .intro(info.getIntro())
                .createdTime(info.getCreatedTime())
                .modifiedTime(info.getModifiedTime())
                .build();
    }
}
