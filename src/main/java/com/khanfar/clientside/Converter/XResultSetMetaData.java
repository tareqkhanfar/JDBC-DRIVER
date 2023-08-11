package com.khanfar.clientside.Converter;

import com.khanfar.clientside.Converter.MetaName;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class XResultSetMetaData implements ResultSetMetaData {
    private HashMap<MetaName, Object> metaNameObjectHashMap;



  public  XResultSetMetaData (HashMap<MetaName , Object> metaNameObjectHashMap) {
      this.metaNameObjectHashMap = metaNameObjectHashMap;
  }


    @Override
    public int getColumnCount() throws SQLException {
        return (Integer)metaNameObjectHashMap.get(MetaName.NUMBER_OF_COULMNS);
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        return 0;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        return false;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
      return null;
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        Set<String> strings = (Set<String>) metaNameObjectHashMap.get(MetaName.CLOULMNS_NAME);
        Object[] objects = strings.stream().toArray() ;
        return (String) objects[column];
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return null;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        String typeName = getColumnTypeName(column);

        switch (typeName) {
            case "java.lang.Integer": return java.sql.Types.INTEGER;
            case "java.lang.Long": return java.sql.Types.BIGINT;
            case "java.lang.Short": return java.sql.Types.SMALLINT;
            case "java.lang.Byte": return java.sql.Types.TINYINT;
            case "java.lang.Boolean": return java.sql.Types.BOOLEAN;
            case "java.lang.Float": return java.sql.Types.FLOAT;
            case "java.lang.Double": return java.sql.Types.DOUBLE;
            case "java.math.BigDecimal": return java.sql.Types.DECIMAL;
            case "java.lang.String": return java.sql.Types.VARCHAR;
            case "java.sql.Date": return java.sql.Types.DATE;
            case "java.sql.Time": return java.sql.Types.TIME;
            case "java.sql.Timestamp": return java.sql.Types.TIMESTAMP;
            case "[B": return java.sql.Types.BINARY;
            case "[Ljava.lang.Byte;": return java.sql.Types.VARBINARY;
            case "java.sql.Array": return java.sql.Types.ARRAY;
            case "java.sql.Blob": return java.sql.Types.BLOB;
            case "java.sql.Clob": return java.sql.Types.CLOB;
            case "java.sql.NClob": return java.sql.Types.NCLOB;
            case "java.sql.Ref": return java.sql.Types.REF;
            case "java.lang.Object": return java.sql.Types.JAVA_OBJECT;
            case "java.net.URL": return java.sql.Types.DATALINK;
            case "java.sql.RowId": return java.sql.Types.ROWID;
            default: throw new SQLException("Unknown type name: " + typeName);
        }
    }


    @Override
    public String getColumnTypeName(int column) throws SQLException {
       LinkedList<String> clmn_type  = (LinkedList<String>) metaNameObjectHashMap.get(MetaName.COLUMN_TYPE);
        return  clmn_type.get(column);
  }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
