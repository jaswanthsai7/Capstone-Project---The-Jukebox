-- create a playlist
   CREATE TABLE `jukebox`.`playlist` (
       `playlist_id` INT PRIMARY KEY AUTO_INCREMENT,
       `playlist_name` VARCHAR(45),
       `song_id` VARCHAR(40)
   );

-- insert into playlist
   INSERT INTO `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`) VALUES ('1', 'jaswanth', '1,2,4,7');
   INSERT INTO `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`) VALUES ('2', 'tony', '1,4,5');
