package at.fdisk.core.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePersistable implements Serializable {
	private static final long serialVersionUID = 4209931258096103397L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	public Long getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		return (getId() != null) ? getId().hashCode() : System
				.identityHashCode(this);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this) {
			return true;
		}
		if (!this.getClass().equals(o.getClass())) {
			return false;
		}
		BasePersistable other = (BasePersistable) o;
		if (this.getId() == null && other.getId() != null) {
				return false;
		}
		return this.getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[Id=" + getId() + "]";
	}
}
