CREATE TABLE `complete` (
    `user_id` char(15) NOT NULL,
    `channel_id` char(20) NOT NULL,
    `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `end_time` timestamp NOT NULL,
    PRIMARY KEY (`user_id`,`channel_id`,`start_time`,`end_time`),
    KEY `start_time` (`start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `start` (
     `user_id` char(15) NOT NULL,
     `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
     `channel_id` char(20) NOT NULL,
     PRIMARY KEY (`user_id`,`start_time`,`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

