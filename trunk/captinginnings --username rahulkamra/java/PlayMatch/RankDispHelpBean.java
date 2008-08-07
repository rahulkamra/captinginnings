/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PlayMatch;

import java.util.SortedMap;

/**
 *
 * @author Owner
 */
public class RankDispHelpBean {
    private int slot;
    private int toatalusers;
    private int min_current_page_user;
    private int max_current_page_user;
    private SortedMap currentmap;
    

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }


    public int getToatalusers() {
        return toatalusers;
    }

    public void setToatalusers(int toatalusers) {
        this.toatalusers = toatalusers;
    }

    public int getMin_current_page_user() {
        return min_current_page_user;
    }

    public void setMin_current_page_user(int min_current_page_user) {
        this.min_current_page_user = min_current_page_user;
    }

    public int getMax_current_page_user() {
        return max_current_page_user;
    }

    public void setMax_current_page_user(int max_current_page_user) {
        this.max_current_page_user = max_current_page_user;
    }

    public SortedMap getCurrentmap() {
        return currentmap;
    }

    public void setCurrentmap(SortedMap currentmap) {
        this.currentmap = currentmap;
    }

   

    
}
