/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayMatch;

import Connection.CreateConnection;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Owner
 */
public class CalculateTotalUsers {

    public int getTotalUsers() {
        CreateConnection temp_connection = new CreateConnection();
        Session session = temp_connection.makeSession();
        Query temp_query = session.createSQLQuery("select count(*) from capting_team ");
        List temp_list = temp_query.list();
        Iterator it_list = temp_list.listIterator();
        BigDecimal temp_big = (BigDecimal) it_list.next();
        int totalusers = temp_big.intValue();
        return totalusers;
    }

    /*public static void main(String[] args) {
        CalculateTotalUsers temp = new CalculateTotalUsers();
        System.out.println(temp.getTotalUsers());
    }*/
}
