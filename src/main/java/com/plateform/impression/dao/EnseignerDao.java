package com.plateform.impression.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plateform.impression.model.Enseigner;
import com.plateform.impression.model.EnseignerPK;

@Repository
public interface EnseignerDao extends JpaRepository<Enseigner, EnseignerPK> {
	Optional<Enseigner> findById(EnseignerPK enseignerPK);
	
	@Query("select e from Enseigner e where e.enseignerPK.enseignant.idEnseignant = ?1")
	List<Enseigner> findByIdEnseignant(int id);
}
