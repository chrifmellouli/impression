package com.plateform.impression.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.plateform.impression.model.GroupeMatiere;
import com.plateform.impression.model.GroupeMatierePK;

public interface GroupeMatiereDao extends JpaRepository<GroupeMatiere, GroupeMatierePK> {
	Optional<GroupeMatiere> findById(GroupeMatierePK id);
	@Query("select m from GroupeMatiere m where m.groupeMatierePK.groupe.idGroupe = ?1")
	List<GroupeMatiere> findByIdGroupe(int id);
}
