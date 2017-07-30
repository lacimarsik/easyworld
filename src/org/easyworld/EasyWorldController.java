package org.easyworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class EasyWorldController {
	@FXML
	private Button showWorld;

	@FXML
	private TextArea textArea;

	PackageSystem system;

	@FXML
	void showWorld(ActionEvent event) {
		textArea.setText("");
		system = new PackageSystem();

		List<Package> appAdminList = new ArrayList<Package>();
		appAdminList.add(new Package(
			"logrotate",
			"Allows automatic rotation, compression, removal, and mailing of log files. Run as a daily cron job.",
			"http://www.linuxcommand.org/man_pages/logrotate8.html"
		));
		appAdminList.add(new Package(
			"sudo",
			"Allows sudoing",
			""
		));
		appAdminList.add(new Package(
			"syslong-ng",
			"Open Source log management solution",
			"https://syslog-ng.org/"
		));
		appAdminList.add(new Package(
			"python-ly",
			"(1-time fix) Required to run frescobaldi",
			""
		));
		appAdminList.add(new Package(
			"python-poppler-qt4",
			"(1-time fix) Required to run frescobaldi",
			""
		));
		appAdminList.add(new Package(
			"=db-4.8.30-r2",
			"(1-time fix) Required to run apache-2.4.27:2",
			""
		));
		system.list.add(new PackageGroup("app-admin", appAdminList));

		for (PackageGroup group : system.list) {
			String formatGroup = "";
			formatGroup += "GROUP: " + group.name + "\n===\n";
			textArea.setText(textArea.getText() + formatGroup);
			for (Package pack : group.list) {
				String formatPackage = "\n";
				formatPackage += pack.name + "\n---\n";
				formatPackage += pack.description + "\n";
				if (pack.website != "") {
					formatPackage += "website: " + pack.website + "\n";
				}
				formatPackage += "\n";
				textArea.setText(textArea.getText() + formatPackage);
			}
			textArea.setText(textArea.getText() + "\n\n");
		}
	}
}
