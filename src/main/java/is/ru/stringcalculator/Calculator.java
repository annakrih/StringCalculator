package is.ru.stringcalculator;

public class Calculator {

    public static int add (String text) {
        if(text.equals(""))
        {
            return 0;
        }
        
        
        if(text.length() > 2)
        {
            if(text.charAt(0) == '/' && text.charAt(1) == '/')
           {
                String[] temp = text.split("\n");
                String delim = temp[0].substring(2);
                String[] result = temp[1].split(delim);
                return sum(stringArrToInt(result));
                
            }
        }
        
        
        String [] strNums = splitText(text);
        
        int [] numbers = stringArrToInt (strNums);
        checkForNegativeNums(numbers);
        return sum(numbers);

    }
    
    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
    
    private static int sum(int [] numbers) {
        int total = 0;
        for (int number : numbers)
        {
            if (number <= 1000)
            {
                total += number;
            }
        }
        return total;
    }
    
    private static String[] splitTextWithCommaAndNewLine(String text)
    {
        String [] strings = text.split(",");
        int arrCap = strings.length * 2;
        String [] results = new String[arrCap];
        int n = 0; //indexes used in results[]
        for(String str : strings)
        {
            if(text.contains("\n"))
            {
                String [] numbers = str.split("\n");
                for (String num : numbers)
                {
                    results[n] = num;
                    n++;
                    if(n == arrCap)
                    {
                        arrCap = arrCap*2;
                        results = resizeArray(results, arrCap);
                    }
                }
                
            }
            else
            {
                results[n] = str;
                n++;
                if(n == arrCap)
                {
                    arrCap = arrCap*2;
                    results = resizeArray(results, arrCap);
                }
            }
        }
        return resizeArray(results, n);
    }
    
    private static String[] resizeArray(String[] array, int desiredSize)
    {
        String [] results = new String[desiredSize];
        for(int i = 0; i < desiredSize; i++)
        {
            results[i] = array[i];
        }
        return results;
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
    
    private static String[] splitText(String text)
    {
            
        if(text.contains(",") && text.contains("\n"))
        {
            return splitTextWithCommaAndNewLine(text);
        }
        
        else if(text.contains(","))
        {
            String [] strNums = text.split(",");
            return strNums;
        }
        else if(text.contains("\n"))
        {
            String [] strNums = text.split("\n");
            return strNums;
        }
        
        String [] strNums = new String [1];
        strNums[0] = text;
        return strNums;
    }
    
}

