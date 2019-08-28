package service;

import model.Book;
import utils.ReturnInfo;

public interface BookService {
	
	public ReturnInfo select(String where,Integer page,Integer max);
	
	public Book selectByid(int id);
	
	public int insert(Book b);
	
	public int update(Book b);
	
	public int delete(Book b);
	
}
