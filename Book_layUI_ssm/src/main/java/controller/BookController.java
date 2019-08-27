package controller;

import java.io.File;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import model.Book;
import model.Type;
import service.BookService;
import service.TypeService;
import utils.ReturnInfo;

@Controller
public class BookController {
	
	@Autowired
	BookService bService;
	
	@Autowired
	TypeService tService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where book.name like '%"+txt+"%'";
		return bService.select(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody Book select(int id) {
		return bService.selectByid(id);
	}
	
	@RequestMapping("getStates")
	public @ResponseBody String[] getStates() {
		return Book.states;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody List<Type> getTypes() {
		return tService.select();
	}
	
	@RequestMapping("delete")
	public @ResponseBody String  delete(Book b) {
		bService.delete(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("insert")
	public @ResponseBody String  insert(Book b) {
		bService.insert(b);
		return "{\"status\":1}";
	}
	
	@RequestMapping("update")
	public @ResponseBody String update(Book b) {
		bService.update(b);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
	String oname=file.getOriginalFilename();
	String ex=oname.substring(oname.lastIndexOf("."),oname.length());
	String nname = UUID.randomUUID()+ex;

	String path=req.getSession().getServletContext().getRealPath("/");
	path=new File(path).getParentFile().getPath()+"/upload";
	System.out.println(path);
	file.transferTo(new File(path,nname));
	return  "/upload/"+nname;
	}
	
	@RequestMapping("sadas")
	public @ResponseBody String sase(Book b) {
		bService.sase(b);
		return "{\"status\":1}";
	}
	
	
}
