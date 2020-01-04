import java.util.*;

public class BaiTap2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("abc");
        list.add("de");
        list.add("f");
        list.add("ghik");

        positionCharacters();
        positionStrings();
        findCharacters();
        subStrings();
        appendStrings(list);
        list1 = separateStrings("abc,de,ghij,klmn");
        for (String s : list1) {
            System.out.println(s);
        }
        String s = editStrings();
        System.out.println(s);


    }

    // Phần 1 : 2 phương thức tương ứng với ký tự và chuỗi ký tự
    public static void positionCharacters() {
        String chuoi;
        String kytu;
        int vitri;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ban đầu : ");
        chuoi = scanner.nextLine();
        System.out.println("Nhập ký tự : ");
        kytu = scanner.nextLine();
        System.out.println("nhập vị trí :");
        vitri = scanner.nextInt();
        if (!chuoi.contains(kytu)) {
            System.out.println("ký tự bạn vừa nhập không có trong chuỗi, vui lòng nhập lại.");
        } else {
            int dem = 0;
            int vtd = 0;
            int vtc = 0;
            int vtrd = 0;
            int d = 0;
            for (int i = 0; i < chuoi.length() - 1; i++) {

                if (chuoi.substring(i, i + 1).equals(kytu)) {
                    dem = dem + 1;
                }
            }
            System.out.println("Số lần xuất hiện trong chuỗi của ký tự trên là : " + dem);

            for (int i = 0; i < chuoi.length() - 1; i++) {
                if (chuoi.substring(i, i + 1).equals(kytu)) {
                    vtd = i;
                    System.out.println("Vị trí đầu tiên là " + vtd);
                    break;

                }
            }
            for (int i = 0; i < chuoi.length() - 1; i++) {
                if (chuoi.substring(i, i + 1).equals(kytu)) {
                    vtc = i;

                }
            }
            System.out.println("Vị trí cuối là : " + vtc);
            for (int i = 0; i < chuoi.length() - 1; i++) {

                if (chuoi.substring(i, i + 1).equals(kytu)) {
                    d = d + 1;
                    if (d == vitri) {
                        vtrd = i;
                        break;


                    }
                }
            }
            if (vtrd == 0) {
                System.out.println("không có vị trí thứ " + vitri + " trong chuỗi này");
            } else {
                System.out.println("Vị trí thứ  " + vitri + " trong chuỗi của ký tự là : " + vtrd);

            }


        }

    }

    public static void positionStrings() {
        String chuoi;
        String chuoicon;
        int vitri;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ban đầu : ");
        chuoi = scanner.nextLine();
        System.out.println("Nhập chuỗi ký tự : ");
        chuoicon = scanner.nextLine();
        System.out.println("nhập vị trí :");
        vitri = scanner.nextInt();
        if (!chuoi.contains(chuoicon)) {
            System.out.println("chuỗi ký tự bạn vừa nhập không có trong chuỗi ban đầu, vui lòng nhập lại.");
        } else {
            int dem = 0;
            int vtd = 0;
            int vtc = 0;
            int vtrd = 0;
            int d = 0;
            for (int i = 0; i < chuoi.length() - chuoicon.length(); i++) {

                if (chuoi.substring(i, i + chuoicon.length()).equals(chuoicon)) {
                    dem = dem + 1;
                }
            }
            System.out.println("Số lần xuất hiện trong chuỗi của chuỗi con trên là : " + dem);

            for (int i = 0; i < chuoi.length() - chuoicon.length(); i++) {
                if (chuoi.substring(i, i + chuoicon.length()).equals(chuoicon)) {
                    vtd = i;
                    System.out.println("Vị trí đầu tiên là " + vtd);
                    break;

                }
            }
            for (int i = 0; i < chuoi.length() - chuoicon.length(); i++) {
                if (chuoi.substring(i, i + chuoicon.length()).equals(chuoicon)) {
                    vtc = i;

                }
            }
            System.out.println("Vị trí cuối là : " + vtc);
            for (int i = 0; i < chuoi.length() - chuoicon.length(); i++) {

                if (chuoi.substring(i, i + chuoicon.length()).equals(chuoicon)) {
                    d = d + 1;
                    if (d == vitri) {
                        vtrd = i;
                        break;


                    }
                }
            }
            if(vtrd==0){
                System.out.println("không có vị trí thứ " + vitri + " trong chuỗi này");

            }else {
                System.out.println("Vị trí thứ  " + vitri + " trong chuỗi của ký tự là : " + vtrd);

            }

        }


    }

    // Phần 2
    public static void findCharacters() {
        String chuoi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ban đầu : ");
        chuoi = scanner.nextLine();
        int max = 0;
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < chuoi.length(); i++) {
            if (countCharacters(chuoi, chuoi.charAt(i)) > max) {
                max = countCharacters(chuoi, chuoi.charAt(i));
            }
        }
        for (int i = 0; i < chuoi.length(); i++) {
            if (countCharacters(chuoi, chuoi.charAt(i)) == max) {
                stringSet.add(Character.toString(chuoi.charAt(i)));

            }
        }

        System.out.println("chữ cái xuất hiện nhiều nhất là : " + "\n");
        System.out.println(stringSet);
        System.out.println("số lần xuất hiện " + max);


    }

    public static void subStrings() {
        String chuoi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ban đầu : ");
        chuoi = scanner.nextLine();
        Set<String> stringSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chuoi.length(); i++) {
            for (int j = 1; j < chuoi.length() - i + 1; j++) {
                stringSet.add(chuoi.substring(i, i + j));
            }
        }
        for (String s : stringSet) {
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            int dem = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).contains(list.get(i))) {
                    dem = dem + 1;
                }
            }
            System.out.println(list.get(i) + " số lần xuất hiện: " + dem);
        }
    }

    //Phần 3
    public static void appendStrings(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            stringBuilder.append(list.get(i) + ",");
        }
        stringBuilder.append(list.get(list.size() - 1));
        System.out.println(stringBuilder.toString());
    }

    //Phần 4
    public static List<String> separateStrings(String chuoi) {
        List<String> list = new ArrayList<>();
        do {
            for (int i = 0; i < chuoi.length(); i++) {
                if (chuoi.charAt(i) == ',') {
                    list.add(chuoi.substring(0, i));
                    chuoi = chuoi.substring(i + 1, chuoi.length());
                    break;
                }
            }
        }
        while (chuoi.contains(","));
        list.add(chuoi);
        return list;
    }

    //Phần 5
    public static String editStrings() {
        String raw, from, to, result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ban đầu : ");
        raw = scanner.nextLine();
        System.out.println("Nhập chuỗi bị thay thế : ");
        from = scanner.nextLine();
        System.out.println("Nhập chuỗi thay thế : ");
        to = scanner.nextLine();
        result = raw.replaceAll(from, to);
        return result;
    }


    // phương thức tính số lần xuất hiện của ký tự trong chuỗi
    public static int countCharacters(String chuoi, char s) {
        int dem = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == s) {
                dem = dem + 1;
            }
        }
        return dem;
    }
}


