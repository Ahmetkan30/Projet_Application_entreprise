package model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommercantRepertoire extends CrudRepository<Commercant, Long>{
	
	List<Commercant> findAll();
}
