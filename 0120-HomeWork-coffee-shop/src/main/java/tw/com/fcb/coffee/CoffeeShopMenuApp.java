package tw.com.fcb.coffee;

import java.util.Scanner;

public class CoffeeShopMenuApp {
    public static void main(String[] args) {

        int inputNumber;
        int count = 0;
        CoffeeServiceImpl coffeeserviceimpl = new CoffeeServiceImpl();

        Scanner input = new Scanner(System.in);
        System.out.println("======================================================================");
        System.out.println("歡迎光臨第一貴咖啡店，請由下列選項尋找適合的咖啡豆");
        System.out.println("======================================================================");
        System.out.println("1.酒香");
        System.out.println("2.水果香氣");
        System.out.println("3.花香");
        System.out.println("4.即將完售(庫存<=5)");
        System.out.println("5.最便宜");
        System.out.println("0.離開");
        System.out.println("======================================================================");
        System.out.print("請輸入選項 : ");
            try {
                while ((inputNumber = input.nextInt()) != 0) {
                    switch (inputNumber) {
                        case 1:
                            coffeeserviceimpl.getFromTaste("酒").forEach(System.out::println);
                            count = coffeeserviceimpl.getFromTaste("酒").size();
                            break;
                        case 2:
                            coffeeserviceimpl.getFromTaste("果").forEach(System.out::println);
                            count = coffeeserviceimpl.getFromTaste("果").size();
                            break;
                        case 3:
                            coffeeserviceimpl.getFromTaste("花").forEach(System.out::println);
                            count = coffeeserviceimpl.getFromTaste("花").size();
                            break;
                        case 4:
                            coffeeserviceimpl.getFromLowQuantity(5).forEach(System.out::println);
                            count = coffeeserviceimpl.getFromLowQuantity(5).size();
                            break;
                        case 5:
                            coffeeserviceimpl.getLowestPrice().forEach(System.out::println);
                            count = coffeeserviceimpl.getLowestPrice().size();
                            System.out.println("目前本店最便宜的咖啡豆為"+
                                    coffeeserviceimpl.getLowestPrice().get(0).getPrice()+"元");
                            break;
                        default:
                            System.err.println("輸入錯誤，請重新輸入");
                            break;
                    }
                    System.out.println("查詢結果如上，共" + count + "種咖啡豆符合需求，請洽服務人員結帳");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("如有需要，請由下列選項尋找適合的咖啡豆");
                    System.out.println("1.酒香");
                    System.out.println("2.水果香氣");
                    System.out.println("3.花香");
                    System.out.println("4.即將完售(庫存<=5");
                    System.out.println("5.最便宜");
                    System.out.println("0.離開");
                    System.out.println("======================================================================");
                    System.out.print("請輸入選項 : ");
                }
                System.out.println("謝謝惠顧!!");
            }catch (Exception e ){
                System.out.println("你來亂的，請離開");
            }
    }
}
