package at.fdisk.core.webapp.feuerwehr;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class FeuerwehrPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new FeuerwehrPanel("feuerwehrPanel");
    }
}