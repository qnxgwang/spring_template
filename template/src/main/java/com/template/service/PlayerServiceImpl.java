package com.template.service;

import com.template.domain.Player;
import com.template.mapper.PlayerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("playerServiceImpl")
public class PlayerServiceImpl implements PlayerService {

    @Resource
    private PlayerMapper playerMapper;

    @Override
    public void insertStartTime(Player player) {
        playerMapper.insertStartTime(player);
    }


    @Override
    public List<Player> selectPlayersByTime(Timestamp t1, Timestamp t2) {
        return playerMapper.selectPlayersByTime(t1, t2);
    }

}
