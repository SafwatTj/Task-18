import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListUtilTest {
    private  static List<String> list;
    private static ListUtil listUtil;

    @BeforeEach
    public void tearUp(){
        //System.out.println("---- setUp ---- ");
        list= List.of("jack", "nick", "oleg", "rick");
        listUtil = new ListUtil(list);
    }

    @Test
    @DisplayName("contains(): значение есть в списке -> возвращаем true")
    public void contains_ifValueExists(){
       /*
         1) готовим исходные данные
         2) запускаем тестируемый метод
         3) сравниваем ожидания с результатом

        */

        List<String> list = List.of("jack", "nick", "oleg", "rick");
        ListUtil listUtil = new ListUtil(list);

        boolean actualResult = listUtil.contains("nick");

        Assertions.assertTrue(actualResult);

    }

    @Test
    public void test_contains_ifListNull_shouldReturnFalse(){

        ListUtil listUtil = new ListUtil(null);
        boolean actualResult = listUtil.contains("nick");

        Assertions.assertFalse(actualResult);

    }

    @Test
    public void test_contains_ifValueNotExists_shouldReturnFalse(){

        List<String> list = List.of("jack", "nick", "oleg", "rick");
        ListUtil listUtil = new ListUtil(list);

        boolean actualResult = listUtil.contains("qwer");

        Assertions.assertFalse(actualResult);

    }

    @Test
    @DisplayName("indexOf: в листе есть значение -> возвращаем index ")
    public void indexOf_ifValueExists_shouldReturnIndex(){
        int actualResult = listUtil.indexOf("oleg");
        int expectedResult = 2;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("indexOf: в листе нет значения -> возвращаем -1 ")
    public void indexOf_ifValueNotExists_shouldReturnMinusOne(){
        int actualResult = listUtil.indexOf("oleg2");
        int expectedResult = -1;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("indexOf: в параметр null -> возвращаем -1 ")
    public void indexOf_ifValueNull_shouldReturnMinus1(){
        int actualResult = listUtil.indexOf(null);
        int expectedResult = -1;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("indexOf: в лист null -> возвращаем -2 ")
    public void indexOf_ifListNull_shouldReturnMinus2(){
        ListUtil listUtil1 = new ListUtil(null);
        int actualResult = listUtil1.indexOf("qwerty");
        int expectedResult = -2;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("indexOf: в листе много 100000 строк,значение присутствует->  ")
    public void indexOf_bigListTest(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i<100_000; i++){
            list.add("nameN" + i);
        }

        ListUtil listUtil1 = new ListUtil(list);
        int actualResult = listUtil1.indexOf("nameN90000");
        int expectedResult = 90000;
        Assertions.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void sort(){

        List<String> list = List.of("jack", "nick","sergey","andy", "oleg", "rick");
        List<String> expectedResult = List.of("andy", "jack", "nick", "oleg", "rick", "sergey");
        ListUtil listUtil1 = new ListUtil(list);

        List<String> actualResult = listUtil1.sort();

        Assertions.assertIterableEquals(expectedResult,actualResult);

    }

    @Test
    public void sort2(){

        List<String> list = List.of("jack", "nick","sergey","andy", "oleg", "rick");
        ListUtil listUtil1 = new ListUtil(list);

        List<String> actualResult = listUtil1.sort();

        boolean isSorted = true;
        for (int i = 1; i<actualResult.size(); i++){
            // используем compareTo что бы сравнит (i)-й и (i-1)-й элементы списка
            // если (i-1) больше, получим отрицательное значение т.е. список не сортирован
            if(actualResult.get(i).compareTo(actualResult.get(i-1))<0){
                isSorted = false;
            }
        }


        Assertions.assertTrue(isSorted);

    }



}
