/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Adam
 */
public class Query {
    private StringBuilder query;
    
    public Query delete(String table){
        query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(table);
        return this;
    }
    
    public Query from(String table){
        query.append("FROM ");
        query.append(table);
        return this;
    }
    
    public Query where(String requirement){
        query.append(" WHERE ");
        query.append(requirement);
        return this;
    }
    
    public Query update(String table){
        query = new StringBuilder();
        query.append("UPDATE ");
        query.append(table);
        query.append(" SET ");
        return this;
    }
    
    public Query set(String[] columns){
        int count = columns.length;
        if(count == 0)
            throw new IllegalArgumentException("Neplatny pocet parametru");
            
        for(String column:columns){
            query.append(column);
            query.append(" = ");
            query.append("?");
            query.append(",");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        return this;
    }
    
    public Query insert(String table){
        query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(table);
        return this;
    }
    
    public Query values(Object[] params){
        query.append(" VALUES(");
        
        int count = params.length;
        
        if (count==0)
            throw new IllegalArgumentException("Neplatny pocet parametru");
        
        for (int i=0; i<count; i++){
            query.append("?,");
        }
        
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(");");
        return this;
    }
    
    public Query select(Object[] columns){
        query = new StringBuilder();
        query.append("SELECT ");
        if(columns!=null){
            for (Object column : columns){
                query.append(column);
                query.append(",");
            }
            query.deleteCharAt(query.lastIndexOf(","));
        }
        else
            query.append("* ");
        
        return this;
    }
    
    public String getQuery(){
        return query.toString();
    }
}
