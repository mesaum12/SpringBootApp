package net.javaguides.sms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.sms.entity.Apparel;

public interface ApparelRepository extends JpaRepository<Apparel, Long>{

	@Query("select u from Apparel u where u.gender='male'")
	List<Apparel> findAllNewArrivals();
	
	@Query("select u from Apparel u where u.firstName like %:keyword%")
	List<Apparel> findByKeyword(@Param("keyword") String keyword);
}
	
