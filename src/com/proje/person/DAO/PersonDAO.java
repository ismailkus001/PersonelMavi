package com.proje.person.DAO;

import java.util.List;

import com.proje.person.model.Person;

public interface PersonDAO {
	public int save(Person person);
	public int update(Person person);
	public Person get(Integer id );
	public int delete(Integer id);
	public List<Person> list();
	public Person Unget(String tc);

}
