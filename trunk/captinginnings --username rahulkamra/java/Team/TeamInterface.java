/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Team;

/**
 *
 * @author Owner
 */
public interface TeamInterface {
    String playername="null";
    int total=-1;
    int slogger=-1;
    int strike_rotator=-1;
    int driver=-1;
    int puller=-1;
    int cutter=-1;
    int leg_spinner=-1;
    int off_spinner=-1;
    int chinaman=-1;
    int fast=-1;
    int medium=-1;

    public String getPlayername();
        

    public void setPlayername(String playername); 

    public int getTotal();
        

    public void setTotal(int total); 
        

    public int getSlogger(); 
        

    public void setSlogger(int slogger); 
        

    public int getStrike_rotator(); 
       

    public void setStrike_rotator(int strike_rotator);
       

    public int getDriver();
        

    public void setDriver(int driver);
        

    public int getPuller();
       

    public void setPuller(int puller);
       

    public int getCutter();
        

    public void setCutter(int cutter);
        

    public int getLeg_spinner();
        

    public void setLeg_spinner(int leg_spinner);
        

    public int getOff_spinner();
       

    public void setOff_spinner(int off_spinner);
       

    public int getChinaman();
        

    public void setChinaman(int chinaman);
        
    public int getFast();
        

    public void setFast(int fast);
        

    public int getMedium();
        

    public void setMedium(int medium);
        
}

