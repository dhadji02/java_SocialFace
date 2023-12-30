import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.ParseException;

public class ImportDatabase {
	public void read(String filename, MainClass conn) throws FileNotFoundException, ParseException {
		Scanner scan =new Scanner (new FileInputStream(filename));
			Insert ins = new Insert();
			InsertB ins2=new InsertB();
			switch (filename) {
			case "Albums.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins.insertAlbumMethod(table[1], table[2], table[3], 0,Integer.parseInt(table[5]), Integer.parseInt(table[6]), Integer.parseInt(table[7]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Album_Comment.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertAlbumComMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]), table[2], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "City.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertCityMethod(table[1], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Education.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertEducationMethod(table[1], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Friend.txt": {
				String line = scan.nextLine();
				String table[];
				UpdatesQry updates =new UpdatesQry();
				while (scan.hasNextLine()) {
					table = line.split("	");
					updates.updateFriend(Integer.parseInt(table[0]), Integer.parseInt(table[2]), Integer.parseInt(table[3]), Integer.parseInt(table[1]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Happening.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins.insertHappeningMethod(table[1], table[2], table[3], table[4], Integer.parseInt(table[5]), table[6], Integer.parseInt(table[7]), Integer.parseInt(table[8]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Interest.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertInterestMethod(table[1], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Interested_In.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertInterestedInMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]),conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Link.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins.insertLinkMethod(table[1], table[2], table[3], table[4], table[5], Integer.parseInt(table[6]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Participate.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins.insertParticipateMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Photo.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins.insertPhotoMethod(table[1], table[2], Integer.parseInt(table[3]), Integer.parseInt(table[4]), Integer.parseInt(table[5]),Integer.parseInt(table[6]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Photo_Likes.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertPhotoLikesMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Quote.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertQuoteMethod(table[1], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Said.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertSaidMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]),  conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Study.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertStudyMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "User_Profile.txt": {
				String line = scan.nextLine();
				String table[] = null;
				while (scan.hasNextLine()) {
					table = line.split("	");
					//java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(table[4]);
					//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					ins.insertUserMethod(table[1], table[2],table[3], table[4], table[5], Boolean.parseBoolean(table[6]),table[7],table[8], Boolean.parseBoolean(table[9]), Integer.parseInt(table[10]),Integer.parseInt(table[11]),table[12],table[13], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Video.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins.insertVideoMethod(table[1], table[2],Integer.parseInt(table[3]), Integer.parseInt(table[4]), conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Video_Comment.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertVideoComMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]), table[2], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Workplace.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertWorkplaceMethod(table[1], conn);
					line = scan.nextLine();
				}
				break;
			}
			case "Work_At.txt": {
				String line = scan.nextLine();
				String table[];
				while (scan.hasNextLine()) {
					table = line.split("	");
					ins2.insertWorksAtMethod(Integer.parseInt(table[0]), Integer.parseInt(table[1]), conn);
					line = scan.nextLine();
				}
				break;
			}
			}
			scan.close();
	}
}
