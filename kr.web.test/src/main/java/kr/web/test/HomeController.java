package kr.web.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/login/{num}", method = RequestMethod.GET)
	public String login(HttpServletRequest request, @PathVariable("num") String num) {
		HttpSession session = request.getSession();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		String[] array = new String[4];
		String[] sArray = (String[])session.getAttribute("id");
		if(session.getAttribute("id") != null) {
			for(int i=0; i<array.length; i++ ) {
				System.out.println("sArray " + i + sArray[i]);
				array[i] = sArray[i];
			}
		}
		if(num.equals("1")) {
			array[0] = "1";
		}
		if(num.equals("2")) {
			array[1] = "2";
		}
		if(num.equals("3")) {
			array[2] = "3";
		}
		if(num.equals("4")) {
			array[3] = "4";
		}
		
		System.out.println("size(): " + array.length);
		System.out.println("list: " + array[0]);
		for(int i=0; i<array.length; i++ ) {
			System.out.println("arrat " + i + array[i]);
		}
		if(session != null) {
			session.setAttribute("id", array);
		}
		if(session == null) {
			session = null;
		}
		System.out.println("session after: " + session);
		return "redirect: /test";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		System.out.println("invalidate session...");
		return "redirect: /test";
	}
}
