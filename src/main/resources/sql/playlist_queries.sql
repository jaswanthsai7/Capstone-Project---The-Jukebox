-- create a playlist
   CREATE TABLE `jukebox`.`playlist` (
       `playlist_id` INT PRIMARY KEY AUTO_INCREMENT,
       `playlist_name` VARCHAR(45),
       `song_id` VARCHAR(40)
   );

-- insert into playlist
   INSERT INTO `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`) VALUES ('1', 'jaswanth', '1,2,4,7');
   INSERT INTO `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`) VALUES ('2', 'tony', '1,4,5');
   INSERT INTO `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`) VALUES ('17', 'marry melodies', '13,3,5,7,8');
   INSERT INTO `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song_id`) VALUES ('18', 'test', '2');

-- display all from the playlist
   SELECT * FROM `jukebox`.`playlist`;

-- display from the given playlist name
   SELECT * FROM `jukebox`.`playlist` WHERE `playlist_name`=`hey`;

-- display playlistId and playlistName
   SELECT `playlist_Id`,`playlist_Name` FROM `jukebox`.`playlist`

-- remove the playlist
   Delete FROM `jukebox`.`playlist` WHERE `playlist_name`=`hey`;

