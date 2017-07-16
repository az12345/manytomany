CREATE TABLE `manytomanyone`.`happans` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `manytomanyone`.`events` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `happans_evants` (
  `happans_id` int(11) NOT NULL,
  `events_id` int(11) NOT NULL,
  PRIMARY KEY (`happans_id`,`events_id`),
  KEY `fk_time_event_eventid_idx` (`events_id`),
  CONSTRAINT `fk_happans_events_happansid` FOREIGN KEY (`happans_id`) REFERENCES `happans` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_happans_events_eventsid` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
