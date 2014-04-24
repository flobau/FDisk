package at.fdisk.core.webapp.geraet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import at.fdisk.core.domain.Geraet;

public class GeraetDB {
	private final Map<Long, Geraet> map = Collections
			.synchronizedMap(new HashMap<Long, Geraet>());
	private final List<Geraet> typIdx = Collections
			.synchronizedList(new ArrayList<Geraet>());
	private final List<Geraet> typDescIdx = Collections
			.synchronizedList(new ArrayList<Geraet>());

	
	public GeraetDB() {
		updateIndecies();
	}

	public Geraet get(long id) {
		Geraet a = map.get(id);
		if (a == null) {
			throw new RuntimeException("aubildung with id [" + id
					+ "] not found in the database, but size is [" + getCount()
					+ "]");
		}
		return a;
	}

	protected void add(final Geraet ausbildung) {
		map.put((long) ausbildung.getKey(), ausbildung);
		typIdx.add(ausbildung);
		typDescIdx.add(ausbildung);
	}

	public List<Geraet> find(long first, long count, SortParam sort) {
		return getIndex(sort).subList((int) first, (int) (first + count));
	}

	protected List<Geraet> getIndex(SortParam sort) {
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

	public void save(final Geraet ausbildung) {
		if (ausbildung.getKey() == 0) {
			ausbildung.setKey(map.size() + 1);
			add(ausbildung);
			updateIndecies();
		} else {
			throw new IllegalArgumentException("contact ["
					+ ausbildung.getBezeichnung() + "] is already persistent");
		}
	}

	public void delete(final Geraet ausbildung) {
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
		Collections.sort(typIdx, new Comparator<Geraet>() {
			public int compare(Geraet arg0, Geraet arg1) {
				return (arg0).getBezeichnung().compareTo(
						(arg1).getBezeichnung());
			}
		});

		Collections.sort(typDescIdx, new Comparator<Geraet>() {
			public int compare(Geraet arg0, Geraet arg1) {
				return (arg1).getBezeichnung().compareTo(
						(arg0).getBezeichnung());
			}
		});
	}
}