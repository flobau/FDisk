package at.fdisk.core.webapp.playground;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;
import at.fdisk.core.webapp.FdiskManagementPage;
import at.fdisk.core.domain.Ausbildung;

public class TestPage extends FdiskManagementPage {
	
	private TestPanel testPanel;

	public TestPage() {
		super();

		final List<Ausbildung> ausbildungList = new ArrayList<Ausbildung>();
		ausbildungList.add(new Ausbildung("1", "a", new Date(), new Date()));
		ausbildungList.add(new Ausbildung("2", "b", new Date(), new Date()));
		ausbildungList.add(new Ausbildung("3", "c", new Date(), new Date()));

		final AjaxFallbackLink<Void> ajaxFallbackLink = new AjaxFallbackLink<Void>(
				"link") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				testPanel.setVisible(true);
				target.add(testPanel);
			}
		};
		ajaxFallbackLink.add(new Label("label", "Shwow All"));
		add(ajaxFallbackLink);

		LoadableDetachableModel<List<Ausbildung>> ausbildungListModel = new LoadableDetachableModel<List<Ausbildung>>(
				ausbildungList) {

			@Override
			protected List<Ausbildung> load() {
				return getObject();
			}

		};
		testPanel = new TestPanel("ausbildungList", ausbildungListModel);
		testPanel.setOutputMarkupPlaceholderTag(true);
		testPanel.setVisible(false);
		add(testPanel);
	}
}