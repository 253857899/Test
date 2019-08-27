package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import model.Book;
import service.BookService;
import utils.ReturnInfo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;

	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage = page != null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where, ReturnInfo.getLimit(page, max)));
		if (canpage)
			info.setCount(dao.search(where));
		return info;
	}

	public Book selectByid(int id) {
		return (Book) dao.select("where book.id=" + id, "limit 1").get(0);
	}

	public int insert(Book b) {
		return dao.insert(b);
	}

	public int update(Book b) {
		return dao.update(b);
	}

	public int delete(Book b) {
		return dao.delete(b);
	}
}
