package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import model.Type;
import service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeDao dao;
	public List<Type> select() {
		return  dao.select() ;
	}

}
