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
                int [] numbers = new int[strNums.length];
                for (int i = 0; i < strNums.length; i++){
                    numbers[i] = toInt( strNums[i] );
                }
                
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
                    throw new IllegalArgumentException("Negatives not allowed: -1");
                }
                
                return sum(strNums);
            }
            else if(text.contains("\n"))
            {
                String [] numbers = text.split("\n");
                
                return sum(numbers);
            }
            

            return 1;
        }
    }
    
    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
    
    private static int sum(String [] numbers) {
        int total = 0;
        for (String number : numbers)
        {
            total += toInt(number);
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
                String [] numbers = str.split("\n");
                sum += sum(numbers);
            }
            else
            {
                sum += toInt(str);
            }
        }
        return sum;
    }
    
    
}

