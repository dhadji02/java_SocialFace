USE [dhadji02]
GO
/****** Object:  Table [dhadji02].[Album]    Script Date: 06/12/2020 22:29:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Album](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[album_name] [nvarchar](50) NOT NULL,
	[album_description] [nvarchar](500) NOT NULL,
	[album_url] [nvarchar](50) NOT NULL,
	[album_count] [int] NOT NULL,
	[privacy] [nvarchar](1) NOT NULL,
	[album_owner] [int] NOT NULL,
	[album_location] [int] NOT NULL,
 CONSTRAINT [PK_Album] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Album_Comment]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Album_Comment](
	[album_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
	[comment] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_PLalbum] PRIMARY KEY CLUSTERED 
(
	[album_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[album_upd]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[album_upd](
	[change_id] [int] IDENTITY(1,1) NOT NULL,
	[album_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[updated_at] [datetime] NOT NULL,
	[operation] [char](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[change_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[City]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[City](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[city_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_City] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Education]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Education](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[edu_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Education] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Friend]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Friend](
	[receiver_id] [int] NOT NULL,
	[sender_id] [int] NOT NULL,
	[pending] [bit] NULL,
	[ignore] [bit] NULL,
 CONSTRAINT [PK_Friend] PRIMARY KEY CLUSTERED 
(
	[receiver_id] ASC,
	[sender_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[hap_upd]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[hap_upd](
	[change_id] [int] IDENTITY(1,1) NOT NULL,
	[happening_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[updated_at] [datetime] NOT NULL,
	[operation] [char](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[change_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Happening]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Happening](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[hap_name] [nvarchar](50) NOT NULL,
	[hap_description] [nvarchar](500) NOT NULL,
	[start_time] [smalldatetime] NOT NULL,
	[end_time] [smalldatetime] NOT NULL,
	[privacy] [nvarchar](1) NOT NULL,
	[hap_city] [nvarchar](50) NOT NULL,
	[host] [int] NOT NULL,
	[hap_location] [int] NOT NULL,
 CONSTRAINT [PK_Happening] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Interest]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Interest](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[int_description] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Interest] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Interested_In]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Interested_In](
	[interest_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
 CONSTRAINT [PK_II] PRIMARY KEY CLUSTERED 
(
	[interest_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Link]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Link](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[link_name] [nvarchar](50) NOT NULL,
	[caption] [nvarchar](50) NOT NULL,
	[link_description] [nvarchar](500) NOT NULL,
	[link] [nvarchar](50) NOT NULL,
	[link_message] [nvarchar](50) NULL,
	[link_owner] [int] NOT NULL,
 CONSTRAINT [PK_Link] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[link_upd]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[link_upd](
	[change_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[link_id] [int] NOT NULL,
	[updated_at] [datetime] NOT NULL,
	[operation] [char](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[change_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Participate]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Participate](
	[event_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
 CONSTRAINT [PK_Participate] PRIMARY KEY CLUSTERED 
(
	[event_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Photo]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Photo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ph_source] [varchar](max) NOT NULL,
	[ph_url] [nvarchar](80) NOT NULL,
	[width] [real] NOT NULL,
	[height] [real] NOT NULL,
	[ph_owner] [int] NOT NULL,
	[album_id] [int] NULL,
 CONSTRAINT [PK_Photo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Photo_Likes]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Photo_Likes](
	[photo_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
 CONSTRAINT [PK_PL] PRIMARY KEY CLUSTERED 
(
	[photo_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[photo_upd]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[photo_upd](
	[change_id] [int] IDENTITY(1,1) NOT NULL,
	[photo_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[updated_at] [datetime] NOT NULL,
	[operation] [char](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[change_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Quote]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Quote](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[quote_name] [nvarchar](150) NOT NULL,
 CONSTRAINT [PK_Quote] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Said]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Said](
	[quote_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
 CONSTRAINT [PK_Said] PRIMARY KEY CLUSTERED 
(
	[quote_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Study]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Study](
	[education_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
 CONSTRAINT [PK_Study] PRIMARY KEY CLUSTERED 
(
	[education_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[User_Profile]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[User_Profile](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](100) NOT NULL,
	[first_name] [nvarchar](50) NOT NULL,
	[last_name] [nvarchar](50) NOT NULL,
	[birthday] [date] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[gender] [bit] NOT NULL,
	[user_website] [nvarchar](80) NOT NULL,
	[user_url] [nvarchar](80) NOT NULL,
	[verified] [bit] NOT NULL,
	[user_hometown] [int] NULL,
	[user_location] [int] NULL,
	[user_password] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_User_Profile] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Video]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Video](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[vid_message] [nvarchar](50) NOT NULL,
	[vid_description] [nvarchar](500) NOT NULL,
	[vid_length] [bigint] NOT NULL,
	[vid_owner] [int] NOT NULL,
 CONSTRAINT [PK_Video] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Video_Comment]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Video_Comment](
	[video_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
	[comment] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_VC] PRIMARY KEY CLUSTERED 
(
	[video_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[video_upd]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[video_upd](
	[change_id] [int] IDENTITY(1,1) NOT NULL,
	[video_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[updated_at] [datetime] NOT NULL,
	[operation] [char](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[change_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Workplace]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Workplace](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[workplace_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Workplace] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dhadji02].[Works_At]    Script Date: 06/12/2020 22:29:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dhadji02].[Works_At](
	[workplace_id] [int] NOT NULL,
	[user_profile_id] [int] NOT NULL,
 CONSTRAINT [PK_WA] PRIMARY KEY CLUSTERED 
(
	[workplace_id] ASC,
	[user_profile_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dhadji02].[Friend] ADD  DEFAULT ((1)) FOR [pending]
GO
ALTER TABLE [dhadji02].[Friend] ADD  DEFAULT ((0)) FOR [ignore]
GO
ALTER TABLE [dhadji02].[Album]  WITH CHECK ADD  CONSTRAINT [FK_Alocation] FOREIGN KEY([album_location])
REFERENCES [dhadji02].[City] ([id])
GO
ALTER TABLE [dhadji02].[Album] CHECK CONSTRAINT [FK_Alocation]
GO
ALTER TABLE [dhadji02].[Album]  WITH CHECK ADD  CONSTRAINT [FK_Aowner] FOREIGN KEY([album_owner])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Album] CHECK CONSTRAINT [FK_Aowner]
GO
ALTER TABLE [dhadji02].[Album_Comment]  WITH CHECK ADD  CONSTRAINT [FK_ACalbum] FOREIGN KEY([album_id])
REFERENCES [dhadji02].[Album] ([id])
GO
ALTER TABLE [dhadji02].[Album_Comment] CHECK CONSTRAINT [FK_ACalbum]
GO
ALTER TABLE [dhadji02].[Album_Comment]  WITH CHECK ADD  CONSTRAINT [FK_ACuser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Album_Comment] CHECK CONSTRAINT [FK_ACuser]
GO
ALTER TABLE [dhadji02].[Friend]  WITH CHECK ADD  CONSTRAINT [FK_Freceiver] FOREIGN KEY([receiver_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Friend] CHECK CONSTRAINT [FK_Freceiver]
GO
ALTER TABLE [dhadji02].[Friend]  WITH CHECK ADD  CONSTRAINT [FK_Fsender] FOREIGN KEY([sender_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Friend] CHECK CONSTRAINT [FK_Fsender]
GO
ALTER TABLE [dhadji02].[Happening]  WITH CHECK ADD  CONSTRAINT [FK_Hhost] FOREIGN KEY([host])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Happening] CHECK CONSTRAINT [FK_Hhost]
GO
ALTER TABLE [dhadji02].[Happening]  WITH CHECK ADD  CONSTRAINT [FK_Hlocation] FOREIGN KEY([hap_location])
REFERENCES [dhadji02].[City] ([id])
GO
ALTER TABLE [dhadji02].[Happening] CHECK CONSTRAINT [FK_Hlocation]
GO
ALTER TABLE [dhadji02].[Interested_In]  WITH CHECK ADD  CONSTRAINT [FK_IIinterested] FOREIGN KEY([interest_id])
REFERENCES [dhadji02].[Interest] ([id])
GO
ALTER TABLE [dhadji02].[Interested_In] CHECK CONSTRAINT [FK_IIinterested]
GO
ALTER TABLE [dhadji02].[Interested_In]  WITH CHECK ADD  CONSTRAINT [FK_IIuser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Interested_In] CHECK CONSTRAINT [FK_IIuser]
GO
ALTER TABLE [dhadji02].[Link]  WITH CHECK ADD  CONSTRAINT [FK_Lowner] FOREIGN KEY([link_owner])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Link] CHECK CONSTRAINT [FK_Lowner]
GO
ALTER TABLE [dhadji02].[Participate]  WITH CHECK ADD  CONSTRAINT [FK_Pevent] FOREIGN KEY([event_id])
REFERENCES [dhadji02].[Happening] ([id])
GO
ALTER TABLE [dhadji02].[Participate] CHECK CONSTRAINT [FK_Pevent]
GO
ALTER TABLE [dhadji02].[Participate]  WITH CHECK ADD  CONSTRAINT [FK_Puser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Participate] CHECK CONSTRAINT [FK_Puser]
GO
ALTER TABLE [dhadji02].[Photo]  WITH CHECK ADD  CONSTRAINT [FK_Palbum_id] FOREIGN KEY([album_id])
REFERENCES [dhadji02].[Album] ([id])
GO
ALTER TABLE [dhadji02].[Photo] CHECK CONSTRAINT [FK_Palbum_id]
GO
ALTER TABLE [dhadji02].[Photo]  WITH CHECK ADD  CONSTRAINT [FK_Powner] FOREIGN KEY([ph_owner])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Photo] CHECK CONSTRAINT [FK_Powner]
GO
ALTER TABLE [dhadji02].[Photo_Likes]  WITH CHECK ADD  CONSTRAINT [FK_PLphoto] FOREIGN KEY([photo_id])
REFERENCES [dhadji02].[Photo] ([id])
GO
ALTER TABLE [dhadji02].[Photo_Likes] CHECK CONSTRAINT [FK_PLphoto]
GO
ALTER TABLE [dhadji02].[Photo_Likes]  WITH CHECK ADD  CONSTRAINT [FK_PLuser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Photo_Likes] CHECK CONSTRAINT [FK_PLuser]
GO
ALTER TABLE [dhadji02].[Said]  WITH CHECK ADD  CONSTRAINT [FK_SSquote] FOREIGN KEY([quote_id])
REFERENCES [dhadji02].[Quote] ([id])
GO
ALTER TABLE [dhadji02].[Said] CHECK CONSTRAINT [FK_SSquote]
GO
ALTER TABLE [dhadji02].[Said]  WITH CHECK ADD  CONSTRAINT [FK_SSuser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Said] CHECK CONSTRAINT [FK_SSuser]
GO
ALTER TABLE [dhadji02].[Study]  WITH CHECK ADD  CONSTRAINT [FK_Seducation] FOREIGN KEY([education_id])
REFERENCES [dhadji02].[Education] ([id])
GO
ALTER TABLE [dhadji02].[Study] CHECK CONSTRAINT [FK_Seducation]
GO
ALTER TABLE [dhadji02].[Study]  WITH CHECK ADD  CONSTRAINT [FK_Suser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Study] CHECK CONSTRAINT [FK_Suser]
GO
ALTER TABLE [dhadji02].[User_Profile]  WITH CHECK ADD  CONSTRAINT [FK_UPHometown] FOREIGN KEY([user_hometown])
REFERENCES [dhadji02].[City] ([id])
GO
ALTER TABLE [dhadji02].[User_Profile] CHECK CONSTRAINT [FK_UPHometown]
GO
ALTER TABLE [dhadji02].[User_Profile]  WITH CHECK ADD  CONSTRAINT [FK_UPlocation] FOREIGN KEY([user_location])
REFERENCES [dhadji02].[City] ([id])
GO
ALTER TABLE [dhadji02].[User_Profile] CHECK CONSTRAINT [FK_UPlocation]
GO
ALTER TABLE [dhadji02].[Video]  WITH CHECK ADD  CONSTRAINT [FK_Vowner] FOREIGN KEY([vid_owner])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Video] CHECK CONSTRAINT [FK_Vowner]
GO
ALTER TABLE [dhadji02].[Video_Comment]  WITH CHECK ADD  CONSTRAINT [FK_VCuser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Video_Comment] CHECK CONSTRAINT [FK_VCuser]
GO
ALTER TABLE [dhadji02].[Video_Comment]  WITH CHECK ADD  CONSTRAINT [FK_VCvideo] FOREIGN KEY([video_id])
REFERENCES [dhadji02].[Video] ([id])
GO
ALTER TABLE [dhadji02].[Video_Comment] CHECK CONSTRAINT [FK_VCvideo]
GO
ALTER TABLE [dhadji02].[Works_At]  WITH CHECK ADD  CONSTRAINT [FK_WAuser] FOREIGN KEY([user_profile_id])
REFERENCES [dhadji02].[User_Profile] ([id])
GO
ALTER TABLE [dhadji02].[Works_At] CHECK CONSTRAINT [FK_WAuser]
GO
ALTER TABLE [dhadji02].[Works_At]  WITH CHECK ADD  CONSTRAINT [FK_WAworkplace] FOREIGN KEY([workplace_id])
REFERENCES [dhadji02].[Workplace] ([id])
GO
ALTER TABLE [dhadji02].[Works_At] CHECK CONSTRAINT [FK_WAworkplace]
GO
ALTER TABLE [dhadji02].[album_upd]  WITH CHECK ADD CHECK  (([operation]='INS' OR [operation]='DEL' OR [operation]='UP'))
GO
ALTER TABLE [dhadji02].[hap_upd]  WITH CHECK ADD CHECK  (([operation]='INS' OR [operation]='DEL' OR [operation]='UP'))
GO
ALTER TABLE [dhadji02].[link_upd]  WITH CHECK ADD CHECK  (([operation]='INS' OR [operation]='DEL' OR [operation]='UP'))
GO
ALTER TABLE [dhadji02].[photo_upd]  WITH CHECK ADD CHECK  (([operation]='INS' OR [operation]='DEL' OR [operation]='UP'))
GO
ALTER TABLE [dhadji02].[video_upd]  WITH CHECK ADD CHECK  (([operation]='INS' OR [operation]='DEL' OR [operation]='UP'))
GO
