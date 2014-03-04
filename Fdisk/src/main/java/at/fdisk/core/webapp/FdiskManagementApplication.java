package at.fdisk.core.webapp;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class FdiskManagementApplication extends WebApplication {
	@Override
    public Class<? extends Page> getHomePage() {
        return HelloWorldPage.class;
    }
}
