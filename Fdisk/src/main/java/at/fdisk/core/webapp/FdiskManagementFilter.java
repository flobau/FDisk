package at.fdisk.core.webapp;

import org.apache.wicket.protocol.http.WicketFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(value = "/web/*", initParams = {
		@WebInitParam(name = "applicationClassName", value = "at.fdisk.core.webapp.FdiskManagementApplication"),
		@WebInitParam(name = "filterMappingUrlPattern", value = "/web/*") })
public class FdiskManagementFilter extends WicketFilter{

}
