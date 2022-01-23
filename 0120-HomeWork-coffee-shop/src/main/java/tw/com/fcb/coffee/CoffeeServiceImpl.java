package tw.com.fcb.coffee;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class CoffeeServiceImpl implements CoffeeService{
    Map<String,Coffee> coffeeShop = new HashMap<String,Coffee>();

    public CoffeeServiceImpl() {
        Coffee coffee1 = new Coffee();
        coffee1.setCoffeeId("AF01");
        coffee1.setCoffeeName("耶加雪夫-果丁丁");
        coffee1.setTaste("花蜜、莓果");
        coffee1.setOrigin("伊索比亞");
        coffee1.setRoast("淺焙");
        coffee1.setProcessType("日曬");
        coffee1.setPrice(380);
        coffee1.setQuantity(24);

        Coffee coffee2 = new Coffee();
        coffee2.setCoffeeId("AF02");
        coffee2.setCoffeeName("西達摩");
        coffee2.setTaste("鳳梨、百香果");
        coffee2.setOrigin("伊索比亞");
        coffee2.setRoast("淺焙");
        coffee2.setProcessType("日曬");
        coffee2.setPrice(480);
        coffee2.setQuantity(20);

        Coffee coffee3 = new Coffee();
        coffee3.setCoffeeId("MU01");
        coffee3.setCoffeeName("新東方-SL28");
        coffee3.setTaste("酒香、糖漬檸檬果皮");
        coffee3.setOrigin("瓜地馬拉");
        coffee3.setRoast("中焙");
        coffee3.setProcessType("水洗");
        coffee3.setPrice(500);
        coffee3.setQuantity(15);

        Coffee coffee4 = new Coffee();
        coffee4.setCoffeeId("IN01");
        coffee4.setCoffeeName("王者曼特寧");
        coffee4.setTaste("藥草、焦糖、太妃糖");
        coffee4.setOrigin("印尼");
        coffee4.setRoast("中焙");
        coffee4.setProcessType("水洗");
        coffee4.setPrice(480);
        coffee4.setQuantity(5);

        Coffee coffee5 = new Coffee();
        coffee5.setCoffeeId("MU02");
        coffee5.setCoffeeName("薇薇特南果");
        coffee5.setTaste("巧克力、菊花茶");
        coffee5.setOrigin("瓜地馬拉");
        coffee5.setRoast("中淺焙");
        coffee5.setProcessType("水洗");
        coffee5.setPrice(380);
        coffee5.setQuantity(35);

        coffeeShop.put(coffee1.getCoffeeId(), coffee1);
        coffeeShop.put(coffee2.getCoffeeId(), coffee2);
        coffeeShop.put(coffee3.getCoffeeId(), coffee3);
        coffeeShop.put(coffee4.getCoffeeId(), coffee4);
        coffeeShop.put(coffee5.getCoffeeId(), coffee5);
    }

    //取得含有該口味的資料
    @Override
    public List<Coffee> getFromTaste(String taste) {
        List<Coffee> result = new ArrayList<Coffee>();
        for (String key : coffeeShop.keySet()){
            Coffee thisCoffee = coffeeShop.get(key);

            if ((thisCoffee.getTaste().contains(taste)) == true){
                result.add(thisCoffee);
            }
        }
//        result.forEach(System.out::println);
        return result;
    }

    @Override
    //取得小於等於該庫存資料
    public List<Coffee> getFromLowQuantity(int quantity){
        List<Coffee> result = new ArrayList<>();
        for (String key : coffeeShop.keySet()){
            Coffee thisCoffee = coffeeShop.get(key);
            if (thisCoffee.getQuantity() <= quantity ){
                result.add(thisCoffee);
            }
        }
        return result;
    }

    @Override
    public List<Coffee> getLowestPrice() {
        String lastKey = "";
        int minValue = 0;

        //先取得最低價格
        for (String key : coffeeShop.keySet()) {
            if (lastKey == "") {
                lastKey = key;
            }
            Coffee thisCoffee = coffeeShop.get(key);
            if (thisCoffee.getPrice() < coffeeShop.get(lastKey).getPrice()) {
                minValue = thisCoffee.getPrice();
            }
        }

        List<Coffee> result = new ArrayList<>();

        //將符合此最低價格的資料皆放入list中，因符合最低價格者可能超過一筆資料
        for (String key : coffeeShop.keySet()) {
            Coffee thisCoffee = coffeeShop.get(key);
            if (thisCoffee.getPrice() <= minValue) {
                result.add(coffeeShop.get(key));
            }
        }
        return  result;
    }
}
