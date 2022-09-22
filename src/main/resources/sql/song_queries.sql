-- create a database jukebox
   CREATE DATABASE IF NOT EXISTS `jukebox`;

-- use the jukebox database
   USE `jukebox`;

-- create a table song in database
   CREATE TABLE IF NOT EXISTS `jukebox`.`song` (
       `song_id` INT PRIMARY KEY,
       `song_name` VARCHAR(50),
       `genre` VARCHAR(45),
       `artist` VARCHAR(45),
       `album` VARCHAR(45),
       `duration` VARCHAR(20),
       `song_path` VARCHAR(50)
   );

-- create a table playlist
 INSERT INTO `jukebox`.`song` ( `song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('1', 'akatsuki', 'bass', 'yasuharu', 'shinjuuka', '02:02', 'src/main/resources/songs/akatsuki.wav');
 INSERT INTO `jukebox`.`song` ( `song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('2', 'faded', 'dance', 'alan walker', 'different world', '03:31', 'src/main/resources/songs/faded.wav');
 INSERT INTO `jukebox`.`song` ( `song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('3', 'alone', 'dance', 'alan walker', 'different world', '02:40', 'src/main/resources/songs/faded.wav');
 INSERT INTO `jukebox`.`song` ( `song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('4', 'happier', 'pop', 'marshmellow', 'fortnite set', '03:38', 'src/main/resources/songs/happier.wav');