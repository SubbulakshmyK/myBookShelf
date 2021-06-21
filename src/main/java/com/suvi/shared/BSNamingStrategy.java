package com.suvi.shared;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class BSNamingStrategy extends org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl {
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		
		return new Identifier("BS_" + name.getText(), name.isQuoted());
		
	}
}