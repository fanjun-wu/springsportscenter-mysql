package cloud.migration.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;




















import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cloud.migration.model.Hall;
import cloud.migration.service.HallService;







@Controller
@RequestMapping("/admin")
public class HallController  {
	
private static final Logger logger = LoggerFactory.getLogger(HallController.class);
	
	private HallService hallService;
	
	
	@RequestMapping(value="/hallList", method=RequestMethod.GET)
	public ModelAndView list() {
		
		System.out.println("Listing halls.");
		logger.info("Listing halls.");
		Collection<Hall> halls = hallService.getHalls();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("halls", halls);
		return new ModelAndView("hall/hallList", model);
	}
	
	
	
	
	

	@RequestMapping(value="/getHall", method=RequestMethod.GET)
	public ModelAndView fetchHall(@RequestParam("hallId") int hallId) {
		logger.info("Fetching hall " + hallId);
		Hall hall = hallService.getHall(hallId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("hall", hall);
		return new ModelAndView("hall/modifyHall", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteHall", method=RequestMethod.GET)
	public String deleteHall(@RequestParam("hallId") int hallId) {
		logger.info("Deleting hall " + hallId);
		hallService.deleteHall(hallId);
		return "redirect:hallList";
	}
	
	
	
	@RequestMapping(value="/newHall", method=RequestMethod.GET)
	public ModelAndView newHall() {
		logger.info("Create new hall instance");
		Hall hall = new Hall();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("hall", hall);
		return new ModelAndView("hall/newHall", model);
	}
	
	
	
	@RequestMapping(value="/saveHall", method=RequestMethod.POST)
	public String createHall(@ModelAttribute("hall") Hall hall,
			BindingResult result, Model model) {
		logger.info("Save hall instance");
		hallService.saveHall(hall);
		return "redirect:hallList";
	}
	
	@RequestMapping(value="/updateHall", method=RequestMethod.POST)
	public String updateHall(@ModelAttribute("hall") Hall hall,
			BindingResult result, Model model) {
		logger.info("Save hall instance");
		hallService.editHall(hall);
		return "redirect:hallList";
	}
	
	

	
	@Autowired
	public void setHallService(HallService hallService) {
		this.hallService = hallService;
	}

}
