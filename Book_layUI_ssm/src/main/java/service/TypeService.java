package service;

import java.util.List;

import dao.TypeDao;
import model.Type;

public interface TypeService {

	public List<Type> select();
}
