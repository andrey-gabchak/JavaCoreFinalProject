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
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
