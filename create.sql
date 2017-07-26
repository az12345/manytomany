create table userevent (
  id serial primary key,
  name text,
  event text
);

create table usertime (
  id serial primary key,
  date date,
  time time
);

create table events_happens (
  id serial primary key,
  event_id int not null references userevent(id),
  time_id int not null references usertime(id)
);
CREATE TABLE `manytomanyone`.`time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `manytomanyone`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  #   PRIMARY KEY (`time_id`,`event_id`),
  #   KEY `fk_time_event_eventid_idx` (`event_id`),
  CONSTRAINT `fk_time_event_timeid` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`),
  CONSTRAINT `fk_time_event_eventid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
