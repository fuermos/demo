/**
 * @author: he zhi
 * @date: 2019/7/3 10:51
 * @description:
 */
public class Trader{
        private final String name;
        private final String city;

        public Trader(String n, String c){
            this.name=n;
            this.city =c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }

        @Override
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
}
