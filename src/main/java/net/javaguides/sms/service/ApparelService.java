package net.javaguides.sms.service;

import java.util.List;



import net.javaguides.sms.entity.Apparel;

public interface ApparelService {
	List<Apparel> getAllApparels();
	
	Apparel saveApparel(Apparel apparel);
	
	Apparel getApparelById(Long id);
	
	Apparel updateApparel(Apparel apparel);
	
	void deleteApparelById(Long id);
	
	List<Apparel> getAllNewArrivals();
	
	List<Apparel> getApparelsByKeyword(String keyword);
		
}

