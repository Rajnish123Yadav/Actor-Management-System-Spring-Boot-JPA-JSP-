package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.ActorEntity;
import com.nt.vo.ActorVO;

public interface IActorMgmtService {

	//public List<ActorVO> showAllActors();
	
	public String registerActors(ActorEntity actor);
	
	public ActorVO getActorById(Integer id);
	
	public String UpdateActor(ActorEntity actor);
	
	public String deleteActorById(Integer id);
	
	public Page<ActorVO> getActorReportDataByPage(Pageable pageable);

	public Page<ActorVO> searchByName(String name, Pageable pageable);


}
