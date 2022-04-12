create database javafinal;

use javafinal; 

describe user;

drop table user;

select *from user;

create table user
(userid int primary key not null,
password varchar(20) not null,
name varchar(30) not null,
phoneNO varchar(10) not null,
email varchar(30) not null,
age int not null);

insert into user
values(1,'pavan24','pavan','7680884465','murari24@gmail.com',24),
(2,'gopi20','Gopi Prakash','9960326547','gopinani@gmail.com',24);

describe playlistinterface;

drop table playlistinterface;

select *from playlistinterface;

create table playlistinterface
(playlistid int primary key not null auto_increment,
playlistname varchar(20) not null,
userID int not null references user(userid));


insert into playlistinterface(playlistname,userID)
values('jazz',2);

drop table playlist;

describe playlist;

create table playlist
(playlistID int not null references playlistinterface(playlistid),
songName varchar(20),
poscastName varchar(20),
albumName varchar(20),
duratiom varchar(20),
audioID int not null references audio(audioid));

select *from playlist;

insert into playlist(playlistID,songName,albumName,duratiom,audioID)
values(1,'song1','album1','04:53',6001);

insert into playlist(playlistID,poscastName,duratiom,audioID)
values(1,'podcast1','25:56',6002);


describe artist;

drop table artist;

create table artist
(artistid int primary key not null,
aname varchar(30) not null,
details varchar(30) not null);

describe song;

drop table song;

create table song
(songid int primary key not null,
songtitle varchar(20) not null,
album varchar(20) not null,
genre varchar(10) not null,
duration varchar(10) not null,
url varchar(50) not null,
artistID int not null references artist(artistid));

select *from song;

insert into song
values(1001,'song1','album1','genre1','04:32','url1',3001),
(1002,'song2','album2','genre2','03:56','url2',3002),
(1003,'song3','album3','genre3','04:50','url3',3003);


describe podcast;

drop table podcast;

select *from podcast;

create table podcast
(postcastid int primary key not null,
pduration varchar(10) not null,
createdate date not null, 
pgenre varchar(30) not null,
url1 varchar(50) not null,
partistID int not null  references artist(artistid));

insert into podcast
values(2001,'53:25','2022-01-26','motivational','url11',3002),
(2002,'32:02','2021-11-24','spiritual','url12',3001);

describe audio;

select *from audio;

create table audio
(audioid int primary key,
audiotype varchar(10) not null,
songsid int references song(songid),
podid int references podcast(podcastid));

insert into audio
values(4001,'song',1001,null),
(4002,'podcast',null,2002);

select song.songtitle,song.album,audio.audiotype,audio.songsid,audioid
from audio join song
on audio.songsid=song.songid;


