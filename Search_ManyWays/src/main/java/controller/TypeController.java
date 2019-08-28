package controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;


import entity.Type;
import service.Type_Service;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	Type_Service service;
	

	
	
	@RequestMapping("index")
	public String   index(Integer opt,String txt,Integer status,Integer page,Integer limit,ModelMap m) {
		String txt1="";
		if(opt!=null&&opt==1)
			txt1=" where type.status ="+status;
		else
		if(txt!=null&&txt.length()>0) 
			txt1=" where type.name like '%"+txt+"%'";
		m.put("list",service.select(txt1,page,limit)) ;
		m.put("statuslist", Type.statuslist);
		m.put("opt", opt);
		m.put("txt", txt);
		m.put("status", status);
		return "Type/index";
	}
	
	
	@RequestMapping("insert")
	public String  insert(Type b,ModelMap m) {
		service.insert(b);
		return index(0, null, null, m);
	}
	private String index(int i, Object page, Object limit, ModelMap m) {
		// TODO Auto-generated method stub
		return null;
	}


	@RequestMapping("update")
	public   String  update(Type b,ModelMap m) {
		service.update(b);
		return index(0, null, null, m);
	}
	
	@RequestMapping("add")
	public  String  add(ModelMap m) {
		return "Type/index";
	}
	@RequestMapping("edit")
	public  String  edit(int id,ModelMap m) {
		m.put("info", service.selectById(id)) ;
		return add(m);
	}
	
	@RequestMapping("delete")
	public String  delete(int id,ModelMap m) {
		service.delete(id);
		return index(0, null, null, m);
	}
}
