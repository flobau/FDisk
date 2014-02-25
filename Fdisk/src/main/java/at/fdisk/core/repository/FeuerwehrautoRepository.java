package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import at.fdisk.core.domain.Feuerwehrauto;

@RestResource(path="/feuerwehrautos")
public interface FeuerwehrautoRepository extends FeuerwehrautoRepositoryCustom,
		CrudRepository<Feuerwehrauto, Long> {

	List<Feuerwehrauto> findAll();

	Feuerwehrauto findById(Long id);
}