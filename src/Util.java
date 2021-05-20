import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.cfl.model.Utilisateur;

public class Util {

	public static boolean isLoggedAdmin(HttpSession session) {
		
		Object userObject = session.getAttribute("user");
		if(userObject == null) {
			return false;
		}
		
		Utilisateur user = (Utilisateur)userObject;
		
		return user.getIsAdmin();
	}
	
	
	public static Date parseHTMLDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = null;
		try {
			parsed = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parsed;
	}
}