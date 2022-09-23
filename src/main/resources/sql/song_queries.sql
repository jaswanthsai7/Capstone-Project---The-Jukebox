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
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('9', 'finesse', 'electronic', 'bruno mars', 'magic24k', '03:37', 'src/main/resources/songs/finesse.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('10', 'godsplan', 'hip hop', 'drake', 'scorpion', '03:19', 'src/main/resources/songs/godsplan.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('11', 'shakeitup', 'pop', 'salena gomez', 'shake it up', '02:54', 'src/main/resources/songs/shakeitup.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('12', 'titanium', 'pop', 'david guetta', 'nothing but the  beat', '04:03', 'src/main/resources/songs/titanium.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('13', 'unstoppable', 'pop', 'sia', 'this is acting', '03:37', 'src/main/resources/songs/unstoppable.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('14', 'we dont talk anymore', 'pop', 'charlie puth', 'nine track mind', '03:37', 'src/main/resources/songs/wedonttalkanymore.wav');
 INSERT INTO `jukebox`.`song` (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`, `song_path`) VALUES ('15', 'wake me up', 'house music', 'avicii', 'true', '04:09', 'src/main/resources/songs/wakemeup.wav');
