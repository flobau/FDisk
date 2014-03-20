package at.fdisk.core.webapp.charge;

import at.fdisk.core.webapp.FdiskManagementPage;
import org.apache.wicket.Component;

public class ChargePage extends FdiskManagementPage {

    protected Component contentPanel() {
        return new ChargePanel("chargePanel");
    }
}