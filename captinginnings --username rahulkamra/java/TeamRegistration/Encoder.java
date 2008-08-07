/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TeamRegistration;

/**
 *
 * @author Owner
 */
public class Encoder {

    public String convertUtf8toString(String utf8){
        String space="+";
        String left_brackets="%28";
        String right_brackets="%29";
        String right_square_brackets="%5D";
        String left_square_brackets="%5B";
       String temp=utf8.replace(space," ");
       temp=temp.replace(left_brackets,"(");
       temp=temp.replace(right_brackets,")");
       temp=temp.replace(right_square_brackets,"]");
       temp=temp.replace(left_square_brackets,"[");
       
       temp=temp.replace(right_brackets,")");
       if(temp.contains("(")){
           int index=temp.indexOf("(");
           //index++;
           String firstpart=temp.substring(0,index);
           firstpart=firstpart+"(+1)";
             
             temp=firstpart;
       }
        return temp;
    }
    public static void main(String[] args) {
        Encoder temp=new Encoder();
        String temp1=temp.convertUtf8toString("Sachin Tendulkar%5BL%5D");
        System.out.println(temp1);
    }
}
