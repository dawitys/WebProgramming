package com.webProject.school.repositories;

import org.springframework.data.repository.CrudRepository;

import com.webProject.school.domains.News;

public interface NewsRepository extends CrudRepository<News, Long> {
}
