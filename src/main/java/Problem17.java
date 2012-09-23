import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: shevchik
 * Date: 22.09.12
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
public class Problem17 {
    private static HashMap<Integer,Integer> units      = new HashMap<Integer, Integer>();
    static {
        units.put(1, DIGITS.ONE.getLength());
        units.put(2, DIGITS.TWO.getLength());
        units.put(3, DIGITS.THREE.getLength());
        units.put(4, DIGITS.FOUR.getLength());
        units.put(5, DIGITS.FIVE.getLength());
        units.put(6, DIGITS.SIX.getLength());
        units.put(7, DIGITS.SEVEN.getLength());
        units.put(8, DIGITS.EIGHT.getLength());
        units.put(9, DIGITS.NINE.getLength());
        units.put(10, DIGITS.TEN.getLength());
        units.put(11, DIGITS.ELEVEN.getLength());
        units.put(12, DIGITS.TWELVE.getLength());
        units.put(13, DIGITS.THIRTEEN.getLength());
        units.put(14, DIGITS.FOURTEEN.getLength());
        units.put(15, DIGITS.FIFTEEN.getLength());
        units.put(16, DIGITS.SIXTEEN.getLength());
        units.put(17, DIGITS.SEVENTEEN.getLength());
        units.put(18, DIGITS.EIGHTEEN.getLength());
        units.put(19, DIGITS.NINETEEN.getLength());

        units.put(20, DIGITS.TWENTY.getLength());
        units.put(30, DIGITS.THIRTY.getLength());
        units.put(40, DIGITS.FORTY.getLength());
        units.put(50, DIGITS.FIFTY.getLength());
        units.put(60, DIGITS.SIXTY.getLength());
        units.put(70, DIGITS.SEVENTY.getLength());
        units.put(80, DIGITS.EIGHTY.getLength());
        units.put(90, DIGITS.NINETY.getLength());

        units.put(100, DIGITS.HUNDRED.getLength());
        units.put(1000, DIGITS.THOUSAND.getLength());
    }
    public static void main(String[] args) {
        int s;
        s=0;
        for(int i=1;i<1001;i++){
            s+= length(i);
        }
        System.out.println(s);

    }
    public static int length(int n){
        if(n==1000){
            return units.get(1000)+3;
        }
        else
        if(n < 20){                                                // 1..19
            return units.get(n);
        }
        else
        if((n%10==0) &&(n<100)){                                  // 20,30,40...90

            return units.get(n);
        }
        else                                                      //21 ... 99
        if((n >= 20) && ( n < 100)){
            return units.get(Integer.parseInt(Integer.toString(n).substring(0,1))*10)+
                   units.get(Integer.parseInt(Integer.toString(n).substring(1,2))); // twenty-one, thirty-two
        }
        else
        if(n%100 == 0){                                           // 100, 200 ... 900
            return units.get(Integer.parseInt(Integer.toString(n).substring(0,1)))+
                   units.get(100);
            }
        else
        if(n%100<20){
            // 100 < x < 120
            return units.get(Integer.parseInt(Integer.toString(n).substring(0,1)))+
                   units.get(100)+
                   units.get(n%100)+3;
        }
        else
        if(n%10==0){                                              // 120,130...190
            return units.get(Integer.parseInt(Integer.toString(n).substring(0,1)))+
                   units.get(100)+
                   units.get(n%100) +3;
        }
        else{
            return  units.get(Integer.parseInt(Integer.toString(n).substring(0,1)))+
                    units.get(100)+
                    units.get(Integer.parseInt(Integer.toString(n).substring(1,2))*10)+
                    units.get(Integer.parseInt(Integer.toString(n).substring(2,3)))+3;
        }

    }

    enum DIGITS{
        ONE(3),TWO(3),THREE(5),FOUR(4),FIVE(4),SIX(3),SEVEN(5),EIGHT(5),NINE(4),TEN(3),
        ELEVEN(6),TWELVE(6),THIRTEEN(8),FOURTEEN(8),FIFTEEN(7),SIXTEEN(7),SEVENTEEN(9),EIGHTEEN(8),NINETEEN(8),
        TWENTY(6),THIRTY(6),FORTY(5),FIFTY(5),SIXTY(5),SEVENTY(7),EIGHTY(6),NINETY(6),HUNDRED(7),THOUSAND(8);
        private int length;
        DIGITS(int l){
            this.length = l;
        }
        public int getLength() {
            return length;
        }
        public void setLength(int length) {
            this.length = length;
        }
    }

}
