package at.fdisk.core.webapp.ausruestung;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class AusruestungPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new AusruestungPanel("ausruestungPanel");
    }
}