import java.sql.CallableStatement;
import java.sql.ResultSet;

public class InsertB {
	
	public void insertQuoteMethod(String inp,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertQuote (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1,inp);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertEducationMethod(String inp,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertEducation (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1,inp);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertInterestMethod(String inp,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertInterest (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1,inp);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertCityMethod(String inp,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertCity (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1,inp);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertWorkplaceMethod(String inp,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertWorkplace (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1,inp);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertStudyMethod(int inpedu,int inpuser,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertStudy (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpedu);
			cstmt.setInt(2,inpuser);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertInterestedInMethod(int inpint,int inpuser,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertInterestedIn (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpint);
			cstmt.setInt(2,inpuser);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertWorksAtMethod(int inpwrk,int inpuser,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertWorksAt (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpwrk);
			cstmt.setInt(2,inpuser);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertSaidMethod(int inpq,int inpuser,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertSaid (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpq);
			cstmt.setInt(2,inpuser);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertVideoComMethod(int inpid,int inpuser,String com,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertVideoCom (?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpid);
			cstmt.setInt(2,inpuser);
			cstmt.setString(3,com);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertAlbumComMethod(int inpid,int inpuser,String com,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertAlbumCom (?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpid);
			cstmt.setInt(2,inpuser);
			cstmt.setString(3,com);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertPhotoLikesMethod(int inpph,int inpuser,MainClass conn){
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertPhotoLikes (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,inpph);
			cstmt.execute();
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
