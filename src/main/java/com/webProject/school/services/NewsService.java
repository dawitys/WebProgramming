package com.webProject.school.services;

import java.util.Optional;

import com.webProject.school.domains.News;

public interface NewsService {

	public News save(News News);
	
	public Iterable<News> saveAll(Iterable<News> Newss);

	Optional<News> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<News> findAll();

	Iterable<News> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(News news);
	
	void deleteAll(Iterable<News> newss);

	void deleteAll();
}
