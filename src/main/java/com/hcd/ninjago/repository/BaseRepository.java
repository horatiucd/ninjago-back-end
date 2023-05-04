package com.hcd.ninjago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, U> extends JpaRepository<T, U>, QuerydslPredicateExecutor<T> {

}
