/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EditTeam;

import Pavallion.AllDetailsBean;
import Team.ElietePojo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Owner
 */
/**
 * 
 * @author Owner
 * Rules Of Eliete Player 
 *      Player Name        Batting Level          Bowling Level     
 *   1. Don Bradman          10                      10
 *   2. Kapil Dev            5                       5
 *   3. Shane Warne          7                       0
 *   4. Glenn Macgrawth      9                       0
 *   5. Micheal Beven        4                       0
 *   6. Arvinda D Silva      3                       0
 *   7. Steve Waugh          4                       0
 *   8. Adam Gilchrist       3                       0
 *   9. Geff Thomson         0                       3
 *   10. Couteny Walsh       0                       6
 *   11. Dennis Lillie       3                       7
 *   12. Wasim Akram         0                       8
 *   13. Malcom Marshal      0                       4
 *   14. Ian Botham          5                       6
 *   15. Andy Flower         4                       0
 *   16. Vivian Richards     7                       0
 *   17. Chris Crains        3                       6
 *   18. Inzmam-Ul -Haq      5                       0 
 * 
 */
public class ElietePlayerSetCreation {

    public Set makeElieteSet(EditTeamForm temp_form, AllDetailsBean alldetails,Set ElieteTeam) {
        Set return_set=new HashSet();
        int myBowlingLevel = alldetails.getBowler_level();
        int myBattingLevel = alldetails.getBatsman_level();
        Map playerDetails=temp_form.getPlayerdetails();
        Iterator itElieteTeam=ElieteTeam.iterator();
        while(itElieteTeam.hasNext()){
            String temp_player=(String) itElieteTeam.next();
            ElietePojo tempPojo=(ElietePojo) playerDetails.get(temp_player);
            int playerBattingLevel=tempPojo.getReqBattingLevel();
            int playerBowlingLevel=tempPojo.getReqBowlingLevel();
            if(myBowlingLevel>=playerBowlingLevel&&myBattingLevel>=playerBattingLevel){
                return_set.add(temp_player);
            }
        }
           return return_set;
    }
}
