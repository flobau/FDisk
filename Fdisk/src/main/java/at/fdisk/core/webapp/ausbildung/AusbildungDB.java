package at.fdisk.core.webapp.ausbildung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import at.fdisk.core.domain.Ausbildung;

public class AusbildungDB {

	private final Map<Long, Ausbildung> map = Collections
			.synchronizedMap(new HashMap<Long, Ausbildung>());
	private final List<Ausbildung> bezeichnungIdx = Collections
			.synchronizedList(new ArrayList<Ausbildung>());
	private final List<Ausbildung> bezeichnungDescIdx = Collections
			.synchronizedList(new ArrayList<Ausbildung>());

	/**
	 * Constructor
	 * 
	 * @param count
	 *            number of contacts to generate at startup
	 */
	public AusbildungDB() {
		add(new Ausbildung("Test", "T", new Date(), new Date(), 1));
		add(new Ausbildung("Test2", "T2", new Date(), new Date(), 2));
		updateIndecies();
	}

	/**
	 * find contact by id
	 * 
	 * @param id
	 * @return contact
	 */
	public Ausbildung get(long id) {
		Ausbildung a = map.get(id);
		if (a == null) {
			throw new RuntimeException("aubildung with id [" + id
					+ "] not found in the database, but size is [" + getCount() + "]");
		}
		return a;
	}

	protected void add(final Ausbildung ausbildung) {
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
	public List<Ausbildung> find(long first, long count, SortParam sort) {
		return getIndex(sort).subList((int) first, (int) (first + count));
	}

	protected List<Ausbildung> getIndex(SortParam sort) {
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
	public void save(final Ausbildung ausbildung) {
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
	public void delete(final Ausbildung ausbildung) {
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
		Collections.sort(bezeichnungIdx, new Comparator<Ausbildung>() {
			public int compare(Ausbildung arg0, Ausbildung arg1) {
				return (arg0).getBezeichnung().compareTo(
						(arg1).getBezeichnung());
			}
		});

		Collections.sort(bezeichnungDescIdx, new Comparator<Ausbildung>() {
			public int compare(Ausbildung arg0, Ausbildung arg1) {
				return (arg1).getBezeichnung().compareTo(
						(arg0).getBezeichnung());
			}
		});
	}

}
