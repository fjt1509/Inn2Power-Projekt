/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.bll;

import db.inn2power.bll.IWordSearcher;
import db.inn2power.bll.IWordSearcher;

/**
 *
 * @author Daniels PC
 */
public abstract class QuerySearchTemplate extends IWordSearcher
{
    protected final String query;
    protected final boolean caseSensitive;
    
    public QuerySearchTemplate(String query, boolean caseSensitive)
    {
        this.query = query;
        this.caseSensitive = caseSensitive;
    }
}
