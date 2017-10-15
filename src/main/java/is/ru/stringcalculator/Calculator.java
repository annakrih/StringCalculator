package is.ru.stringcalculator;

public class Calculator {

    public static int add (String text) {
        if(text.equals(""))
        {
            return 0;
        }
        else
        {
            if(text.contains(",") && text.contains("\n"))
            {
                return addTextWithCommasAndNewLine(text);
            }
            
            else if(text.contains(","))
            {
                String [] strNums = text.split(",");
                int [] numbers = stringArrToInt (strNums);
                checkForNegativeNums(numbers);
                return sum(numbers);
            }
            else if(text.contains("\n"))
            {
                String [] strNums = text.split("\n");
                int [] numbers = stringArrToInt (strNums);
                checkForNegativeNums(numbers);
                return sum(numbers);
            }
            

            return 1;
        }
    }
    
    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
    
    private static int sum(int [] numbers) {
        int total = 0;
        for (int number : numbers)
        {
            total += number;
        }
        return total;
    }
    
    private static int addTextWithCommasAndNewLine(String text)
    {
        String [] strings = text.split(",");
        int sum = 0;
        for(String str : strings)
        {
            if(text.contains("\n"))
            {
                int [] numbers = stringArrToInt(str.split("\n"));
                sum += sum(numbers);
            }
            else
            {
                sum += toInt(str);
            }
        }
        return sum;
    }
    
    private static void checkForNegativeNums(int [] numbers)
    {
        int [] negativeNums = new int [numbers.length];
        int N = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] < 0)
            {
                negativeNums[N] = numbers[i];
                N++;
            }
        }

        if(N > 0)
        {
            String message = "Negatives not allowed: ";
            message += negativeNums[0];
            for(int i = 1; i < N; i++)
            {
                message = message + "," + negativeNums[i];
            }
            throw new IllegalArgumentException(message);
        }
    }
    
    private static int [] stringArrToInt(String[] strings)
    {
        int [] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++){
            numbers[i] = toInt( strings[i] );
        }
        return numbers;
    }
    
    
}

