package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Apparel;
import net.javaguides.sms.repository.ApparelRepository;
import net.javaguides.sms.service.ApparelService;

@Service
public class ApparelServiceImpl implements ApparelService{

	private ApparelRepository apparelRepository;
	
	public ApparelServiceImpl(ApparelRepository apparelRepository) {
		super();
		this.apparelRepository = apparelRepository;
	}

	@Override
	public List<Apparel> getAllApparels() {
		return apparelRepository.findAll();
	}

	@Override
	public Apparel saveApparel(Apparel apparel) {
		return apparelRepository.save(apparel);
	}

	@Override
	public Apparel getApparelById(Long id) {
		return apparelRepository.findById(id).get();
	}

	@Override
	public Apparel updateApparel(Apparel apparel) {
		return apparelRepository.save(apparel);
	}

	@Override
	public void deleteApparelById(Long id) {
		apparelRepository.deleteById(id);	
	}

	@Override
	public List<Apparel> getAllNewArrivals()
	{
		return apparelRepository.findAllNewArrivals();
	}
	@Override
	public List<Apparel> getApparelsByKeyword(String keyword){
		  return apparelRepository.findByKeyword(keyword);
	}
}
