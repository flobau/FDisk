package at.fdisk.core.webapp.ausbildung;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class AusbildungPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new AusbildungPanel("ausbildungPanel");
    }
}