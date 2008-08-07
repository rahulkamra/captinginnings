/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ranking;

import Connection.CreateConnection;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Owner
 */
public class RankingCalc {

    public SortedMap getRankingbetween(int min,int max){
        CreateConnection temp_connection=new CreateConnection();
        Session session=temp_connection.makeSession();
        session.beginTransaction();
        Query temp_query=session.createSQLQuery("select * from (select rank() over(order by ranking_points desc,teamname) ranking,teamname,ranking_points,money from capting_ranking) where ranking>=? and ranking<=?" );
        temp_query.setInteger(0,min);
        temp_query.setInteger(1, max);        
        List temp_list =temp_query.list();
        Iterator it_list=temp_list.listIterator();
        Map rank_map=new HashMap();
        while(it_list.hasNext()){
            RankingBean temp=new RankingBean();
            Object[] temp_obj=(Object[]) it_list.next();
            temp.setTeamname(temp_obj[1].toString());
            temp.setMoney(Integer.parseInt(temp_obj[3].toString()));
            rank_map.put(temp_obj [0],temp);
        }
        SortedMap sorted_map=new TreeMap(rank_map);
        return sorted_map;
    }
    
    public int getTeamRank(String teamname){
        CreateConnection temp_connection=new CreateConnection();
        Session session=temp_connection.makeSession();
        session.beginTransaction();
        Query temp_query=session.createSQLQuery("select * from (select rank() over(order by ranking_points desc,teamname) ranking,teamname,ranking_points from capting_ranking) where teamname=?" );
        temp_query.setString(0, teamname);
        List temp_list=temp_query.list();
        Object[] temp_obj;
        try{
        temp_obj=(Object[]) temp_list.get(0);
        }catch(java.lang.IndexOutOfBoundsException e){
            return -1;
        }
        return Integer.parseInt(temp_obj[0].toString());
    }
   public static void main(String[] args) {
        RankingCalc temp=new RankingCalc();
        SortedMap map=temp.getRankingbetween(1, 5);
        BigDecimal big=new BigDecimal(1);
        RankingBean tempbean=(RankingBean) map.get(big);
        System.out.println(tempbean.getMoney()+tempbean.getTeamname());
    }
}
