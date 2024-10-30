package org.example.springjdbc_demo.services.impl;

import org.example.springjdbc_demo.dto.ReplyDto;
import org.example.springjdbc_demo.mappers.entity_mapper.impl.ReplyMapper;
import org.example.springjdbc_demo.models.ReplyModel;
import org.example.springjdbc_demo.repos.impl.ReplyRepo;
import org.example.springjdbc_demo.services.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService implements IReplyService {
    private final ReplyRepo replyRepo;
    private final ReplyMapper replyMapper;

    @Autowired
    public ReplyService(ReplyRepo replyRepo, ReplyMapper replyMapper) {
        this.replyRepo = replyRepo;
        this.replyMapper = replyMapper;
    }

    @Override
    public List<ReplyDto> getAll() {
        return List.of();
    }

    @Override
    public ReplyDto getById(Long aLong) {
        return null;
    }

    @Override
    public int save(ReplyModel replyModel) {
        return replyRepo.save(replyMapper.toEntity(replyModel));
    }

    @Override
    public int delete(Long aLong) {
        return 0;
    }
}
