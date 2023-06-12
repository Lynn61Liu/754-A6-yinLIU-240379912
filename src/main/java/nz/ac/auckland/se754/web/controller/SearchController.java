package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.factory.Course;
import nz.ac.auckland.se754.web.service.Database;
import nz.ac.auckland.se754.web.service.Login;
import nz.ac.auckland.se754.web.service.Questions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import nz.ac.auckland.se754.web.service.Filter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@SessionAttributes({"name", "keyword"})
public class SearchController {
	private ArrayList<Course> mockedCoursesList = new ArrayList<>();
	@Autowired
	Filter filterServer;

	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ModelAndView showSearchPage(ModelMap model){
		ArrayList<Course> filterCourse = new ArrayList<>();
		String p = (String) model.get("keyword");
		if(p != null && !p.equals("")){
			if(p.equals("sort")){
				filterCourse=filterServer.sortAllCourses();
			}
			else {
			filterCourse = filterServer.searchCoursesCategory(p);}
		}

		else{
			filterCourse = filterServer.getAllCourses();
		}
		ModelAndView modelAndView = new ModelAndView("/search");
		modelAndView.addObject("lists", filterCourse);
		return modelAndView;
	}


	@RequestMapping(value="/search", method = RequestMethod.POST)
	public ModelAndView showCategoryCourse(ModelMap model, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/search");
		ArrayList<Course> filterCourse= new ArrayList<>();
		String c=request.getParameter("category");
		String k=request.getParameter("keyword");
		String s=request.getParameter("sort");
		if (c != null && !c.isEmpty()) {
			model.put("keyword", c);
			filterCourse = filterServer.searchCoursesCategory(c);
		} else if (k != null && !k.isEmpty()) {
			model.put("keyword", s);
			filterCourse = filterServer.searchCourses(k);
		} else if (s != null && !s.isEmpty()) {
			model.put("keyword", s);
		}


		modelAndView.addObject("lists", filterCourse);
		return modelAndView;
	}




}
