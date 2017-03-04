package org.easyworld;

import java.util.List;

public class PackageGroup {
	public String name;
	public List<Package> list;

	public PackageGroup(String name, List<Package> list) {
		this.name = name;
		this.list = list;
	}
}
