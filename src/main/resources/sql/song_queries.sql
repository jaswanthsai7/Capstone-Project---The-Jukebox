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

-- insert the songs in to song database
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('1', 'akatsuki', 'bass', 'yasuharu', 'shinjuuka', '02:02', 'src/main/resources/songs/akatsuki.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('2', 'faded', 'dance', 'alan walker', 'different world', '03:31', 'src/main/resources/songs/faded.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('3', 'alone', 'dance', 'alan walker', 'different world', '02:40', 'src/main/resources/songs/faded.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`,`song_path`) VALUES ('4', 'happier', 'pop', 'marshmellow', 'fortnite set', '03:38', 'src/main/resources/songs/happier.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('5', 'baby', 'pop', 'justin bieber', 'my world', '03:38', 'src/main/resources/songs/baby.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('6', 'despacito', 'reggaeton', 'louis fonsi', 'vida', '04:41', 'src/main/resources/songs/despacito.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('7', 'intensions', 'r&b', 'justin bieber', 'haileys fav', '03:32', 'src/main/resources/songs/intensions.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('8', 'shapeofyou', 'pop', 'ed sheeran', 'divide', '03:55', 'src/main/resources/songs/shapeofyou.wav');