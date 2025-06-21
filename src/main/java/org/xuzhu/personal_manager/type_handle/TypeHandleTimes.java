package org.xuzhu.personal_manager.type_handle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.xuzhu.personal_manager.pojo.Time;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Time[].class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class TypeHandleTimes extends BaseTypeHandler<Time[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Time[] parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder value = new StringBuilder();
        for(Time time : parameter){
            value.append(time.toString()).append("|");
        }
        if(parameter.length > 0) {value.deleteCharAt(value.length() - 1);}
        ps.setString(i, value.toString());
    }

    @Override
    public Time[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parse(rs.getString(columnName));
    }

    @Override
    public Time[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parse(rs.getString(columnIndex));
    }

    @Override
    public Time[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parse(cs.getString(columnIndex));
    }

    private Time[] parse(String dbValue) {
        if (dbValue == null) return null;
        String[] parts = dbValue.split("\\|");
        Time[] times = new Time[parts.length];
        for (int i = 0; i < parts.length; i++) {
            Time time = new Time(parts[i]);
            times[i] = time;
        }
        return times;
    }
}
