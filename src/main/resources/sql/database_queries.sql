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
   CREATE TABLE IF NOT EXISTS `jukebox`.`playlist` (
       `playlist_id` INT PRIMARY KEY AUTO_INCREMENT,
       `song_id` INT,
       `song_name` VARCHAR(50),
       `genre` VARCHAR(45),
       `artist` VARCHAR(45),
       `album` VARCHAR(45),
       `duration` VARCHAR(20)
   );