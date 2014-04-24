package at.fdisk.core.webapp.mitglied;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class MitgliedPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new MitgliedPanel("mitgliedPanel");
    }
}