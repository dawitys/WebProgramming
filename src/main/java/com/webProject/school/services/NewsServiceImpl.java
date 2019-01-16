package com.webProject.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.school.domains.News;
import com.webProject.school.repositories.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {
	
	NewsRepository NewsRepository;
	
	@Autowired
	public NewsServiceImpl(NewsRepository NewsRepository) {
		this.NewsRepository = NewsRepository;
	}

	@Override
	public News save(News news) {
		return NewsRepository.save(news);
	}

	@Override
	public Iterable<News> saveAll(Iterable<News> newss) {
		return NewsRepository.saveAll(newss);
	}

	@Override
	public Optional<News> findById(Long id) {
		return NewsRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return NewsRepository.existsById(id);
	}

	@Override
	public Iterable<News> findAll() {
		return NewsRepository.findAll();
	}

	@Override
	public Iterable<News> findAllById(Iterable<Long> ids) {
		return NewsRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return NewsRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		NewsRepository.deleteById(id);
	}

	@Override
	public void delete(News news) {
		NewsRepository.delete(news);
	}

	@Override
	public void deleteAll(Iterable<News> newss) {
		NewsRepository.deleteAll(newss);

	}

	@Override
	public void deleteAll() {
		NewsRepository.deleteAll();
	}

}
