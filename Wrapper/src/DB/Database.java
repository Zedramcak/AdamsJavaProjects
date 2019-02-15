/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
/**
 *
 * @author Adam
 */
public class Database {
    
    protected Connection connection;
    
    protected Query query;
    
    
    public Database (String db,String userName, String password) throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db, userName,password);
    }
    
    private int query(String query, Object[] params) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(query);
        if (params != null){
            int index = 1;
            for (Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }
        return ps.executeUpdate();
    }
    
    public int delete(String table, String requirement, Object[] param) throws SQLException{
        query = new Query();
        query.delete(table)
             .where(requirement);
        return query(query.getQuery(), param);
    }
    
    public int insert(String table, Object[] params) throws SQLException{
        query = new Query();
        query.insert(table)
             .values(params);
        return query(query.getQuery(), params);
    }
    
    public int update(String table, String[] columns, String requirement, Object[] params) throws SQLException{
        query = new Query();

        query.update(table)
             .set(columns)
             .where(requirement);

        return query(query.getQuery(), params);
    }
    
    public ResultSet select(String table, Object[] columns, Object[] params) throws SQLException{
        return this.select(table, columns,"", params);
    }
    
    public ResultSet select(String table, Object[] columns,String requirement, Object[] params) throws SQLException{
        query = new Query();
        query.select(columns)
             .from(table)
             .where(requirement);
        
        PreparedStatement ps = connection.prepareStatement(query.getQuery());
        if(params != null){
            int index = 1;
            for(Object param:params){
                ps.setObject(index, param);
                index++;
            }
        }
        
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
