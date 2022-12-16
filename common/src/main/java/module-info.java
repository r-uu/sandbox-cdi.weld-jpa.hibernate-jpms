module de.ruu.lab.modules.common
{
	exports de.ruu.lab.modules.common;
	exports de.ruu.lab.modules.common.internal;
	opens   de.ruu.lab.modules.common;
	// TODO check if this is necessary for jpa
	opens de.ruu.lab.modules.common.internal;

	requires jakarta.persistence;

	requires lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
	requires weld.se.shaded;
//	requires jakarta.inject;
}