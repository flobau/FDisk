package at.fdisk.core.webapp.feuerwehrauto;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class FeuerwehrautoPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new FeuerwehrautoPanel("feuerwehrautoPanel");
    }
}