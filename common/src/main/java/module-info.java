module de.ruu.lab.modules.common
{
	exports de.ruu.lab.modules.common;
	exports de.ruu.lab.modules.common.internal;
	opens   de.ruu.lab.modules.common;

	requires jakarta.persistence;

	requires static lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
//	requires transitive weld.se.shaded;
	requires weld.se.shaded;

	// TODO check if this is necessary for jpa
//	opens de.ruu.lab.modules.common.internal to org.hibernate.orm.core;
	opens de.ruu.lab.modules.common.internal;
}