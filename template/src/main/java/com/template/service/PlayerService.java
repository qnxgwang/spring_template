package com.template.service;

import com.template.domain.Player;

import java.sql.Timestamp;
import java.util.List;

public interface PlayerService {

    void insertStartTime(Player p);

    List<Player> selectPlayersByTime(Timestamp t1, Timestamp t2);

}
