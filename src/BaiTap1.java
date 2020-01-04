import java.util.*;

public class BaiTap1 {
    public static void main(String[] args) {
        List<Bill> list = new ArrayList<>();
        list.add(new Bill(1, "a", 1200000, "2020-01-02"));
        list.add(new Bill(2, "b", 2000000, "2020-03-24"));
        list.add(new Bill(1, "a", 3000000, "2020-01-02"));
        list.add(new Bill(3, "a", 400000, "2020-04-23"));
        list.add(new Bill(2, "b", 500000, "2020-01-02"));
        list.add(new Bill(3, "k", 1600000, "2020-03-24"));
        list.add(new Bill(4, "a", 700000, "2020-11-09"));
        Map<String, List<Bill>> map = new HashMap<>();
        System.out.println("Phần 2 : Sắp xếp list integer ");
        List<Integer> integerList = new ArrayList<>();
        List<List<Bill>> listList = new ArrayList<>();
        integerList.add(1);
        integerList.add(9);
        integerList.add(4);
        integerList.add(7);
        integerList.add(2);
        integerList.add(5);
        sortListInteger(integerList);
        System.out.println("Phần 3: sắp xếp list bill");
        sortBill(list);
        System.out.println("Phần 4 : tạo danh sách ngày lập hóa đơn");
        getListDate(list);
        System.out.println("Phần 5:tạo danh sách bill > 1000000 ");
        sortBillVip(list);
        System.out.println("Phần 6:tạo hash map ");
        map = getHashMap(list);
        for(String s : map.keySet()){
            for(Bill bill:map.get(s)){
                System.out.println("Ngày "+s+" "+getString(bill));
            }
        }
        System.out.println("Phần 7: tạo list bao gồm cái list bill cùng ngày :");
        listList = getList(list);
        for(List<Bill> billList :listList){
            for(Bill bill :billList){
                System.out.println(getString(bill));
            }
        }
        System.out.println("Phần 8 : tạo hàm Set theo id và tên : ");
        Set<Bill> billSet = new HashSet<>();
        billSet = getSetBill(list);
        for(Bill bill : billSet){
            System.out.println(getString(bill));
        }





    }


    // Phần 1
    public static void getTotal(int k) {
        int tong = k * (k + 1) / 2;
        System.out.println("Tổng các số tự nhiên liên tiếp từ 0 đến " + k+" là: "+tong);
    }

    public static void getTotal2(int k) {
        int tong = 0;
        for (int i = 0; i < k + 1; i++) {
            tong = tong + i;
        }
        System.out.println("Tổng các số tự nhiên liên tiếp từ 0 đến " + k+" là: "+tong);

    }


    //Phần 2
    public static void sortListInteger(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int x = 0;
                if (list.get(i) > list.get(j)) {
                    x = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, x);
                }
            }
        }
        for(int i :list){
            System.out.print(i+"\t");
        }

    }

    //Phần 3
    public static void sortBill(List<Bill> listbill) {
        for (int i = 0; i < listbill.size(); i++) {
            for (int j = i + 1; j < listbill.size(); j++) {
                Bill bill;
                if (listbill.get(i).getMoney() > listbill.get(j).getMoney()) {
                    bill = listbill.get(i);
                    listbill.set(i, listbill.get(j));
                    listbill.set(j, bill);
                }
            }
        }
        for(Bill bill : listbill){
            System.out.println(getString(bill));
        }

    }

    //Phần 4
    public static void getListDate(List<Bill> list) {
       Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getDate());
        }
        System.out.println(set);
    }

    //Phần 5
    public static void sortBillVip(List<Bill> listbill) {
        List<Bill> list = new ArrayList<>();
        for (int i = 0; i < listbill.size(); i++) {
            if (listbill.get(i).getMoney() > 1000000) {
                list.add(listbill.get(i));
            }
        }
        for(Bill bill :list){
            System.out.println(getString(bill));
        }
    }

    //Phần 6
    public static HashMap<String, List<Bill>> getHashMap(List<Bill> list) {
        Map<String, List<Bill>> map = new HashMap<String, List<Bill>>();
        Set<String> set = new HashSet<>();
        for(Bill bill :list){
            set.add(bill.getDate());
        }
        for(String s : set){
            List<Bill> billList = new ArrayList<>();
            for(Bill bill : list){

                if(bill.getDate().equals(s)){
                    billList.add(bill);
                }
            }
           map.put(s,billList);
        }

        return (HashMap<String, List<Bill>>) map;
    }

    //Phần 7
    public static List<List<Bill>> getList(List<Bill> list) {
        List<List<Bill>> lists = new ArrayList<>();
        Set<String> set = new HashSet<>();
            for(Bill bill :list){
            set.add(bill.getDate());
        }
        for(String s : set){
            List<Bill> billList = new ArrayList<>();
            for(Bill bill : list){

                if(bill.getDate().equals(s)){
                    billList.add(bill);
                }
            }
            lists.add(billList);
        }

        return lists;

    }

//Phương thức hiển thị bill ra String
    public static String getString(Bill bill) {
        return "id: "+bill.getId() + " name: "+bill.getName()+" money: "+bill.getMoney()+" date: "+bill.getDate();
    }


    //Phần 8
    public static Set<Bill> getSetBill(List<Bill> list) {
        Set<Bill> billSet = new HashSet<>();
        for (Bill bill : list) {
            billSet.add(bill);
        }

        return billSet;
    }
}


