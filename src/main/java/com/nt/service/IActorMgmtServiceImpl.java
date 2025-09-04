package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.ActorEntity;
import com.nt.repository.IActorRepository;
import com.nt.vo.ActorVO;

@Service
public class IActorMgmtServiceImpl implements IActorMgmtService{

	@Autowired
	private IActorRepository actorRepo;
	
	
//	@Override
//	public List<ActorVO> showAllActors() {
//		System.out.println("IActorMgmtServiceImpl.showAllActors()");
// 		Iterable<ActorEntity> listEntities  = actorRepo.findAll();
// 		
// 		//convert listEntities to listVO
// 		List<ActorVO> listVO = new ArrayList<>();
// 		
// 		listEntities.forEach(entity -> {
// 			ActorVO vo = new ActorVO();
// 			BeanUtils.copyProperties(entity, vo);
// 			listVO.add(vo);
// 		});
//		return listVO;
//	}


	@Override
	public String registerActors(ActorEntity actor) {
		System.out.println("IActorMgmtServiceImpl.registerActors()");
		ActorEntity savedActor = actorRepo.save(actor);
		return "Actor '" + savedActor.getAname() + "' registered successfully with ID: " + savedActor.getAid();

	}

	
//Edit operation.....
	@Override
	public ActorVO getActorById(Integer id) {
		System.out.println("IActorMgmtServiceImpl.getActorById()");
	    ActorEntity actorEntity = actorRepo.findById(id)
	                                  .orElseThrow(() -> new IllegalArgumentException("Actor not found with ID: " + id));

	    ActorVO vo = new ActorVO();
	    BeanUtils.copyProperties(actorEntity, vo);
	    return vo;
	}


	
	@Override
	public String UpdateActor(ActorEntity updatedActor) {
		System.out.println("IActorMgmtServiceImpl.UpdateActor()");
	    ActorEntity existingActor = actorRepo.findById(updatedActor.getAid())
	            .orElseThrow(() -> new IllegalArgumentException(
	                    "Actor not found with ID: " + updatedActor.getAid()));

	    existingActor.setAname(updatedActor.getAname());
	    existingActor.setAddrs(updatedActor.getAddrs());
	    existingActor.setCategory(updatedActor.getCategory());
	    existingActor.setFee(updatedActor.getFee());

	    ActorEntity savedActor = actorRepo.save(existingActor);
	    return "Actor '" + savedActor.getAname() + 
	           "' updated successfully with ID: " + savedActor.getAid();
	}


	
//delete Operation..........
	@Override
	public String deleteActorById(Integer id) {
		System.out.println("IActorMgmtServiceImpl.deleteActorById()");
		actorRepo.deleteById(id);
		return id+" actor id actor is deleted successfully";
	}

	//Pagination to show data........
	@Override
	public Page<ActorVO> getActorReportDataByPage(Pageable pageable) {
	    Page<ActorEntity>  svo = actorRepo.findAll(pageable);
	        return svo.map(entity -> {
	            ActorVO vo = new ActorVO();
	            BeanUtils.copyProperties(entity, vo);
	            return vo;
	        });
	}


	@Override
	public Page<ActorVO> searchByName(String name, Pageable pageable) {
	    // Use the new paginated repository method
	    Page<ActorEntity> pageEntities = actorRepo.findAllByAnameContainingIgnoreCase(name.trim(), pageable);
	    
	    // Convert Page<ActorEntity> to Page<ActorVO>
	    return pageEntities.map(entity -> {
	        ActorVO vo = new ActorVO();
	        BeanUtils.copyProperties(entity, vo);
	        return vo;
	    });
	}



}
