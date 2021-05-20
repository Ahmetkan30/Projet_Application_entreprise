package model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PanierRepertoire extends CrudRepository<Panier, Long>{

		List<Panier> findAll();
	}
