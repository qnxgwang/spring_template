package com.template.controller;

import com.template.domain.Player;
import com.template.dto.PlayerDTO;
import com.template.dto.TimeDTO;
import com.template.service.PlayerServiceImpl;
import com.template.utils.LogUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.*;


@RestController
@Validated
public class PlayerController {

    @Resource
    PlayerServiceImpl service;

    @Resource
    LogUtils logUtils;

    @PostMapping("/player/start")
    public Object insertStartTime(@RequestBody @Valid PlayerDTO startPlayerDTO) {

        logUtils.info("insertStartTime");

        Player p = new Player();
        service.insertStartTime(p);
        return null;
    }

    @GetMapping("/player/queryByTime")
    public List<Player> queryByTime(@RequestBody TimeDTO timeDTO) {

        logUtils.info("queryByTime");

        Timestamp t1 = new Timestamp(timeDTO.getTime1());
        Timestamp t2 = new Timestamp(timeDTO.getTime1());
        return service.selectPlayersByTime(t1, t2);
    }

}
