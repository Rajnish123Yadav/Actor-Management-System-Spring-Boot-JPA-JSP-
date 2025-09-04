package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.ActorEntity;
import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;


@Controller
public class ActorOperationsController {

	private static final String ACTOR2 = "actor";
	
	@Autowired
	private IActorMgmtService actorService;
	
	@GetMapping("/") //for home page
	public String showHomepage(){
		System.out.println("ActorOperationsController.showHomepage()");
		return "home";
	}
	
	
//	@GetMapping("/report")
//	public String showReport(Map<String, Object> map) {
//		System.out.println("ActorOperationsController.showReport()");
//		//use service
//	    List<ActorVO> list = actorService.showAllActors();
//	  //keep the result in shares memory
//	    map.put("listVO", list);
//	  //return LVN
//	    return "show_report";
//	}

	@GetMapping("/report")
	public String showReport(@PageableDefault(page=0,size=3,sort="aid", direction=Sort.Direction.ASC) Pageable pageable,Map<String, Object> map) {
		System.out.println("ActorOperationsController.showReport()");
		//use service
	    Page<ActorVO> listVO = actorService.getActorReportDataByPage(pageable);
	    
	  //keep the result in shares memory
	    map.put("listVO", listVO);
	    map.put("content", listVO.getContent());
	    map.put("hasPrevious", listVO.hasPrevious());
	    map.put("hasNext", listVO.hasNext());
	    map.put("isFirst", listVO.isFirst());
	    map.put("isLast", listVO.isLast());
	    map.put("currentPage", listVO.getNumber());
	    map.put("totalPages", listVO.getTotalPages());
	    
	  //return LVN
	    return "show_report";
	}
	
	@GetMapping("/actor_register")//for form launching
	public String showFormForSaveEmployee(@ModelAttribute(ACTOR2)ActorEntity actor) {
		System.out.println("ActorOperationsController.showFormForSaveEmployee()");
		//return LVN
		return "register_actor";		
	}
	
	
	@PostMapping("/actor_register")
	public String saveEmployee(@ModelAttribute(ACTOR2)ActorEntity actor, RedirectAttributes attrs) {
		System.out.println("ActorOperationsController.saveEmployee()");
		// use service
		String msg = actorService.registerActors(actor);
		
	    // Add flash attribute (temporary data used after redirect)
	    attrs.addFlashAttribute("resultMsg",msg);
	    
	    //return LVN
		return "redirect:report";//R--Redirect
	}
	
	//Not a good practice here...
//	@PostMapping("/actor_register")
//	public String saveEmployee(@ModelAttribute("actor")ActorEntity actor, HttpSession ses) {
//		// use service
//		String msg = actorService.registerActors(actor);
//		
//	    ses.setAttribute("resultMsg", msg);
//	    
//	    //return LVN
//		return "redirect:report";//R--Redirect
//	}
	
	
	
	
	//For Edit operation............
	@GetMapping("/actor_edit")
	public String showEditActorFormPage(@RequestParam("no") Integer aid,
										@ModelAttribute(ACTOR2) ActorEntity actor) {
		System.out.println("ActorOperationsController.showEditActorFormPage()");
		//use service
		ActorVO actorvo = actorService.getActorById(aid);
		
		//copy data
		BeanUtils.copyProperties(actorvo, actor);
		
		return "update_actor";
	}
	
	@PostMapping("/actor_edit")
    public String editActor(RedirectAttributes attr, 
                            @ModelAttribute(ACTOR2) ActorEntity updatedActor) {
		System.out.println("ActorOperationsController.editActor()");
		
        String msg = actorService.UpdateActor(updatedActor); // service handles fetch + update
        
        attr.addFlashAttribute("resultMsg", msg);
        //return LVN
        return "redirect:report";
	}
	
	
	//delete operation...
	@GetMapping("/actor_delete")
	public String deleteActor(RedirectAttributes attrs, 
									@RequestParam("no") Integer aid) {
		System.out.println("ActorOperationsController.deleteActor()");
		//use Service
		String msg = actorService.deleteActorById(aid);
		
		//keep the result in FlashAttribute
		attrs.addFlashAttribute("resultMsg", msg);
		
		//redirect the request
		return "redirect:report";
	}
	
	
	
//	@GetMapping("/searchBy_Name")
//	public String searchByName(@RequestParam("name") String name, Model model) {
//	    try {
//	        ActorVO vo = actorService.getActorByName(name);
//	        model.addAttribute("content", List.of(vo)); // wrap single result as list
//	    } catch (IllegalArgumentException e) {
//	        model.addAttribute("content", List.of()); // empty list if not found
//	        model.addAttribute("resultMsg", "No actor found with name: " + name);
//	    }
//	    return "show_report"; // ✅ must match your report JSP
//	}


	@GetMapping("/searchBy_Name")
	public String searchByName(@RequestParam("name") String name,
	                           @PageableDefault(page=0,size=3,sort="aid") Pageable pageable,
	                           Model model) {
	    Page<ActorVO> page = actorService.searchByName(name, pageable);
	    model.addAttribute("content", page.getContent());
	    model.addAttribute("hasPrevious", page.hasPrevious());
	    model.addAttribute("hasNext", page.hasNext());
	    model.addAttribute("isFirst", page.isFirst());
	    model.addAttribute("isLast", page.isLast());
	    model.addAttribute("currentPage", page.getNumber());
	    model.addAttribute("totalPages", page.getTotalPages());
	    
	    //if (page.isEmpty()) model.addAttribute("resultMsg", "No actor found with name: " + name);
	    return "show_report";
	}


}
