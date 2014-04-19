package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausbildung;

public class ContentPanel extends Panel {
	
	public ContentPanel(String id) {
		super(id);
	}
	
	class ActionPanel extends Panel
	{
		public ActionPanel(String id, IModel<Ausbildung> model)
		{
			super(id, model);
		}
	}
}