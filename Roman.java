public class Roman {

    private static final String[] Roman= { "I", "IV", "V", "IX", "X","XL","L","XC","C","CX"};
    private static final String[] Roman_input = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    private static final int[] Arab = {1, 4, 5, 9, 10, 40, 50, 90, 100,110};

    public static boolean isRoman(String num)
    {
        for (String a:Roman_input) {
            if(num.equals(a))
            {
                return true;
            }
        }
        return false;
    }

    public static String arabicToRoman(int num)
    {
        String romeNum = "";
        int N = num;

        while ( N > 0 )
        {
            for (int i = 0; i < Arab.length; i++)
            {
                if ( N < Arab[i] )
                {
                    N -= Arab[i-1];
                    romeNum  += Roman[i-1];
                    break;
                }
            }
        }
        return romeNum;
    }

    public static int romanToArabic(String romeNum)
    {
        for (int k = 0; k < Roman_input.length;k++)
        {
            if (romeNum.equals(Roman_input[k]))
            {
                return k+1;
            }
        }
        return 0;
    }
}
