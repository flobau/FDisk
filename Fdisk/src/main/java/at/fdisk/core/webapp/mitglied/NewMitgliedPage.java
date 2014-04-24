package at.fdisk.core.webapp.mitglied;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class NewMitgliedPage extends FdiskManagementPage{

	protected Component contentPanel() {
        return new NewMitgliedPanel("newGeraetPanel");
    }
}
