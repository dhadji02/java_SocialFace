USE [dhadji02]
GO
/****** Object:  UserDefinedFunction [dhadji02].[GetCircleOfFriends]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dhadji02].[GetCircleOfFriends](@source int) RETURNS @friendlist TABLE
(
	Circle int NOT NULL
)
AS 
BEGIN
	INSERT INTO @friendlist
	SELECT	
		(CASE 
			WHEN F.receiver_id = @source THEN F.sender_id
			WHEN F.sender_id = @source THEN F.receiver_id
		END) AS COL
	FROM	Friend AS F
	WHERE	F.pending = 0 AND F.ignore = 0 AND (F.receiver_id = @source OR F.sender_id = @source)
	UNION
	SELECT @source AS COL
	--FROM	Friend AS F
	RETURN;
END

GO
/****** Object:  UserDefinedFunction [dhadji02].[GetFriends]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dhadji02].[GetFriends](@source int) RETURNS @friendlist TABLE
(
Sourceuser int NOT NULL,
Closefriend int NOT NULL
)
AS
BEGIN
INSERT INTO @friendlist
SELECT @source AS COL1,
(CASE
WHEN F.receiver_id = @source THEN F.sender_id
WHEN F.sender_id = @source THEN F.receiver_id
END) AS COL2
FROM Friend AS F
WHERE F.pending = 0 AND F.ignore = 0 AND (F.receiver_id = @source OR F.sender_id = @source)
RETURN;
END
GO
/****** Object:  UserDefinedFunction [dhadji02].[GetInterests]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE FUNCTION [dhadji02].[GetInterests](@source int) RETURNS @friendlist TABLE
(
	Sourceuser int NOT NULL,
	Interest int NOT NULL
)
AS 
BEGIN
	INSERT INTO @friendlist
	SELECT	@source AS COL1,II.interest_id AS COL2
	FROM	Interested_In AS II
	WHERE	II.user_profile_id = @source
	RETURN;
END

GO
/****** Object:  UserDefinedFunction [dhadji02].[GetLevel3friends]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




CREATE FUNCTION [dhadji02].[GetLevel3friends] (@source INT) RETURNS @friendlist TABLE
(	
	level3Friends int NOT NULL
)
AS 
BEGIN
	INSERT INTO @friendlist

	SELECT	DISTINCT GL.Hasfriends
	FROM	(GetFriends(@source) AS GF JOIN GetList() AS GL ON GL.Sourceuser=GF.Closefriend)
	WHERE	@source!=GL.Hasfriends
UNION
	SELECT	DISTINCT GL2.Hasfriends
	FROM	(GetFriends(@source) AS GF JOIN GetList() AS GL ON GL.Sourceuser=GF.Closefriend) JOIN GetList() AS GL2 ON GL2.Sourceuser=GL.Hasfriends
	WHERE	@source!=GL.Hasfriends AND GL2.Hasfriends != GF.Closefriend


	RETURN;
END

GO
/****** Object:  UserDefinedFunction [dhadji02].[GetList]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dhadji02].[GetList]() RETURNS @friendlist TABLE
(
Sourceuser int NOT NULL,
Hasfriends int NOT NULL
)
AS
BEGIN
INSERT INTO @friendlist
SELECT F.receiver_id, F.sender_id
FROM Friend AS F
WHERE F.pending = 0 AND F.ignore = 0
UNION
SELECT F.sender_id, F.receiver_id
FROM Friend AS F
WHERE F.pending = 0 AND F.ignore = 0
RETURN;
END
GO
/****** Object:  UserDefinedFunction [dhadji02].[GetListOfFriends]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dhadji02].[GetListOfFriends]() RETURNS @friendlist TABLE
(	
	Sourceuser int NOT NULL,
	Closefriend int NOT NULL
)
AS 
BEGIN
	INSERT INTO @friendlist

	SELECT	F.receiver_id, F.sender_id
	FROM	Friend AS F
	WHERE	F.pending = 0 AND F.ignore = 0

	UNION

	SELECT	F.sender_id, F.receiver_id
	FROM	Friend AS F
	WHERE	F.pending = 0 AND F.ignore = 0 

	RETURN;
END
GO
/****** Object:  UserDefinedFunction [dhadji02].[inpEducation]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--evresi ton user me kina xaraktiristika (DESC)
CREATE FUNCTION [dhadji02].[inpEducation] (@user INT)
RETURNS TABLE
AS
RETURN
SELECT	S.education_id,S.user_profile_id 
FROM	Study AS S
WHERE	S.user_profile_id = @user;

GO
/****** Object:  UserDefinedFunction [dhadji02].[inpWorkplace]    Script Date: 06/12/2020 22:34:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--evresi ton user me kina xaraktiristika (DESC) works at
CREATE FUNCTION [dhadji02].[inpWorkplace] (@user INT)
RETURNS TABLE
AS
RETURN
SELECT	W.workplace_id,W.user_profile_id
FROM	Works_At AS W
WHERE	W.user_profile_id = @user;

GO
