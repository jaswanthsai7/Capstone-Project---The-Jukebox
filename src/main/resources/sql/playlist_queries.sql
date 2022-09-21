-- create a playlist
   CREATE TABLE `jukebox`.`playlist` (
       `playlist_id` INT PRIMARY KEY AUTO_INCREMENT,
       `playlist_name` VARCHAR(45),
       `song_id` VARCHAR(40)
   );

-- insert into playlist
