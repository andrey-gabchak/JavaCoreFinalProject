/**
 * Created by coura on 14.04.2016.
 *
 * Не ввели значение
 * Ввели символ, не Integer
 * Отрицательное число
 */
public class Validation {

    public boolean isValid(String number){

        try{
            int integerNumber = Integer.parseInt(number);
            if (integerNumber > 0){
                return true;
            }
        } catch (NumberFormatException e){
            System.out.println("[Error] Некорректный ввод! Необходимо ввести положительное целое число!" + e);
        }
        return false;
    }

}
