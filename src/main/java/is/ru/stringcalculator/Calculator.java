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
            
            else if(text.contains(","))
            {
                String [] numbers = text.split(",");
                return sum(numbers);
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
    
    
    
}

