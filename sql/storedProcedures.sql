USE [dhadji02]
GO
/****** Object:  StoredProcedure [dhadji02].[albumComments]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[albumComments]
@album int
AS
BEGIN
SET NOCOUNT ON
SELECT	A.comment
FROM	Album_Comment AS A
WHERE	A.album_id=@album
END
GO
/****** Object:  StoredProcedure [dhadji02].[AlbumDescription]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[AlbumDescription]
(
	@User	int,
	@AlDescription	varchar(50)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Album AS A
	WHERE	A.album_description LIKE '%' + @AlDescription + '%' AND @User = A.album_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[areFriends]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[areFriends]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT DISTINCT U.id, U.username,U.fullname
FROM Friend F
INNER JOIN User_Profile U ON F.sender_id=U.id
WHERE (F.receiver_id=@user AND F.pending=0 AND F.ignore=0) 
UNION
SELECT DISTINCT U.id, U.username, U.fullname
FROM Friend F
INNER JOIN User_Profile U ON F.receiver_id=U.id
WHERE (F.sender_id=@user AND F.pending=0 AND F.ignore=0)
END
GO
/****** Object:  StoredProcedure [dhadji02].[avgAge]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[avgAge]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT	AVG(A.Age)
FROM	GetFriends(@user) AS G, Ages AS A 
WHERE	A.id = G.Closefriend
END
GO
/****** Object:  StoredProcedure [dhadji02].[commonFriends]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[commonFriends]
(--dame ola ta input kai ta output
	@inpuser	INT
)
AS
BEGIN
SET NOCOUNT ON;

SELECT	G.Closefriend 
FROM	GetFriends(@inpuser) AS G
WHERE	NOT EXISTS(
					(SELECT	C.circle
					FROM	GetCircleOfFriends(@inpuser) AS C)
					EXCEPT
					(SELECT C1.circle
					FROM	GetCircleOfFriends(G.Closefriend) AS C1)
		)
				
END

GO
/****** Object:  StoredProcedure [dhadji02].[deleteDB]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dhadji02].[deleteDB]

AS
BEGIN
SET NOCOUNT ON;

DELETE FROM Album_Comment
DELETE FROM Photo_Likes
DELETE FROM Said
DELETE FROM Works_At
DELETE FROM Interested_In
DELETE FROM Video_Comment
DELETE FROM Study
DELETE FROM Participate
DELETE FROM Friend
DELETE FROM Link
DELETE FROM Photo
DELETE FROM Album
DELETE FROM Video
DELETE FROM Happening
DELETE FROM User_Profile
DELETE FROM Workplace
DELETE FROM Education
DELETE FROM Interest
DELETE FROM City
DELETE FROM Quote	
DELETE FROM link_upd
DELETE FROM album_upd
DELETE FROM video_upd
DELETE FROM hap_upd
DELETE FROM photo_upd

END

GO
/****** Object:  StoredProcedure [dhadji02].[DeleteFriend]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dhadji02].[DeleteFriend] ( @User int, @Sender int ) 
AS 
BEGIN 
SET NOCOUNT ON; 
DELETE FROM Friend 
WHERE (@User = receiver_id AND @Sender = sender_id AND pending = 0 AND ignore = 0) OR ( @User = sender_id AND @Sender = receiver_id AND pending = 0 AND ignore = 0) 
END


GO
/****** Object:  StoredProcedure [dhadji02].[deleteInterest]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[deleteInterest]
@user int, @interest int
AS
BEGIN
DELETE FROM [dhadji02].[Interested_In]
      WHERE Interested_In.user_profile_id=@user AND Interested_In.interest_id=@interest
END
GO
/****** Object:  StoredProcedure [dhadji02].[deleteQuote]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[deleteQuote]
@user int, @quote int
AS
BEGIN
DELETE FROM [dhadji02].[Said]
      WHERE Said.quote_id=@quote AND Said.user_profile_id=@user
END
GO
/****** Object:  StoredProcedure [dhadji02].[DeleteRequest]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dhadji02].[DeleteRequest] ( @User int, @Sender int ) 
AS 
BEGIN 
SET NOCOUNT ON; 
DELETE 
FROM Friend 
WHERE (@User = receiver_id AND @Sender = sender_id AND pending = 1 AND ignore = 0) OR (@User = receiver_id AND @Sender = sender_id AND pending = 0 AND ignore = 1)
END


GO
/****** Object:  StoredProcedure [dhadji02].[disp_city]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_city]
AS
BEGIN
SET NOCOUNT ON
SELECT C.city_name
FROM City AS C
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_edu]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_edu]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT E.id, E.edu_name
FROM Education E
WHERE E.id NOT IN(
SELECT S.education_id
FROM  Study AS S
WHERE S.user_profile_id=@user
)
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_interest]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_interest]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT I.id, I.int_description
FROM Interest I
WHERE I.id NOT IN(
SELECT INS.interest_id
FROM  Interested_In AS INS 
WHERE INS.user_profile_id=@user
)
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_quotes]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_quotes]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT Q.id, Q.quote_name
FROM Quote Q
WHERE Q.id NOT IN(
SELECT S.quote_id
FROM  Said AS S
WHERE S.user_profile_id=@user
)
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_useredu]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_useredu]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT DISTINCT Q.edu_name
FROM Education AS Q
INNER JOIN Study AS S ON S.education_id=Q.id
WHERE S.user_profile_id=@user
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_userinterest]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_userinterest]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT DISTINCT I.int_description
FROM Interest AS I
INNER JOIN Interested_In AS INS ON I.id=INS.interest_id
WHERE INS.user_profile_id=@user
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_userquotes]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_userquotes]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT DISTINCT Q.quote_name
FROM Quote AS Q
INNER JOIN Said AS S ON S.quote_id=Q.id
WHERE S.user_profile_id=@user
END
GO
/****** Object:  StoredProcedure [dhadji02].[disp_userwork]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_userwork]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT DISTINCT w.workplace_name
FROM Workplace AS W
INNER JOIN Works_At AS WA ON WA.workplace_id=W.id
WHERE WA.user_profile_id=@user
END

GO
/****** Object:  StoredProcedure [dhadji02].[disp_work]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[disp_work]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT W.id, W.workplace_name
FROM Workplace AS W
WHERE W.id NOT IN(
SELECT WA.workplace_id
FROM  Works_At AS WA 
WHERE WA.user_profile_id=@user
)
END
GO
/****** Object:  StoredProcedure [dhadji02].[EventDescription]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[EventDescription]
(
	@User	int,
	@evDescription	varchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Happening AS H
	WHERE	H.hap_description LIKE '%' + @evDescription + '%' AND @User = H.host

END
GO
/****** Object:  StoredProcedure [dhadji02].[famousFriends]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[famousFriends]
@user int
AS
BEGIN
SET NOCOUNT ON

select  sumf.receiver_id, sumf.friendCount
FROM	sumFriends AS sumF, GetFriends(@user) as G
WHERE	sumF.receiver_id = G.Closefriend AND sumF.friendCount = (
		SELECT  MAX(sumF1.friendCount)
		FROM	sumFriends AS sumF1,GetFriends(@user) AS list
		WHERE	sumF1.receiver_id =  list.Closefriend
		) 
END
GO
/****** Object:  StoredProcedure [dhadji02].[FriendBigAlbum]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dhadji02].[FriendBigAlbum] 
( @CountPhoto int, @User int ) 
AS 
BEGIN 
SET NOCOUNT ON; 
SELECT G.Closefriend, A.album_count, A.album_name 
FROM GetFriends(@User) AS G, Album AS A 
WHERE A.album_count > @CountPhoto AND A.album_owner = G.Closefriend 
END
GO
/****** Object:  StoredProcedure [dhadji02].[friendRequests]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dhadji02].[friendRequests]
@user int
AS
BEGIN
SET NOCOUNT ON 
SELECT DISTINCT U.id, U.username, U.fullname
FROM Friend F
INNER JOIN User_Profile U ON F.sender_id=U.id
WHERE F.receiver_id=@user AND F.pending=1 AND F.ignore=0 
END
GO
/****** Object:  StoredProcedure [dhadji02].[Get_Table_Names]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE	PROCEDURE	[dhadji02].[Get_Table_Names]
AS

BEGIN
	SELECT	TABLE_NAME
	FROM	INFORMATION_SCHEMA.TABLES
	WHERE	TABLE_TYPE = 'BASE TABLE'
END

GO
/****** Object:  StoredProcedure [dhadji02].[giveID]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[giveID]
AS
BEGIN
SET NOCOUNT ON
SELECT	IDENT_CURRENT('User_Profile') AS usrID
END
GO
/****** Object:  StoredProcedure [dhadji02].[giveNonFamousEvents]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dhadji02].[giveNonFamousEvents]
--dame ola ta input kai ta output
AS
BEGIN
	SET NOCOUNT ON;

SELECT	E.event_id 
FROM	EventCount AS E
WHERE	E.evcount <= ALL (
					SELECT		MIN(E.evcount)
					FROM		EventCount AS E)	

END

GO
/****** Object:  StoredProcedure [dhadji02].[haveInCommon]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dhadji02].[haveInCommon]
(--dame ola ta input kai ta output
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT		S.user_profile_id, COUNT(S.user_profile_id) AS NUM
	FROM		inpEducation(@inpuser) AS E,Study AS S
	WHERE		E.education_id = S.education_id AND E.user_profile_id != S.user_profile_id
	GROUP BY	S.user_profile_id
	ORDER BY	COUNT(S.user_profile_id) DESC

END
GO
/****** Object:  StoredProcedure [dhadji02].[haveInCommonB]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[haveInCommonB]
(--dame ola ta input kai ta output
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT		WA.user_profile_id, COUNT(WA.user_profile_id) AS NUM
	FROM		inpWorkplace(@inpuser) AS W,Works_At AS WA
	WHERE		W.workplace_id = WA.workplace_id AND W.user_profile_id != WA.user_profile_id
	GROUP BY	WA.user_profile_id
	ORDER BY	COUNT(WA.user_profile_id) DESC

END
GO
/****** Object:  StoredProcedure [dhadji02].[ignored]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[ignored]
@user int
AS
BEGIN
SET NOCOUNT ON 
SELECT DISTINCT U.id, U.username,U.fullname
FROM Friend F
INNER JOIN User_Profile U ON F.sender_id=U.id
WHERE F.receiver_id=@user AND F.pending=0 AND F.ignore=1 
END
GO
/****** Object:  StoredProcedure [dhadji02].[insertAlbum]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--isagogi album
CREATE PROCEDURE [dhadji02].[insertAlbum]
(--dame ola ta input kai ta output
	@inpname		nvarchar(50),
	@inpdescr		nvarchar(500),
	@inpurl			nvarchar(50),
	@inpcount		INT,
	@inpprivacy		nvarchar(1),
	@inpowner		INT,
	@inplocation	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Album ([album_name], [album_description], [album_url], [album_count], [privacy], [album_owner], [album_location])
	VALUES (@inpname,@inpdescr,@inpurl,@inpcount,@inpprivacy,@inpowner,@inplocation)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertAlbumCom]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertAlbumCom]
(--dame ola ta input kai ta output
	@inpid		INT,
	@inpuser	INT,
	@inpcom		nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Album_Comment ([album_id], [user_profile_id], [comment]) 
	VALUES (@inpid, @inpuser, @inpcom)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertCity]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertCity]
(--dame ola ta input kai ta output
	@inp		nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO City([city_name])
	VALUES (@inp)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertEducation]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dhadji02].[insertEducation]
(--dame ola ta input kai ta output
	@inp		nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Education([edu_name])
	VALUES (@inp)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertHappening]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--isagogi event
CREATE PROCEDURE [dhadji02].[insertHappening]
(--dame ola ta input kai ta output
	@inpname		nvarchar(50),
	@inpdescr		nvarchar(500),
	@inpstart		smalldatetime,
	@inpend			smalldatetime,
	@inpprivacy		nvarchar(1),
	@inpcity		nvarchar(50),
	@inphost		INT,
	@inplocation	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Happening([hap_name], [hap_description], [start_time], [end_time], [privacy], [hap_city], [host], [hap_location])
	VALUES (@inpname,@inpdescr,@inpstart,@inpend,@inpprivacy,@inpcity,@inphost,@inplocation)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertInterest]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[insertInterest]
@user int, @interest int
AS
BEGIN
INSERT INTO [dhadji02].[Interested_In]
           ([interest_id]
           ,[user_profile_id])
     VALUES
           (@interest
           ,@user)
END
GO
/****** Object:  StoredProcedure [dhadji02].[insertInterestedIn]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertInterestedIn]
(--dame ola ta input kai ta output
	@inpint		INT,
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Interested_in ([interest_id], [user_profile_id]) 
	VALUES (@inpint, @inpuser)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertLink]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--isagogi link
CREATE PROCEDURE [dhadji02].[insertLink]
(--dame ola ta input kai ta output
	@inpname		nvarchar(50),
	@inpcaption		nvarchar(50),
	@inpdescr		nvarchar(500),
	@inpurl			nvarchar(50),
	@inpmessage		nvarchar(50),
	@inpowner		INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Link ([link_name],[caption],[link_description],[link],[link_message],[link_owner])
	VALUES (@inpname,@inpcaption,@inpdescr,@inpurl,@inpmessage,@inpowner)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertParticipate]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--isagogi event
CREATE PROCEDURE [dhadji02].[insertParticipate]
(--dame ola ta input kai ta output
	@inpevent		INT,
	@inpuser		INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Participate([event_id], [user_profile_id])
	VALUES (@inpevent,@inpuser)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertPhoto]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--isagogi photo
CREATE PROCEDURE [dhadji02].[insertPhoto]
(--dame ola ta input kai ta output
	@inpsource		nvarchar(260),
	@inpurl			nvarchar(80),
	@inpwidth		REAL,
	@inpheight		REAL,
	@inpowner		INT,
	@inpalbumid		INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Photo ([ph_source], [ph_url], [width], [height], [ph_owner], [album_id])
	VALUES (@inpsource,@inpurl,@inpwidth,@inpheight,@inpowner,@inpalbumid)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertPhotoLikes]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dhadji02].[insertPhotoLikes]
(--dame ola ta input kai ta output
	@inpph		INT,
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Photo_Likes ([photo_id], [user_profile_id]) 
	VALUES (@inpph, @inpuser)


END
GO
/****** Object:  StoredProcedure [dhadji02].[insertQuote]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[insertQuote]
@user int, @quote int
AS
BEGIN
INSERT INTO [dhadji02].[Said]
           ([quote_id]
           ,[user_profile_id])
     VALUES
           (@quote
           ,@user)
END
GO
/****** Object:  StoredProcedure [dhadji02].[insertSaid]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertSaid]
(--dame ola ta input kai ta output
	@inpq		INT,
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Said ([quote_id], [user_profile_id]) 
	VALUES (@inpq, @inpuser)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertStudy]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertStudy]
(--dame ola ta input kai ta output
	@inpedu		INT,
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Study ([education_id], [user_profile_id]) 
	VALUES (@inpedu, @inpuser)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertUser]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


--isagogi xristi
CREATE PROCEDURE [dhadji02].[insertUser]
(--dame ola ta input kai ta output
	@inpfull		nvarchar(100),
	@inpfirst		nvarchar(50),
	@inplast		nvarchar(50),
	@inpbdate		DATE,
	@inpemail		nvarchar(50),
	@inpgender		BIT,
	@inpwebsite		nvarchar(80),
	@inpurl			nvarchar(80),
	@inpverified	BIT,
	@inphome		INT,
	@inplocation	INT,
	@inppass		nvarchar(50),
	@inpusername	nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO User_Profile ([fullname],[first_name],[last_name],[birthday],[email],[gender],[user_website],[user_url],[verified],[user_hometown],[user_location],[user_password],[username])
	VALUES (@inpfull,@inpfirst,@inplast,@inpbdate,@inpemail,@inpgender,@inpwebsite,@inpurl,@inpverified,@inphome,@inplocation,@inppass,@inpusername)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertVideo]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--isagogi video
CREATE PROCEDURE [dhadji02].[insertVideo]
(--dame ola ta input kai ta output
	@inpmessage		nvarchar(50),
	@inpdescr		nvarchar(500),
	@inplength		BIGINT,
	@inpowner		INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Video ([vid_message],[vid_description],[vid_length],[vid_owner])
	VALUES (@inpmessage,@inpdescr,@inplength,@inpowner)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertVideoCom]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertVideoCom]
(--dame ola ta input kai ta output
	@inpid		INT,
	@inpuser	INT,
	@inpcom		nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Video_Comment ([video_id], [user_profile_id], [comment]) 
	VALUES (@inpid, @inpuser, @inpcom)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertWorkplace]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dhadji02].[insertWorkplace]
(--dame ola ta input kai ta output
	@inp		nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Workplace([workplace_name])
	VALUES (@inp)

END
GO
/****** Object:  StoredProcedure [dhadji02].[insertWorksAt]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dhadji02].[insertWorksAt]
(--dame ola ta input kai ta output
	@inpwrk		INT,
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO Works_At ([workplace_id], [user_profile_id]) 
	VALUES (@inpwrk, @inpuser)

END
GO
/****** Object:  StoredProcedure [dhadji02].[LinkCaption]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[LinkCaption]
(
	@User	int,
	@Lcaption varchar(20)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Link AS L
	WHERE	L.caption LIKE '%' + @Lcaption + '%' AND @User = L.link_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[LinkURL]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[LinkURL]
(
	@User	int,
	@URL varchar(100)
)

AS
BEGIN

	SET NOCOUNT ON;

	SELECT	*
	FROM	Link AS L
	WHERE	L.link LIKE '%' + @URL + '%' AND @User = L.link_owner

END

GO
/****** Object:  StoredProcedure [dhadji02].[PhotoHeight]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[PhotoHeight]
(
	@User	int,
	@PHeight REAL
)

AS
BEGIN
	SET NOCOUNT ON;
	
	SELECT	*
	FROM	Photo AS PH
	WHERE	PH.height <= @PHeight  AND @User = PH.ph_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[photosAlbum]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[photosAlbum]
@user int,
@album int
AS
BEGIN
SET NOCOUNT ON
SELECT	p.id
FROM	Photo AS P
WHERE	p.album_id=@album AND @user=p.id
END
GO
/****** Object:  StoredProcedure [dhadji02].[photosLikes]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[photosLikes]
@photo int
AS
BEGIN
SET NOCOUNT ON
SELECT	P.user_profile_id
FROM	Photo_Likes AS P
WHERE	P.photo_id=@photo
END
GO
/****** Object:  StoredProcedure [dhadji02].[PhotoWidth]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[PhotoWidth]
(
	@User	int,
	@PWidth	REAL
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Photo AS PH
	WHERE	PH.width <=@PWidth  AND @User = PH.ph_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[resetIDENTITY]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dhadji02].[resetIDENTITY]

AS
BEGIN
	SET NOCOUNT ON;

	DBCC CHECKIDENT (Album,RESEED,0)
	DBCC CHECKIDENT (City,RESEED,0)
	DBCC CHECKIDENT (Education,RESEED,0)
	DBCC CHECKIDENT (Happening,RESEED,0)
	DBCC CHECKIDENT (Interest,RESEED,0)
	DBCC CHECKIDENT (Link,RESEED,0)
	DBCC CHECKIDENT (Photo,RESEED,0)
	DBCC CHECKIDENT (Quote, RESEED, 0)
	DBCC CHECKIDENT (User_Profile,RESEED,0)
	DBCC CHECKIDENT (Video,RESEED,0)		
	DBCC CHECKIDENT (Workplace,RESEED,0)	

END
GO
/****** Object:  StoredProcedure [dhadji02].[sameInterests]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dhadji02].[sameInterests]
(--dame ola ta input kai ta output
	@inpuser	INT
)
AS
BEGIN
SET NOCOUNT ON;

SELECT	G.Closefriend
FROM	GetFriends(@inpuser) AS G 
WHERE	NOT EXISTS(
				(SELECT	G1.Interest
				FROM	GetInterests(@inpuser) AS G1
				EXCEPT
				SELECT	G2.Interest
				FROM	GetInterests(G.Closefriend) AS G2)
				UNION ALL
				(SELECT	G1.Interest
				FROM	GetInterests(G.Closefriend) AS G1
				EXCEPT
				SELECT	G2.Interest
				FROM	GetInterests(@inpuser) AS G2)
		) 
  

END

GO
/****** Object:  StoredProcedure [dhadji02].[searchForOtherUsers]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


--evresi allon xriston me vasi imerominia gennisis kai poli diamonis
CREATE PROCEDURE [dhadji02].[searchForOtherUsers]
(--dame ola ta input kai ta output
	@inpuser	INT,
	@parameter int,
	@username	nvarchar(50),
	@inpcity	nvarchar(50),
	@inpbirth	date
)
AS
BEGIN
	SET NOCOUNT ON;
	IF @parameter=1
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND (C.city_name LIKE '%'+@inpcity+'%' AND U.birthday LIKE @inpbirth AND U.first_name LIKE '%'+ @username +'%')
	END
	IF @parameter=2
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND U.birthday LIKE @inpbirth AND U.first_name LIKE '%'+ @username +'%'
	END
	IF @parameter=3
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND (C.city_name LIKE '%'+@inpcity+'%'  AND U.first_name LIKE '%'+ @username +'%')
	END
	IF @parameter=4
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND (C.city_name LIKE '%'+@inpcity+'%' AND U.birthday LIKE @inpbirth)
	END
	IF @parameter=7
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND C.city_name LIKE '%'+@inpcity+'%'
	END
	IF @parameter=6
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND U.birthday LIKE @inpbirth 
	END
	IF @parameter=5
	BEGIN
	SELECT	U.fullname, U.id
	FROM	User_Profile AS U,City AS C
	WHERE	U.user_location = C.id 
			AND U.id != @inpuser AND U.first_name LIKE '%'+ @username +'%'
	END
END

GO
/****** Object:  StoredProcedure [dhadji02].[ShowAlbum]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[ShowAlbum]
(
	@UserID int
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Album AS A
	WHERE	@UserID = A.album_owner

END


GO
/****** Object:  StoredProcedure [dhadji02].[ShowEvent]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[ShowEvent]
(
	@User	int
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Happening AS H
	WHERE	@User = H.host

END

GO
/****** Object:  StoredProcedure [dhadji02].[ShowLink]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[ShowLink]
(
	@User	int
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Link AS L
	WHERE	@User = L.link_owner

END

GO
/****** Object:  StoredProcedure [dhadji02].[ShowPhoto]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[ShowPhoto]
(
	@User	int
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Photo AS PH
	WHERE	@User = PH.ph_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[ShowVideo]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[ShowVideo]
(
	@User	int
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Video AS V
	WHERE	@User = V.vid_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[splog]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[splog]
(
	@Username varchar(50),
	@Password varchar(50)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	UP.fullname, UP.id
	FROM	User_Profile AS UP
	WHERE	UP.username = @Username AND UP.user_password = @Password

END
GO
/****** Object:  StoredProcedure [dhadji02].[spSearchAlbum]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[spSearchAlbum]
(
	@User	int,
	@SearchAlbumName varchar(50)
	

)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Album AS A
	WHERE	A.album_name LIKE '%' + @SearchAlbumName + '%' AND @User = A.album_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[spSearchEvent]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dhadji02].[spSearchEvent]
(
	@User	int,
	@SearchEventName varchar(50)
	
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Happening AS H
	WHERE	H.hap_name LIKE '%' + @SearchEventName + '%' AND @User = H.host

END


GO
/****** Object:  StoredProcedure [dhadji02].[spSearchLink]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[spSearchLink]
(
	@User	int,
	@SearchLinkName varchar(100)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Link AS L
	WHERE	L.link_name LIKE '%' + @SearchLinkName + '%' AND @User = L.link_owner

END

GO
/****** Object:  StoredProcedure [dhadji02].[spSearchPhoto]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[spSearchPhoto]
(
	@User	int,
	@SearchPhotoName varchar(100)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Photo AS PH
	WHERE	PH.ph_source LIKE '%' + @SearchPhotoName + '%' AND @User = PH.ph_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[spSearchVideo]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[spSearchVideo]
(
	@User	int,
	@SearchVideoName varchar(50)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Video AS V
	WHERE	V.vid_message LIKE '%' + @SearchVideoName + '%' AND @User = V.vid_owner

END

GO
/****** Object:  StoredProcedure [dhadji02].[takeAlbumFromUsers]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dhadji02].[takeAlbumFromUsers]
(--dame ola ta input kai ta output
	@inpuser	INT,
	@inpurl		nvarchar(50)
)
AS
BEGIN

	SET NOCOUNT ON;

(	SELECT	A.album_name,A.id
	FROM	Album AS A
	WHERE	A.[privacy]=1 AND A.[album_owner]!=@inpuser AND A.album_url LIKE '%'+@inpurl+'%')
UNION
(	SELECT	A.album_name, A.id
	FROM	Album AS A,GetFriends(@inpuser) AS G
	WHERE	(A.[privacy]=3 OR A.[privacy]=4) AND A.album_owner = G.Closefriend AND A.album_url LIKE '%'+@inpurl+'%')
UNION
(	SELECT	A.album_name, A.id
	FROM	Album AS A, GetLevel3friends(@inpuser) AS GL3F
	WHERE	A.[privacy]=4 AND A.album_owner = GL3F.level3Friends AND A.album_url LIKE '%'+@inpurl+'%')
	
END

GO
/****** Object:  StoredProcedure [dhadji02].[takeAlbums]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dhadji02].[takeAlbums] 
(@User int ) 
AS 
BEGIN 
SET NOCOUNT ON; 
SELECT A.id
FROM Album AS A
WHERE A.album_owner=@User
END
GO
/****** Object:  StoredProcedure [dhadji02].[takeHappeningFromUsers]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dhadji02].[takeHappeningFromUsers]
(--dame ola ta input kai ta output
	@inpuser	INT,
	@inpcity	nvarchar(50)
)
AS
BEGIN

	SET NOCOUNT ON;

(	SELECT	H.hap_name, H.id
	FROM	Happening AS H,City AS C
	WHERE	H.[privacy]=1 AND H.hap_location=C.id AND H.[host]!=@inpuser AND C.city_name LIKE '%'+ @inpcity+ '%')
UNION
(	SELECT	H.hap_name, H.id 
	FROM	Happening AS H,GetFriends(@inpuser) AS G,City AS C
	WHERE	(H.[privacy]=3 OR H.[privacy]=4) AND H.host = G.Closefriend AND H.hap_location=C.id AND C.city_name LIKE '%'+ @inpcity+ '%')
UNION
(	SELECT	H.hap_name, H.id
	FROM	Happening AS H, GetLevel3friends(@inpuser) AS GL3F,City AS C
	WHERE	H.[privacy]=4 AND H.[host] = GL3F.level3Friends AND H.hap_location=C.id AND C.city_name LIKE '%'+ @inpcity+ '%')
	
END

GO
/****** Object:  StoredProcedure [dhadji02].[takeLinksFromUsers]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



--evresi links allon xriston ta opia exoun tin ipolexi click sto  minima tous
CREATE PROCEDURE [dhadji02].[takeLinksFromUsers]
(--dame ola ta input kai ta output
	@inpuser	INT,
	@inpurl		nvarchar(50)
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT	L.link_name, L.id
	FROM	Link AS L
	WHERE	L.link_owner!= @inpuser AND L.link_message LIKE '%'+@inpurl+'%'
END
GO
/****** Object:  StoredProcedure [dhadji02].[takePhotosFromUsers]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--evresi photos allon xriston me vasi kapia kritiria
CREATE PROCEDURE [dhadji02].[takePhotosFromUsers]
(--dame ola ta input kai ta output
	@inpuser	INT,
	@inpheight	REAL
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT	P.ph_source,P.[id]
	FROM	Photo AS P
	WHERE	P.[ph_owner]!= @inpuser  AND P.[height] >= @inpheight
END
GO
/****** Object:  StoredProcedure [dhadji02].[takeVideosFromUsers]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--evresi videos allon xriston me vasi length (mikrotero kapiou length)
CREATE PROCEDURE [dhadji02].[takeVideosFromUsers]
(--dame ola ta input kai ta output
	@inpuser	INT,
	@inplength	BIGINT
)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT	V.vid_message AS Video_Tittle, V.id
	FROM	Video AS V
	WHERE	V.vid_owner!= @inpuser AND V.vid_length <= @inplength
END
GO
/****** Object:  StoredProcedure [dhadji02].[up_Album]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[up_Album]
@user int, @k int
AS
BEGIN
SET NOCOUNT ON
SELECT TOP(@k) A.album_id, A.updated_at, A.operation
FROM album_upd AS A
WHERE A.user_id=@user
ORDER BY A.change_id DESC
END

GO
/****** Object:  StoredProcedure [dhadji02].[up_all]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[up_all]
@user int, @K INT
AS
BEGIN
SET NOCOUNT ON
SELECT	TOP(@K) U.updated_at, U.operation
FROM	updates AS U
WHERE	U.user_id=@user
ORDER BY U.updated_at DESC
END
GO
/****** Object:  StoredProcedure [dhadji02].[up_Hap]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[up_Hap]
@user int, @k int
AS
BEGIN
SET NOCOUNT ON
SELECT TOP(@k) L.happening_id, L.updated_at, L.operation
FROM hap_upd AS L
WHERE L.user_id=@user
ORDER BY L.change_id DESC
END
GO
/****** Object:  StoredProcedure [dhadji02].[up_Link]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[up_Link]
@user int, @k int
AS
BEGIN
SET NOCOUNT ON
SELECT TOP(@k) L.link_id, L.updated_at, L.operation
FROM link_upd AS L
WHERE L.user_id=@user
ORDER BY L.change_id DESC
END
GO
/****** Object:  StoredProcedure [dhadji02].[up_photo]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[up_photo]
@user int, @k int
AS
BEGIN
SET NOCOUNT ON
SELECT TOP(@k) L.photo_id,L.updated_at, L.operation
FROM photo_upd AS L
WHERE L.user_id=@user
ORDER BY L.change_id DESC
END
GO
/****** Object:  StoredProcedure [dhadji02].[up_Video]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dhadji02].[up_Video]
@user int, @k int
AS
BEGIN
SET NOCOUNT ON
SELECT TOP(@k) L.video_id,L.updated_at, L.operation
FROM video_upd AS L
WHERE L.user_id=@user
ORDER BY L.change_id DESC
END
GO
/****** Object:  StoredProcedure [dhadji02].[updateAlbum]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updateAlbum]
 @name nvarchar(50),@description nvarchar(500), @url nvarchar(50), 
@count int, @privacy int, @owner int, @location int,@album_id int
AS
BEGIN
SET NOCOUNT ON
UPDATE [dhadji02].[Album]
   SET [album_name] = @name
      ,[album_description] = @description
      ,[album_url] = @url
      ,[album_count] = @count
      ,[privacy] = @privacy
      ,[album_owner] = @owner
      ,[album_location] = @location
 WHERE Album.id=@album_id
 END
GO
/****** Object:  StoredProcedure [dhadji02].[updatecount]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updatecount]
@owner int,@album_id int
AS
BEGIN
SET NOCOUNT ON
UPDATE [dhadji02].[Album]
   SET [album_count] = album_count+1
 WHERE Album.id=@album_id AND Album.album_owner=@owner
 END
GO
/****** Object:  StoredProcedure [dhadji02].[updateFriend]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updateFriend]
@receiver int, @ignore int, @pending int,@sender int
AS
UPDATE [dhadji02].[Friend]
   SET [pending] = @pending
      ,[ignore] = @ignore
 WHERE Friend.receiver_id=@receiver AND Friend.sender_id=@sender
GO
/****** Object:  StoredProcedure [dhadji02].[updateHappening]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updateHappening]
@name nvarchar(50),@description nvarchar(50), @starttime smalldatetime, 
@endtime smalldatetime, @privacy nvarchar(1), @city nvarchar(50), @host int, @location int,@hap_id int
AS 
UPDATE [dhadji02].[Happening]
   SET [hap_name] = @name
      ,[hap_description] = @description
      ,[start_time] = @starttime
      ,[end_time] = @endtime
      ,[privacy] = @privacy
      ,[hap_city] = @city
      ,[host] = @host
      ,[hap_location] = @location
 WHERE Happening.id=@hap_id
GO
/****** Object:  StoredProcedure [dhadji02].[updateLink]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updateLink]
 @name nvarchar(50), @caption nvarchar(50), @description nvarchar(500), @link nvarchar(50), @message nvarchar(50), @owner int,@link_id int
AS
UPDATE [dhadji02].[Link]
   SET [link_name] = @name
      ,[caption] = @caption
      ,[link_description] = @description
      ,[link] = @link
      ,[link_message] = @message
      ,[link_owner] = @owner
 WHERE Link.id=@link_id
GO
/****** Object:  StoredProcedure [dhadji02].[updatePhoto]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updatePhoto]
 @source varchar(max),@url nvarchar(80), @width real, 
@height real, @owner int, @album int,@photo_id int
AS 
UPDATE [dhadji02].[Photo]
   SET [ph_source] = @source
      ,[ph_url] = @url
      ,[width] = @width
      ,[height] = @height
      ,[ph_owner] = @owner
      ,[album_id] = @album
 WHERE Photo.id=@photo_id
GO
/****** Object:  StoredProcedure [dhadji02].[updateUser]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updateUser]
 @full nvarchar(100), @fname nvarchar(50), @lname nvarchar(50),@bday date, @mail nvarchar(50), 
@gender bit, @website nvarchar(50),@url nvarchar(50),@verified bit, 
@hometown int, @location int, @password nvarchar(50),@username nvarchar(50),@user int
AS
UPDATE [dhadji02].[User_Profile]
   SET [fullname] = @full
      ,[first_name] = @fname
      ,[last_name] = @lname
      ,[birthday] = @bday
      ,[email] = @mail
      ,[gender] = @gender
      ,[user_website] = @website
      ,[user_url] = @url
      ,[verified] = @verified
      ,[user_hometown] = @hometown
      ,[user_location] = @location
      ,[user_password] = @password
      ,[username] = @username
 WHERE User_Profile.id=@user
GO
/****** Object:  StoredProcedure [dhadji02].[updateVideo]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[updateVideo]
 @msg nvarchar(50),@description nvarchar(500),@length bigint, @owner int,@video_id int
AS
UPDATE [dhadji02].[Video]
   SET [vid_message] = @msg
      ,[vid_description] = @description
      ,[vid_length] = @length
      ,[vid_owner] = @owner
 WHERE Video.id=@video_id
GO
/****** Object:  StoredProcedure [dhadji02].[UserProfile]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[UserProfile]
(--dame ola ta input kai ta output
	@inpuser	INT
)
AS
BEGIN
	SET NOCOUNT ON;
	SELECT *
	FROM User_Profile AS U
	WHERE U.id=@inpuser
END
GO
/****** Object:  StoredProcedure [dhadji02].[usr_interest]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[usr_interest]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT I.int_description
FROM Interested_In AS Ins
INNER JOIN Interest I ON INS.interest_id=i.id
WHERE INS.user_profile_id=@user
END
GO
/****** Object:  StoredProcedure [dhadji02].[usr_quotes]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dhadji02].[usr_quotes]
@user int
AS
BEGIN
SET NOCOUNT ON
SELECT Q.quote_name
FROM Said AS S
INNER JOIN Quote Q ON Q.id=S.quote_id
WHERE S.user_profile_id=@user
END
GO
/****** Object:  StoredProcedure [dhadji02].[videoComments]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dhadji02].[videoComments]
@video int
AS
BEGIN
SET NOCOUNT ON
SELECT	V.comment
FROM	Video_Comment AS V
WHERE	V.video_id=@video
END
GO
/****** Object:  StoredProcedure [dhadji02].[VideoDescription]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[VideoDescription]
(
	@User	int,
	@Vdescription	varchar(50)
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Video AS V
	WHERE	V.vid_description LIKE '%' + @Vdescription + '%' AND @User = V.vid_owner

END
GO
/****** Object:  StoredProcedure [dhadji02].[VideoLength]    Script Date: 06/12/2020 22:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE	Procedure	[dhadji02].[VideoLength]
(
	@User	int,
	@VLength BIGINT
)

AS
BEGIN
	SET NOCOUNT ON;

	SELECT	*
	FROM	Video AS V
	WHERE	V.vid_length <= @VLength AND @User = V.vid_owner

END

GO
