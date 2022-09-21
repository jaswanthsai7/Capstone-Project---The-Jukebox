-- create a playlist
    CREATE TABLE IF NOT EXISTS `jukebox`.`playlist` (
          `playlist_Name` VARCHAR(40),
          `song_id` INT PRIMARY KEY,
          `song_name` VARCHAR(50),
          `genre` VARCHAR(45),
          `artist` VARCHAR(45),
          `album` VARCHAR(45),
          `duration` VARCHAR(20)
      );

-- insert into playlist
   INSERT INTO `jukebox`.`playlist` (`playlist_Name`, `song_id`, `song_name`, `genre`, `artist`, `album`, `duration`)
   VALUES ('mylisti', '1', 'aktsuki', 'hip-hop', 'yakamuno', 'akatsuki', '02:02');