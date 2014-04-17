package at.fdisk.core.webapp.ausbildung;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class NewAusbildungPage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new NewAusbildungPanel("newAusbildungPanel");
    }
}