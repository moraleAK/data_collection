package com.el.dc.api.database.dialect;


public class MySQL5InnoDBDialect extends org.hibernate.dialect.MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=UTF8";
    }
}
