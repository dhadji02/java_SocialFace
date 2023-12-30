ALTER TABLE Album
DROP CONSTRAINT FK_Aowner;
ALTER TABLE Album
DROP CONSTRAINT FK_Alocation;

ALTER TABLE Album_Comment
DROP CONSTRAINT FK_ACuser;
ALTER TABLE Album_Comment
DROP CONSTRAINT FK_ACalbum;

ALTER TABLE Friend
DROP CONSTRAINT FK_Freceiver;		
ALTER TABLE Friend
DROP CONSTRAINT FK_Fsender;

ALTER TABLE Happening
DROP CONSTRAINT FK_Hhost ;		
ALTER TABLE Happening
DROP CONSTRAINT FK_Hlocation ;

ALTER TABLE Interested_In
DROP CONSTRAINT FK_IIuser ;		
ALTER TABLE Interested_In
DROP CONSTRAINT FK_IIinterested ;

ALTER TABLE Link
DROP CONSTRAINT FK_Lowner;

ALTER TABLE Participate
DROP CONSTRAINT FK_Puser;		
ALTER TABLE Participate
DROP CONSTRAINT FK_Puser;

ALTER TABLE Photo
DROP CONSTRAINT FK_Powner ;		
ALTER TABLE Photo
DROP CONSTRAINT FK_Palbum_id ;

ALTER TABLE Photo_Likes
DROP CONSTRAINT FK_PLuser;		
ALTER TABLE Photo_Likes
DROP CONSTRAINT FK_PLphoto;

ALTER TABLE Said
DROP CONSTRAINT FK_SSuser ;		
ALTER TABLE Said
DROP CONSTRAINT FK_SSquote ;

ALTER TABLE Study
DROP CONSTRAINT FK_Suser;		
ALTER TABLE Study
DROP CONSTRAINT FK_Seducation;

ALTER TABLE User_Profile
DROP CONSTRAINT FK_UPHometown ;		
ALTER TABLE User_Profile
DROP CONSTRAINT FK_UPlocation ;

ALTER TABLE Video
DROP CONSTRAINT FK_Vowner;

ALTER TABLE Video_Comment
DROP CONSTRAINT FK_VCuser;		
ALTER TABLE Video_Comment
DROP CONSTRAINT FK_VCvideo;

ALTER TABLE Works_At
DROP CONSTRAINT FK_WAuser ;		
ALTER TABLE Works_At
DROP CONSTRAINT FK_WAworkplace ;

DROP TABLE Album;
DROP TABLE Album_Comment;
DROP TABLE City;
DROP TABLE Education;
DROP TABLE Friend;
DROP TABLE Happening;
DROP TABLE Interest;
DROP TABLE Interested_In;
DROP TABLE Link;
DROP TABLE Participate;
DROP TABLE Photo;
DROP TABLE Photo_Likes;
DROP TABLE Quote;
DROP TABLE Said;
DROP TABLE Study;
DROP TABLE User_Profile;
DROP TABLE Video;
DROP TABLE Video_Comment;
DROP TABLE Workplace;
DROP TABLE Works_At;