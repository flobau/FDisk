package at.fdisk.core.webapp.geraet;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class GeraetPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new GeraetPanel("geraetPanel");
    }
}