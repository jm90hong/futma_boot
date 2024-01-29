package com.futma.futma_boot.type_handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.futma.futma_boot.util.AESUtil;
 

 
/**
 * MyBatis Custom Type Handler for Cipher
 * 
 * @author Pure
 *
 */
public abstract class AbstractCipherTypeHandler implements TypeHandler<String> {
 
    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        // 암호화 여부 확인
        if(isCipher()){
            try {
				parameter = AESUtil.encrypt(parameter);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        ps.setString(i, parameter);
    }
 
    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
     */
    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        // 암호화 여부 확인
        if(isCipher()){
            value = decode(value);
        }
        return value;
    }
 
    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
     */
    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        // 암호화 여부 확인
        if(isCipher()){
            value = decode(value);
        }
        return value;
    }
 
    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
     */
    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        // 암호화 여부 확인
        if(isCipher()){
            value = decode(value);
        }
        return value;
    }
    
    /**
     * 암호화 여부
     * 
     * @return 암호화 여부
     */
    protected abstract boolean isCipher();
    
    /**
     * 암호화
     * 
     * @param value 변환 문자
     * @return 암호화된 문자
     */
    protected String encode(String value){
        try{
            value = AESUtil.encrypt(value);
        }catch(Exception e){}
        
        return value;
    }
    
    /**
     * 복호화
     * 
     * @param value 변환 문자
     * @return 복호화된 문자
     */
    protected String decode(String value){
        try{
            value = AESUtil.decrypt(value);
        }catch(Exception e){}
        
        return value;
    }
}
 

