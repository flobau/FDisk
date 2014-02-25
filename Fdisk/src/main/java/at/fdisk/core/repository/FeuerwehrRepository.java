package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import at.fdisk.core.domain.Feuerwehr;

@RestResource(path="/feuerwehren")
public interface FeuerwehrRepository extends FeuerwehrRepositoryCustom,
		CrudRepository<Feuerwehr, Long> {

	public List<Feuerwehr> findAll();

	public Feuerwehr findById(Long id);

}