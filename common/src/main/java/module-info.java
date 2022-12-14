module de.ruu.lab.modules.common
{
	requires jakarta.cdi;
	requires jakarta.el;
	requires jakarta.inject;
	requires jakarta.persistence;

	requires static lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;

	exports de.ruu.lab.modules.common;
//	exports de.ruu.lab.modules.common.internal to org.hibernate.orm.core;
	exports de.ruu.lab.modules.common.internal;

	// TODO check if this is necessary for cdi
	opens de.ruu.lab.modules.common;
	// TODO check if this is necessary for jpa
//	opens de.ruu.lab.modules.common.internal to org.hibernate.orm.core;
	opens de.ruu.lab.modules.common.internal;
}