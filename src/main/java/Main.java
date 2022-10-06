import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        List<Integer> source = initList();
        List<Integer> result = filterList(source);
        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        for (Integer i: result) {
            System.out.print(" " + i);
        }
        System.out.println();
        logger.log("Завершаем программу");
    }

    private static List<Integer> initList(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        System.out.print("Введите размер списка: ");
        String tempListSize = scanner.nextLine();
        var listSize = Integer.parseInt(tempListSize);
        System.out.print("Введите верхнюю границу для значений: ");
        String tempUpperLimit = scanner.nextLine();
        var upperLimit = Integer.parseInt(tempUpperLimit);
        logger.log("Создаём и наполняем список");
        for (int i = 0; i < listSize; i++){
            list.add(random.nextInt(upperLimit));
        }
        return list;
    }

    private static List<Integer> filterList(List<Integer> source) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        String tempFilterValue = scanner.nextLine();
        int filterValue = Integer.parseInt(tempFilterValue);
        Filter filter = new Filter(filterValue);
        List<Integer> result = filter.filterOut(source);
        return result;
    }

}
