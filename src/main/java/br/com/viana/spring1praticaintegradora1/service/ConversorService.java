package br.com.viana.spring1praticaintegradora1.service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {

    public String converterDecimalToRomano(int valor){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(valor >= values[i])
            {
                valor = valor - values[i];
                roman.append(romanLetters[i]);
            }
        }

        return roman.toString();
    }

    private int getRomanValueByChar(char c) {
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L')
            return 50;
        if (c == 'C')
            return 100;
        if (c == 'D')
            return 500;
        if (c == 'M')
            return 1000;
        return -1;
    }

    public int converterRomanoToDecimal(String valor) {
        int total = 0;
        for (int i=0; i<valor.length(); i++) {
            int s1 = this.getRomanValueByChar(Character.toUpperCase(valor.charAt(i)));
            if (i+1 <valor.length()) {
                int s2 = this.getRomanValueByChar(Character.toUpperCase(valor.charAt(i+1)));
                if (s1 >= s2) total = total + s1;
                else total = total - s1;
            }
            else{
                total = total + s1;
            }
        }
        return total;
    }
}
