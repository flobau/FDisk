package at.fdisk.core.webapp.mitglied;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import at.fdisk.core.domain.Mitglied;

public class MitgliedDB {
	private final Map<Long, Mitglied> map = Collections
			.synchronizedMap(new HashMap<Long, Mitglied>());
	private final List<Mitglied> typIdx = Collections
			.synchronizedList(new ArrayList<Mitglied>());
	private final List<Mitglied> typDescIdx = Collections
			.synchronizedList(new ArrayList<Mitglied>());

	
	public MitgliedDB() {
		updateIndecies();
	}

	public Mitglied get(long id) {
		Mitglied a = map.get(id);
		if (a == null) {
			throw new RuntimeException("aubildung with id [" + id
					+ "] not found in the database, but size is [" + getCount()
					+ "]");
		}
		return a;
	}

	protected void add(final Mitglied ausbildung) {
		map.put((long) ausbildung.getKey(), ausbildung);
		typIdx.add(ausbildung);
		typDescIdx.add(ausbildung);
	}

	public List<Mitglied> find(long first, long count, SortParam sort) {
		return getIndex(sort).subList((int) first, (int) (first + count));
	}

	protected List<Mitglied> getIndex(SortParam sort) {
		if (sort == null) {
			return typIdx;
		}

		if (sort.getProperty().equals("typ")) {
			return sort.isAscending() ? typIdx : typDescIdx;
		}
		throw new RuntimeException("unknown sort option [" + sort
				+ "]. valid fields: [firstName], [lastName]");
	}

	public int getCount() {
		return typIdx.size();
	}

	public void save(final Mitglied ausbildung) {
		if (ausbildung.getKey() == 0) {
			ausbildung.setKey(map.size() + 1);
			add(ausbildung);
			updateIndecies();
		} else {
			throw new IllegalArgumentException("contact ["
					+ ausbildung.getNachname() + "] is already persistent");
		}
	}

	public void delete(final Mitglied ausbildung) {
		map.remove(ausbildung.getKey());

		for (int i = 0; i < typIdx.size(); i++) {
			if (typIdx.get(i).getKey() == ausbildung.getKey()) {
				typIdx.remove(i);
			}
		}
		for (int i = 0; i < typDescIdx.size(); i++) {
			if (typDescIdx.get(i).getKey() == ausbildung.getKey()) {
				typDescIdx.remove(i);
			}
		}
	}

	private void updateIndecies() {
		Collections.sort(typIdx, new Comparator<Mitglied>() {
			public int compare(Mitglied arg0, Mitglied arg1) {
				return (arg0).getNachname().compareTo(
						(arg1).getNachname());
			}
		});

		Collections.sort(typDescIdx, new Comparator<Mitglied>() {
			public int compare(Mitglied arg0, Mitglied arg1) {
				return (arg1).getNachname().compareTo(
						(arg0).getNachname());
			}
		});
	}
}