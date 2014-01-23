package at.fdisk.core.events.ausbildung;

import at.fdisk.core.events.DeleteEvent;

public class DeleteAusbildungEvent extends DeleteEvent{

	  private final String bezeichnung;

	  public DeleteAusbildungEvent(final String bezeichnung) {
	    this.bezeichnung = bezeichnung;
	  }

	  public String getBezeichnung() {
	    return bezeichnung;
	  }
}
