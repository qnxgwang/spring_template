package com.template.mapper;

import com.template.domain.Player;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;


public interface PlayerMapper {

    @Insert(value = "insert into start(user_id, start_time, channel_id) " +
            "value(#{p.userId}, #{p.startTime}, #{p.channelId})")
    void insertStartTime(@Param("p") Player player);

    List<Player> selectPlayersByTime(@Param("start") Timestamp startTime, @Param("end") Timestamp endTime);

}
