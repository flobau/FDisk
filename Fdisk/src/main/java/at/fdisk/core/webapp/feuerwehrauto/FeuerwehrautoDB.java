package at.fdisk.core.webapp.feuerwehrauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import at.fdisk.core.domain.Feuerwehrauto;

public class FeuerwehrautoDB {
	private final Map<Long, Feuerwehrauto> map = Collections
			.synchronizedMap(new HashMap<Long, Feuerwehrauto>());
	private final List<Feuerwehrauto> typIdx = Collections
			.synchronizedList(new ArrayList<Feuerwehrauto>());
	private final List<Feuerwehrauto> typDescIdx = Collections
			.synchronizedList(new ArrayList<Feuerwehrauto>());

	
	public FeuerwehrautoDB() {
		updateIndecies();
	}

	public Feuerwehrauto get(long id) {
		Feuerwehrauto a = map.get(id);
		if (a == null) {
			throw new RuntimeException("aubildung with id [" + id
					+ "] not found in the database, but size is [" + getCount()
					+ "]");
		}
		return a;
	}

	protected void add(final Feuerwehrauto ausbildung) {
		map.put((long) ausbildung.getKey(), ausbildung);
		typIdx.add(ausbildung);
		typDescIdx.add(ausbildung);
	}

	public List<Feuerwehrauto> find(long first, long count, SortParam sort) {
		return getIndex(sort).subList((int) first, (int) (first + count));
	}

	protected List<Feuerwehrauto> getIndex(SortParam sort) {
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

	public void save(final Feuerwehrauto ausbildung) {
		if (ausbildung.getKey() == 0) {
			ausbildung.setKey(map.size() + 1);
			add(ausbildung);
			updateIndecies();
		} else {
			throw new IllegalArgumentException("contact ["
					+ ausbildung.getTyp() + "] is already persistent");
		}
	}

	public void delete(final Feuerwehrauto ausbildung) {
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
		Collections.sort(typIdx, new Comparator<Feuerwehrauto>() {
			public int compare(Feuerwehrauto arg0, Feuerwehrauto arg1) {
				return (arg0).getTyp().compareTo(
						(arg1).getTyp());
			}
		});

		Collections.sort(typDescIdx, new Comparator<Feuerwehrauto>() {
			public int compare(Feuerwehrauto arg0, Feuerwehrauto arg1) {
				return (arg1).getTyp().compareTo(
						(arg0).getTyp());
			}
		});
	}
}
