package com.nt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.ActorEntity;


@Repository
public interface IActorRepository extends JpaRepository<ActorEntity, Integer> {
	 
	Page<ActorEntity> findAllByAnameContainingIgnoreCase(String aname, Pageable pageable);}


