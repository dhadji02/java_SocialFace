USE [dhadji02]
GO
/****** Object:  View [dhadji02].[Ages]    Script Date: 06/12/2020 22:30:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dhadji02].[Ages]
AS 
SELECT User_Profile.id ,DATEDIFF(year,birthday, GETDATE()) AS Age
FROM User_Profile
GO
/****** Object:  View [dhadji02].[EventCount]    Script Date: 06/12/2020 22:30:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


--evresi xiroteron event
CREATE VIEW [dhadji02].[EventCount]
AS
	SELECT		H.id AS event_id,COUNT(P.user_profile_id) AS evcount
	FROM		Participate AS P RIGHT JOIN Happening AS H ON P.event_id = H.id
	GROUP BY	H.id
	

GO
/****** Object:  View [dhadji02].[sumFriends]    Script Date: 06/12/2020 22:30:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dhadji02].[sumFriends]
AS 
SELECT L.Sourceuser AS receiver_id, COUNT (L.Sourceuser) AS friendCount
FROM GetList() AS L
GROUP BY L.Sourceuser
GO
/****** Object:  View [dhadji02].[updates]    Script Date: 06/12/2020 22:30:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dhadji02].[updates]
AS
SELECT P.user_id, P.updated_at, P.operation
FROM photo_upd AS P
UNION ALL
SELECT H.user_id, H.updated_at, H.operation
FROM hap_upd as H
UNION ALL
SELECT A.user_id, A.updated_at, A.operation
FROM album_upd as A
UNION ALL
SELECT V.user_id, V.updated_at, V.operation
FROM video_upd AS V
UNION ALL
SELECT L.user_id, L.updated_at, L.operation
FROM link_upd AS L
GO
