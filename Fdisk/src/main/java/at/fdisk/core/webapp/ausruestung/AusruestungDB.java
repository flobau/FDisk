package at.fdisk.core.webapp.ausruestung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import at.fdisk.core.domain.Ausruestung;

public class AusruestungDB {
	private final Map<Long, Ausruestung> map = Collections
			.synchronizedMap(new HashMap<Long, Ausruestung>());
	private final List<Ausruestung> bezeichnungIdx = Collections
			.synchronizedList(new ArrayList<Ausruestung>());
	private final List<Ausruestung> bezeichnungDescIdx = Collections
			.synchronizedList(new ArrayList<Ausruestung>());

	/**
	 * Constructor
	 * 
	 * @param count
	 *            number of contacts to generate at startup
	 */
	public AusruestungDB() {
		updateIndecies();
	}

	/**
	 * find contact by id
	 * 
	 * @param id
	 * @return contact
	 */
	public Ausruestung get(long id) {
		Ausruestung a = map.get(id);
		if (a == null) {
			throw new RuntimeException("aubildung with id [" + id
					+ "] not found in the database, but size is [" + getCount() + "]");
		}
		return a;
	}

	protected void add(final Ausruestung ausbildung) {
		map.put((long) ausbildung.getKey(), ausbildung);
		bezeichnungIdx.add(ausbildung);
		bezeichnungDescIdx.add(ausbildung);
	}

	/**
	 * select contacts and apply sort
	 * 
	 * @param first
	 * @param count
	 * @param sort
	 * @return list of contacts
	 */
	public List<Ausruestung> find(long first, long count, SortParam sort) {
		return getIndex(sort).subList((int) first, (int) (first + count));
	}

	protected List<Ausruestung> getIndex(SortParam sort) {
		if (sort == null) {
			return bezeichnungIdx;
		}

		if (sort.getProperty().equals("bezeichnung")) {
			return sort.isAscending() ? bezeichnungIdx : bezeichnungDescIdx;
		}
		throw new RuntimeException("unknown sort option [" + sort
				+ "]. valid fields: [firstName], [lastName]");
	}

	/**
	 * @return number of contacts in the database
	 */
	public int getCount() {
		return bezeichnungIdx.size();
	}

	/**
	 * add contact to the database
	 * 
	 * @param contact
	 */
	public void save(final Ausruestung ausbildung) {
		if (ausbildung.getKey() == 0) {
			ausbildung.setKey(map.size() + 1);
			add(ausbildung);
			updateIndecies();
		} else {
			throw new IllegalArgumentException("contact ["
					+ ausbildung.getBezeichnung() + "] is already persistent");
		}
	}

	/**
	 * delete contact from the database
	 * 
	 * @param contact
	 */
	public void delete(final Ausruestung ausbildung) {
		map.remove(ausbildung.getKey());

		for(int i = 0; i < bezeichnungIdx.size(); i++){
			if(bezeichnungIdx.get(i).getKey() == ausbildung.getKey()){
				bezeichnungIdx.remove(i);
			}
		}
		for(int i = 0; i < bezeichnungDescIdx.size(); i++){
			if(bezeichnungDescIdx.get(i).getKey() == ausbildung.getKey()){
				bezeichnungDescIdx.remove(i);
			}
		}
	}

	private void updateIndecies() {
		Collections.sort(bezeichnungIdx, new Comparator<Ausruestung>() {
			public int compare(Ausruestung arg0, Ausruestung arg1) {
				return (arg0).getBezeichnung().compareTo(
						(arg1).getBezeichnung());
			}
		});

		Collections.sort(bezeichnungDescIdx, new Comparator<Ausruestung>() {
			public int compare(Ausruestung arg0, Ausruestung arg1) {
				return (arg1).getBezeichnung().compareTo(
						(arg0).getBezeichnung());
			}
		});
	}
}
