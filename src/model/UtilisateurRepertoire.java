package model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepertoire extends CrudRepository<Utilisateur, Long>{

	public List<Utilisateur> findByUsername(String username);
}