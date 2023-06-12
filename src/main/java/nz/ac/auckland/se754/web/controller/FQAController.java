package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.FQAItem;
import nz.ac.auckland.se754.web.model.Item;

import nz.ac.auckland.se754.web.service.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("name")
public class FQAController {

	@Autowired
	Questions service;


	@RequestMapping(value="/FQA", method = RequestMethod.GET)
	public ModelAndView showFQAPage(ModelMap model){
		List<FQAItem> FQAList = new ArrayList<>();
		FQAList.add(new FQAItem(1, "What do courses include?", "Each course is created, owned and managed by the instructor(s). The foundation of each course are its lectures, which can include videos, slides, and text. In addition, instructors can add resources and various types of practice activities, as a way to enhance the learning experience of students."));
		FQAList.add(new FQAItem(2, "How to Search for Courses?", "we has an extensive, multi-language library, which includes thousands of courses that have been created by real-world experts. The courses range across a wide range of categories, some of these include: business & entrepreneurship, programming, academics, the arts, health & fitness, language, music, technology, games, and much more.\n" +
				"This article outlines how you can search  ever-growing library, and find courses you’re interested in taking.\n" +
				"\n" +
				"1. Using the Marketplace Search Tool\n" +
				"2.Searching by Category\n" +
				"3.Using the Search Tool Filters\n" +
				"\n" +
				"In addition,once you find a course you’re interested in, you can quickly let your friends, relatives or co-workers know about it by using the social media links on the course landing page."));
		FQAList.add(new FQAItem(3, " Where can I go for help?", "If you find you have a question about a paid course while you’re taking it, you can search for answers to your question in the Q&A or ask the instructor. \n" +
				"Our Help Center has extensive information regarding various features, and articles with troubleshooting steps to help you quickly resolve any issues you encounter. Our support team is also happy to help. "));

		ModelAndView map = new ModelAndView("/FQA");
		map.addObject("lists", FQAList);
		return map;
	}



}
