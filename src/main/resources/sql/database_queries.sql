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
       `duration` VARCHAR(20)
   );

-- create a table playlist
 INSERT INTO `jukebox`.`playlist` (`playlist_Name`, `song_id`, `song_name`, `genre`, `artist`, `album`, `duration`) VALUES ('mylisti', '1', 'aktsuki', 'hip-hop', 'yakamuno', 'akatsuki', '02:02');