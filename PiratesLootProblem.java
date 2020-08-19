public class PiratesLootProblem {

    public static void main(String[] args) {
        int[] input = {3,6,2,7,5};

        System.out.println(findDays(input));
        //Output = 2
    }


    //This method will return the number of days after which no loots happen
    static int findDays(int input[]){
        //If there is only one or no ship  then no loot will happen
        if(input.length <=1)
            return 0;

        List<Integer> list = getList(input);

        //No. of days until no loots happen
        int days = 0;
        int shipsDestroyedInOneDay = 0;
       
        //When ships destroyed on current day is not equal to on previous day. If equal it
        //means there are no ships with more loot than the ship to their left.
        while(shipsDestroyedInOneDay != removeShips(list) ){
            days++;
        }
        return days;
    }

    //This method converts int[] to Integer[]
    static List<Integer> getList(int input[]){
        List<Integer> list = new ArrayList<>();

        for (Integer i : input) {
            list.add(Integer.valueOf(i));
        }
        return list;
    }

    //This method will destroy the ship if the loot value of left ship is less.
    static int removeShips(List<Integer> list){
        int shipDestroyedInOneDay = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1) < list.get(i)){
                list.remove(i);
                shipDestroyedInOneDay++;
            }
        }
        return shipDestroyedInOneDay;
    }
}
