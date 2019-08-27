package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public interface BookDao {

	@Select("select count(1) from book inner join type on type.id=book.typeid ${where}")
	public int search(@Param(value = "where") String where);
	
	@Select("select book.*,type.name typename from book inner join type on type.id=book.typeid ${where} ${limit}")
	public List<Book> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into book(name,state,typeid) values(#{name},#{state},#{typeid})")
	public int insert(Book b);
	
	@Update("update book set name=#{name},state=#{state},typeid=#{typeid} where id=#{id}")
	public int update(Book b);
	
	@Delete("delete from book  where id=#{id}")
	public int delete(Book b);
}
